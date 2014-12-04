package uk.co.barclays.openminds.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BankAccounts {

	private List<BankAccount> accounts;

	public BankAccounts(List<BankAccount> accounts) {
		super();
		this.accounts = new ArrayList<BankAccount>();
	}

	public BankAccounts() {
		super();
	}

	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

}
