package uk.co.barclays.openminds.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {
	
	private DateTime date;
	private String description;
	private String type;
	private long debit;
	private long credit;
	private long amount;
	private BankAccount account;
	private boolean cleared;
	private long balance;
	private Category category;

}
