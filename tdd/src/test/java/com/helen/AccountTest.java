package com.helen;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.javamoney.moneta.Money;
import org.junit.Test;

public class AccountTest {
	@Test
	public void defaultAccountCreationTest() {
		Account account = new Account();
		assertThat(account.getId().length(), equalTo(6));
		assertThat(account.getStatus(), equalTo(true));
		assertThat(account.getZone(), equalTo(Account.Zone.ZONE_1));
		assertThat(account.getBalance(), equalTo(Money.of(0.00, "USD")));
	}

	@Test
	public void customAccountCreationTest() {
		Account account = new Account(false, Account.Zone.ZONE_3, 125.95);
		assertThat(account.getId().length(), equalTo(6));
		assertThat(account.getStatus(), equalTo(false));
		assertThat(account.getZone(), equalTo(Account.Zone.ZONE_3));
		assertThat(account.getBalance(), equalTo(Money.of(125.95, "USD")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeBalanceTest() {
		Account account = new Account(false, Account.Zone.ZONE_1, -200);
		
	}
}
