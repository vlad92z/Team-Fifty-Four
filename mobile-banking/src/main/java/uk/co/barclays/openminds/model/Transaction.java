package uk.co.barclays.openminds.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

	public enum TransactionType {
		BGC("BGC"), // Bank Giro Credit
		BNS("BNS"), // Bonus
		BP("BP"), // Bill Payment
		CHG("CHG"), // Charge
		CHQ("CHQ"), // Cheque
		COM("COM"), // Commission
		COR("COR"), // Correction
		CPT("CPT"), // Cashpoint
		CSH("CSH"), // Cash
		CSQ("CSQ"), // Cash/Cheque
		DD("DD"), // Direct Debit
		DEB("DEB"), // Debit Card
		DEP("DEP"), // Deposit
		EFT("EFT"), // EFTPOS (electronic funds transfer at point of sale)
		EUR("EUR"), // Euro Cheque
		FE("FE"), // Foreign Exchange
		FEE("FEE"), // Fixed Service Charge
		FPC("FPC"), // Faster Payment charge
		FPI("FPI"), // Faster Payment incoming
		FPO("FPO"), // Faster Payment outgoing
		IB("IB"), // Internet Banking
		INT("INT"), // Interest
		MPI("MPI"), // Mobile Payment incoming
		MPO("MPO"), // Mobile Payment outgoing
		MTG("MTG"), // Mortgage
		NS("NS"), // National Savings Dividend
		NSC("NSC"), // National Savings Certificates
		OTH("OTH"), // Other
		PAY("PAY"), // Payment
		PSB("PSB"), // Premium Savings Bonds
		PSV("PSV"), // Paysave
		SAL("SAL"), // Salary
		SPB("SPB"), // Cashpoint
		SO("SO"), // Standing Order
		STK("STK"), // Stocks/Shares
		TD("TD"), // Dep Term Dec
		TDG("TDG"), // Term Deposit Gross Interest
		TDI("TDI"), // Dep Term Inc
		TDN("TDN"), // Term Deposit Net Interest
		TFR("TFR"), // Transfer
		UT("UT"), // Unit Trust
		SUR("SUR"); // Excess Reject

		private String text;

		TransactionType(String text) {
			this.text = text;
		}

		public String getText() {
			return this.text;
		}

		public static TransactionType fromString(String text) {
			if (text != null) {
				for (TransactionType tt : TransactionType.values()) {
					if (text.equalsIgnoreCase(tt.text)) {
						return tt;
					}
				}
			}
			return OTH;
		}
	}

	private DateTime date;
	private String description;
	private TransactionType type;
	private Double debit;
	private Double credit;
	private Double amount; // credit / debit as -/+
	private BankAccount account;
	private Double cleared;
	private Double balance;
	private Category category;

	public Transaction() {
		super();
	}

	public Transaction(DateTime date, String description, String type,
			Double debit, Double credit, Double balance, Category category) {
		super();
		this.date = date;
		this.description = description;
		this.type = TransactionType.fromString(type);
		this.debit = debit;
		this.credit = credit;
		this.amount = calculateAmount(debit, credit);
		this.balance = balance;
		this.category = category;
	}

	public Transaction(String date, String description, String type,
			Double debit, Double credit, Double balance, String category) {
		super();
		this.date = new DateTime(date);
		this.description = description;
		this.type = TransactionType.fromString(type);
		this.debit = debit;
		this.credit = credit;
		this.amount = calculateAmount(debit, credit);
		this.balance = balance;
		this.category = new Category(category);
	}

	public Transaction(DateTime date, String description, String type,
			Double debit, Double credit, Double amount, BankAccount account,
			Double cleared, Double balance, Category category) {
		super();
		this.date = date;
		this.description = description;
		this.type = TransactionType.fromString(type);
		this.debit = debit;
		this.credit = credit;
		this.amount = amount;
		this.account = account;
		this.cleared = cleared;
		this.balance = balance;
		this.category = category;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDateTime(DateTime date) {
		this.date = date;
	}

	public void setDate(String date) {
		this.date = DateTime.parse(date,
				DateTimeFormat.forPattern("dd/MM/yyyy"));
		;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(String type) {
		this.type = TransactionType.fromString(type);
	}

	public Double getDebit() {
		return debit;
	}

	public void setDebit(Double debit) {
		this.debit = debit;
		if (debit != null) {
			this.amount = -debit;
		}
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
		if (credit != null) {
			this.amount = credit;
		}
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	public Double getCleared() {
		return cleared;
	}

	public void setCleared(Double cleared) {
		this.cleared = cleared;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Category getCategory() {
		return category;
	}

	public void setCat(Category category) {
		this.category = category;
	}

	public void setCategory(String category) {
		this.category = new Category(category);
	}

	private Double calculateAmount(Double debit, Double credit) {
		if (debit == null) {
			return credit;
		} else if (credit == null) {
			return -debit;
		} else {
			return new Double(0);
		}
	}

	private Double calculateAmount() {
		if (debit == null) {
			return credit;
		} else if (credit == null) {
			return -debit;
		} else {
			return new Double(0);
		}
	}

	@Override
	public String toString() {
		return "Transaction [date=" + date + ", description=" + description
				+ ", type=" + type + ", debit=" + debit + ", credit=" + credit
				+ ", amount=" + amount + ", account=" + account + ", cleared="
				+ cleared + ", balance=" + balance + ", category=" + category
				+ "]";
	}

}
