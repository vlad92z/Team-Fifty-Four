package uk.co.barclays.openminds.model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class StatementTest {

	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException {
		Statement statement = Statement.readStatement("D:\\workspace\\Team-Fifty-Four\\data\\convertcsv.json");
		for (Transaction t : statement.getTransactions()){
			System.out.println(t);
		}
	}

}
