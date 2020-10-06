package com.mayab.calidad.doubles.tareaUnitTest;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Stack;


import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;


public class TestTransactions {

	private DAOImplementation database;
	private Account account;
	
	
	@Before 
	public void setupMocks() {
		database = mock(DAOImplementation.class); // create my database mock
		account = new Account("Esteban", 1000, 1); //create an account
		setupDatabase(); //this implements the getDatabase() method for database
		addTransactionAnswer(); // implements the Answer method for addTransaction
	}
	
	//Implements the getDatabase() Getter from DAOImplementation
	
	public void setupDatabase() {
		when(database.getDatabase()).thenReturn(new Stack<Transaction>());
	}
	
	//Implements the addTransaction(Transaction) from DAOImplementation 
	// this is in a function to avoid repeating code in the Fees Test
	
	public void addTransactionAnswer() {
		
		when(database.addTransaction(any(Transaction.class))).thenAnswer(new Answer<Boolean>() {
			
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
			 Transaction arg = (Transaction) invocation.getArguments()[0];
			 database.getDatabase().push(arg);
			 return false;
			}
			
		});
		
	}
	
	
	// Tests the addition of transactions to the database. Answer code above in seperate function.
	
	@Test
	public void addTransactionTest() {
		
	int initialSize = database.getDatabase().size(); //stores the initial size
	database.addTransaction(account.credit(500));
	
	database.addTransaction(account.debit(100));
	
	database.addTransaction(account.debit(1000));
	
	assertThat(database.getDatabase().size(), is( initialSize + 3));
	
	}

	
	// Test the calculation of fees on the transactions in the database.
	// needs the implementation of addTransaction(Transaction) to test.
	
	@Test
	public void calculateFeesTest() {
		
	when(database.calculateFees()).thenAnswer(new Answer<Double>() {
			
			public Double answer(InvocationOnMock invocation) throws Throwable {
			 
				double fees = 0.0;
				for(Transaction transaction : database.getDatabase()) {
					fees += transaction.getFee();
					//System.out.print(fees);
				}
			 
			 return fees;
			}
			
		});
	// account is on zone 1 = 1%
	database.addTransaction(account.credit(500));
	database.addTransaction(account.debit(100));
	database.addTransaction(account.debit(1000));
	// FEES = 5 + 1 + 10 = 16
	
	assertThat(database.calculateFees(), is(16.0));
	
	}
	
	
	
}
