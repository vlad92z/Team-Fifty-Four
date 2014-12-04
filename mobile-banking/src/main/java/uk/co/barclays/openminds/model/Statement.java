package uk.co.barclays.openminds.model;

import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Statement {
	private List<Transaction> transactions;
	private DateTime start;
	private DateTime end;
	
}
