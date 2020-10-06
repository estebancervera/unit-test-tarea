package com.mayab.calidad.doubles.tareaUnitTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.Console;

import org.junit.Before;
import org.junit.Test;



public class TestAlerts {

	private Account account;
	private AlertListener  alert;
	
	@Before
	public void setUp() {
		alert = mock(AlertListener.class);
		account = new Account("Esteban", 90, alert, 1);
	}

	@Test
	public void AlertUnder100balanceTest() {
		
		Transaction transaction = account.debit(55);
		System.out.println(transaction);
		verify(alert).sendAlert(account.getHolder() + ", your account balance is below 100");
		
	}

}
