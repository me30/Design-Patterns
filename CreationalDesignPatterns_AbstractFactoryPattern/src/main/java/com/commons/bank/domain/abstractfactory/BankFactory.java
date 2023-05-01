package com.commons.bank.domain.abstractfactory;

import com.commons.bank.domain.model.Bank;
import com.commons.bank.domain.model.HDFC;
import com.commons.bank.domain.model.ICICI;
import com.commons.bank.domain.model.Loan;
import com.commons.bank.domain.model.SBI;

public class BankFactory extends AbstractFactory {

	@Override
	public Bank getBank(String bank) {
		if (bank == null) {
			return null;
		}
		if (bank.equalsIgnoreCase("HDFC")) {
			return new HDFC();
		} else if (bank.equalsIgnoreCase("ICICI")) {
			return new ICICI();
		} else if (bank.equalsIgnoreCase("SBI")) {
			return new SBI();
		}
		return null;
	}

	@Override
	public Loan getLoan(String loan) {
		return null;
	}

}
