package uk.co.barclays.openminds.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BankAccounts {

	private List<BankAccount> accounts;
	
}
