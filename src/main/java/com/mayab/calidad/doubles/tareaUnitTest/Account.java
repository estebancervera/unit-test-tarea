package com.mayab.calidad.doubles.tareaUnitTest;

import java.util.UUID;


public class Account {
    
	private String id;
	private int balance;
   	private  String holder;
    private int zone;
    AlertListener alerts;
    

    
    
    public Account(String holder, int initialBalance, int zone) {
    	this.holder = holder;
    	this.balance = initialBalance;
    	this.zone = zone;
    	this.id = holder + holder.length();
    }

    public Account(String holder, int initialBalance, AlertListener alerts, int zone){
        this.holder = holder;
        this.balance = initialBalance;
        this.alerts = alerts;
        this.id = holder + holder.length();
        this.zone = zone;
    }
    
    public int getBalance() {
        return this.balance;
    }
    
    public String getHolder(){
        return this.holder;
    }
    
    public int getZone() {
		return zone;
	}

   public Transaction debit(int balance) {
        this.balance -= balance;
        //System.out.println("a1");
        if(this.balance < 100){
        	// System.out.println("a2");
        	// System.out.println(this.alerts);
            this.alerts.sendAlert(this.holder + ", your account balance is below 100");
            //System.out.println("a3");
        }
       // System.out.println("a4");
        //System.out.println(balance);
        return new Transaction(this, balance, false);
    }

    public Transaction credit(int balance) {
        this.balance += balance;
        return new Transaction(this, balance, true);
    }
    
    void setAlertListener(AlertListener listener){
        this.alerts = listener;
    }
    
    @Override
    public boolean equals(Object obj) {
    	// TODO Auto-generated method stub
    	Account acc = (Account) obj;
    	if (this.id.equals(acc.id)) {
    		//System.out.println(this.id);
    		return true;
    	}
    	//System.out.println(this.id);
		//System.out.println(acc.id);
    	
    	return false;
    }
    
    
    
}