package uk.co.barclays.openminds.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {

	public enum Type {

		VISA("Visa"), MASTER("Master"), MAESTRO("Maestro"), AMERICAN_EXPRESS(
				"American_express"), CREDIT("Credit"), DEBIT("Debit");

		private String text;

		Type(String text) {
			this.text = text;
		}

		public String getText() {
			return this.text;
		}

		public static Type fromString(String text) {
			if (text != null) {
				for (Type b : Type.values()) {
					if (text.equalsIgnoreCase(b.text)) {
						return b;
					}
				}
			}
			return DEBIT;
		}
	}

	private String name;
	private Type type;
	private String number;
	private DateTime expires;

	public Card(String name, Type type, String number, DateTime expires) {
		super();
		this.name = name;
		this.type = type;
		this.number = number;
		this.expires = expires;
	}

	public Card() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public DateTime getExpires() {
		return expires;
	}

	public void setExpires(DateTime expires) {
		this.expires = expires;
	}

	@Override
	public String toString() {
		return "Card [name=" + name + ", type=" + type + ", number=" + number
				+ ", expires=" + expires + "]";
	}
	
	
}
