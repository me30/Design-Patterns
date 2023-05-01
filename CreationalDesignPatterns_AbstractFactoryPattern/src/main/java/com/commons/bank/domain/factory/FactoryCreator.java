package com.commons.bank.domain.factory;

import com.commons.bank.domain.abstractfactory.AbstractFactory;
import com.commons.bank.domain.abstractfactory.BankFactory;
import com.commons.bank.domain.abstractfactory.LoanFactory;

public class FactoryCreator {
	public static AbstractFactory getFactory(String choice) {
		if (choice.equalsIgnoreCase("Bank")) {
			return new BankFactory();
		} else if (choice.equalsIgnoreCase("Loan")) {
			return new LoanFactory();
		}
		return null;
	}
}
