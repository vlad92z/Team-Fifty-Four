package uk.co.barclays.openminds.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingOrder {

	private String name;
	private long amount;
	private DateTime date;
	private Frequency frequency;
	private BankAccount account;
	private String descriotion;

	public enum Frequency {
		DAILLY, WEEKLY, MONTHLY, YEARLY
	}

	public StandingOrder(String name, long amount, DateTime date,
			Frequency frequency, BankAccount account, String descriotion) {
		super();
		this.name = name;
		this.amount = amount;
		this.date = date;
		this.frequency = frequency;
		this.account = account;
		this.descriotion = descriotion;
	}

	public StandingOrder() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	public String getDescriotion() {
		return descriotion;
	}

	public void setDescriotion(String descriotion) {
		this.descriotion = descriotion;
	}

	@Override
	public String toString() {
		return "StandingOrder [name=" + name + ", amount=" + amount + ", date="
				+ date + ", frequency=" + frequency + ", account=" + account
				+ ", descriotion=" + descriotion + "]";
	}
	
	

}
