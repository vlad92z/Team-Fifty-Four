package uk.co.barclays.openminds.model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class BankAccountTest {

	@Test
	public void test() throws JsonParseException, JsonMappingException,
			IOException {
		BankAccount bankAccount = BankAccount.getInstance();
		System.out.println(bankAccount);
	}

}
