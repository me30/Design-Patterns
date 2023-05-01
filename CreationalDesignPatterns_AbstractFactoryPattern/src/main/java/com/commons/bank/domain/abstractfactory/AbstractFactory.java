package com.commons.bank.domain.abstractfactory;

import com.commons.bank.domain.model.Bank;
import com.commons.bank.domain.model.Loan;

public abstract class AbstractFactory {
	public abstract Bank getBank(String bank);

	public abstract Loan getLoan(String loan);
}