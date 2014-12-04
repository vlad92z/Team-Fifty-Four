package uk.co.barclays.openminds.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BankAccount {
	
	private String name;
	private String accountNumbert;
	private String sortCode;
	private String IBAN;
	private String BIC;
	private List<Transaction> transactions;
	private long balanace;
	private long available;
	private long reserved;
	private String currency;
	private List<Card> attachedCards;
	private List<StandingOrder> standingOrders;
	private AccountHolder owner;
	
}
