package com.marflo.ms.webservice.service.enpoints;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.math.BigDecimal;

@JsonRootName("Account")
public class Account {

	protected Long id;
	protected String number;
	protected String owner;
	protected BigDecimal balance;

	protected Account() {
		balance = BigDecimal.ZERO;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	protected void setNumber(String accountNumber) {
		this.number = accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	protected void setOwner(String owner) {
		this.owner = owner;
	}

	public BigDecimal getBalance() {
		return balance.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	protected void setBalance(BigDecimal value) {
		balance = value;
		balance.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
}
