package uk.co.barclays.openminds.model;

import java.util.ArrayList;
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

	public BankAccount(String name, String accountNumbert, String sortCode,
			String iBAN, String bIC, List<Transaction> transactions,
			long balanace, long available, long reserved, String currency,
			List<Card> attachedCards, List<StandingOrder> standingOrders,
			AccountHolder owner) {
		super();
		this.name = name;
		this.accountNumbert = accountNumbert;
		this.sortCode = sortCode;
		IBAN = iBAN;
		BIC = bIC;
		this.transactions = transactions;
		this.balanace = balanace;
		this.available = available;
		this.reserved = reserved;
		this.currency = currency;
		this.attachedCards = attachedCards;
		this.standingOrders = standingOrders;
		this.owner = owner;
	}

	public BankAccount() {
		super();
		this.transactions = new ArrayList<Transaction>();
		this.attachedCards = new ArrayList<Card>();
		this.standingOrders = new ArrayList<StandingOrder>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumbert() {
		return accountNumbert;
	}

	public void setAccountNumbert(String accountNumbert) {
		this.accountNumbert = accountNumbert;
	}

	public String getSortCode() {
		return sortCode;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	public String getBIC() {
		return BIC;
	}

	public void setBIC(String bIC) {
		BIC = bIC;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public long getBalanace() {
		return balanace;
	}

	public void setBalanace(long balanace) {
		this.balanace = balanace;
	}

	public long getAvailable() {
		return available;
	}

	public void setAvailable(long available) {
		this.available = available;
	}

	public long getReserved() {
		return reserved;
	}

	public void setReserved(long reserved) {
		this.reserved = reserved;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public List<Card> getAttachedCards() {
		return attachedCards;
	}

	public void setAttachedCards(List<Card> attachedCards) {
		this.attachedCards = attachedCards;
	}

	public List<StandingOrder> getStandingOrders() {
		return standingOrders;
	}

	public void setStandingOrders(List<StandingOrder> standingOrders) {
		this.standingOrders = standingOrders;
	}

	public AccountHolder getOwner() {
		return owner;
	}

	public void setOwner(AccountHolder owner) {
		this.owner = owner;
	}

}
