package uk.co.barclays.openminds.model;

import org.joda.time.DateTime;

public class Transaction {
	
	private DateTime date;
	private String descriotion;
	private long amount;
	private BankAccount account;
	private boolean cleared;
	private long balance;

}
