package com.mayab.calidad.doubles.tareaUnitTest;


import java.util.Stack;

public class DAOImplementation implements DAO {

	private Stack<Transaction> database = new Stack<Transaction>();
	
	@Override
	public boolean addTransaction(Transaction tran) {
		// TODO Auto-generated method stub
		return false;
		
	}

	@Override
	public double calculateFees() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Stack<Transaction> getDatabase() {
		return database;
	}

}
