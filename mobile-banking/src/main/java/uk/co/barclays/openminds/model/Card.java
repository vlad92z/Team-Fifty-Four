package uk.co.barclays.openminds.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {
	
	private String name;
	private enum Type {
	    VISA, MASTER, MAESTRO, AMERICAN_EXPRESS, CREDIT, DEBIT
	}
	private Type type;
	private String number;
	private DateTime expires;

}
