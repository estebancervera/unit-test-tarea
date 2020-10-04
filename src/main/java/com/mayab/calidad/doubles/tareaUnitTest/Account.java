package com.mayab.calidad.doubles.tareaUnitTest;


public class Account {
    
	private int balance;
   	private  String holder;
    private int zone;
    AlertListener alerts;
    
    public Account(String holder, int initialBalance, int zone) {
    	this.holder = holder;
    	this.balance = initialBalance;
    	this.zone = zone;
    }

    public Account(String holder, int initialBalance, AlertListener alerts){
        this.holder = holder;
        this.balance = initialBalance;
        this.alerts = alerts;
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

    void debit(int balance) {
        this.balance -= balance;
        if(this.balance < 100){
            this.alerts.sendAlert(this.holder+", your account balance is below 100");
        }
    }

    void credit(int balance) {
        this.balance += balance;
    }
    
    void setAlertListener(AlertListener listener){
        this.alerts = listener;
    }
    
    
}