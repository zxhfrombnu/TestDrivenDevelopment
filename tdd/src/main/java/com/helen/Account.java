package com.helen;

import org.apache.commons.lang3.RandomStringUtils;
import org.javamoney.moneta.Money;

public class Account {
	private String id = RandomStringUtils.randomAlphanumeric(6);
	private boolean status = true;
	private Zone zone = Zone.ZONE_1;
	private Money balance = Money.of(0, "USD");

	public Account() {}

	public Account(boolean status, Zone zone, double balance) {
		this.status = status;
		this.zone = zone;
		if(balance < 0) {
			throw new IllegalArgumentException("The balance cannot be negative");
		}
		this.balance = Money.of(balance, "USD");

	}

	public enum Zone {
		ZONE_1, ZONE_2, ZONE_3
	}
	public String getId() {
		return id;
	}
	public boolean getStatus() {
		return status;
	}
	public Zone getZone() {
		return zone;
	}
	public Money getBalance() {
		return balance;
	}
	
}
