package com.mayab.calidad.doubles.tareaUnitTest;

import java.util.UUID;

public class Transaction {
	
	private static UUID id = UUID.randomUUID();
	private Account account;
	private double quantity;
	private double fee;
	private boolean isCredit;
	
	
	public Transaction(Account account, double quantity, boolean isCredit) {
		// TODO Auto-generated constructor stub
		this.account = account;
		this.quantity = quantity;
		this.fee = Zone.zones.get(account.getZone()) * quantity ;
		this.isCredit = isCredit;
	}
	
	public double getFee() {
		return fee;
	}
	
}
