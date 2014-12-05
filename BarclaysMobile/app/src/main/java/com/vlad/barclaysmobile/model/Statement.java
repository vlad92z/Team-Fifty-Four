package com.vlad.barclaysmobile.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import uk.co.barclays.openminds.util.Util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Statement {
	private List<Transaction> transactions;
	private DateTime start;
	private DateTime end;
	private static Statement statement = null;

	public Statement(List<Transaction> transactions, DateTime start,
			DateTime end) {
		super();
		this.transactions = transactions;
		this.start = start;
		this.end = end;
	}

	public Statement(DateTime start, DateTime end) {
		super();
		this.transactions = new ArrayList<Transaction>();
		this.start = start;
		this.end = end;
	}

	public Statement() {
		super();
		this.start = new DateTime();
		this.end = new DateTime();
		this.transactions = new ArrayList<Transaction>();
	}

	public static Statement getInstance()
			throws JsonParseException, JsonMappingException, IOException {
		return readInstance("../../../../../convertcsv.json");
	}
	
	public static Statement readInstance(String filename)
			throws JsonParseException, JsonMappingException, IOException {
		if (statement == null)
			statement = Util.mapper.readValue(Statement.class.getResource(filename), Statement.class);
		return statement;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public DateTime getStart() {
		return start;
	}

	public void setStartDate(DateTime start) {
		this.start = start;
	}

	public void setStart(String start) {
		this.start = DateTime.parse(start,
				DateTimeFormat.forPattern("dd/MM/yyyy"));
	}

	public DateTime getEnd() {
		return end;
	}

	public void setEndDate(DateTime end) {
		this.end = end;
	}

	public void setEnd(String end) {
		this.start = DateTime.parse(end,
				DateTimeFormat.forPattern("dd/MM/yyyy"));
	}

	@Override
	public String toString() {
		return "Statement [transactions=" + transactions + ", start=" + start
				+ ", end=" + end + "]";
	}


}
