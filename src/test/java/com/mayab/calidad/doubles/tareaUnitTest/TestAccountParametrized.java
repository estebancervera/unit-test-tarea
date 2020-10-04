package com.mayab.calidad.doubles.tareaUnitTest;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestAccountParametrized {
	//Parameters
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object [][] {
			{1000,"Esteban",1, new Account("Esteban", 1000, 1)},
			{300,"Andoni",2, new Account("Andoni", 300,  2)}, 
			{200,"Luis",3, new Account("Luis", 200, 3)}
		});
	}

	private int balance;
	private String holder;
	private int zone;
	private Account expected;
	
	//Initialization
	public TestAccountParametrized(int balance, String holder, int zone, Account expected) {
		this.balance = balance;
		this.holder = holder;
		this.zone = zone;
		this.expected = expected;
	}
	
	
	//TESTS
	
	@Test
	public void AccountCreationTest() {
		assertThat(expected, is(new Account(holder, balance, zone)));
	}

}
