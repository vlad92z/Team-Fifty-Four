package uk.co.barclays.openminds.model;

import org.joda.time.DateTime;

public class StandingOrder {
	
	private String name;
	private long amount;
	private DateTime date;
	
	public enum Frequency {
		DAILLY, WEEKLY, MONTHLY, YEARLY
	}
	
	private Frequency frequency;
	
	private BankAccount account;
	
	private String descriotion;

}
