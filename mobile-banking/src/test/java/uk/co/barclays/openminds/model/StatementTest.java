package uk.co.barclays.openminds.model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class StatementTest {

	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException {
		Statement statement = Statement.getInstance();
		for (Transaction t : statement.getTransactions()){
			System.out.println(t);
		}
	}
	
	@Test
	public void test2() throws JsonParseException, JsonMappingException, IOException {
	/*	Statement statement = Statement.readInstance("../../../../../convertcsv.json");
		for (Transaction t : statement.getTransactions()){
			System.out.println(t);
		}*/
	}
	
	

}
