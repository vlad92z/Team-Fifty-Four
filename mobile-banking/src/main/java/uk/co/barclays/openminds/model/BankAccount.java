package uk.co.barclays.openminds.model;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import uk.co.barclays.openminds.util.Util;
import uk.co.barclays.openminds.model.Card.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BankAccount {

	private String name;
	private String accountNumbert;
	private String sortCode;
	private String IBAN;
	private String BIC;
	private List<Transaction> transactions;
	private Double balanace;
	private Double available;
	private Double reserved;
	private String currency;
	private List<Card> attachedCards;
	private List<StandingOrder> standingOrders;
	private AccountHolder owner;
	private static BankAccount account;

	public BankAccount(String name, String accountNumbert, String sortCode,
			String iBAN, String bIC, List<Transaction> transactions,
			Double balanace, Double available, Double reserved,
			String currency, List<Card> attachedCards,
			List<StandingOrder> standingOrders, AccountHolder owner) {
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

	public static BankAccount getInstance() throws JsonParseException,
			JsonMappingException, IOException {
		if (account == null) {
			account = new BankAccount("Current Account", "98765432",
					"12-34-56", "GB55BARC12345698765432", "BARCGB22", Statement
							.readInstance("../../../../../convertcsv.json").getTransactions(), new Double(
							1465.23), new Double(1442.99), new Double(22.24),
					"£", new ArrayList<Card>(), new ArrayList<StandingOrder>(),
					new AccountHolder("John", "Doe"));
			account.getAttachedCards().add(
					new Card("John Doe", Type.VISA, "4356 9816 8546 1176",
							new DateTime().plusYears(2)));
		}
		return account;
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

	public Double getBalanace() {
		return balanace;
	}

	public void setBalanace(Double balanace) {
		this.balanace = balanace;
	}

	public Double getAvailable() {
		return available;
	}

	public void setAvailable(Double available) {
		this.available = available;
	}

	public Double getReserved() {
		return reserved;
	}

	public void setReserved(Double reserved) {
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

	public Statement createStatement(DateTime start, DateTime end) {
		Statement statement = new Statement(start, end);
		for (Transaction t : transactions) {
			if (t.compareDate(start) >= 0 && t.compareDate(end) <= 0) {
				statement.getTransactions().add(t);
			}
		}
		return statement;
	}

	@Override
	public String toString() {
		return "BankAccount [name=" + name + ", accountNumbert="
				+ accountNumbert + ", sortCode=" + sortCode + ", IBAN=" + IBAN
				+ ", BIC=" + BIC + ", transactions=" + transactions
				+ ", balanace=" + balanace + ", available=" + available
				+ ", reserved=" + reserved + ", currency=" + currency
				+ ", attachedCards=" + attachedCards + ", standingOrders="
				+ standingOrders + ", owner=" + owner + "]";
	}
	
	

}
