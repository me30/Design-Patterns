package com.commons.bank.domain.abstractfactory;

import com.commons.bank.domain.model.Bank;
import com.commons.bank.domain.model.BussinessLoan;
import com.commons.bank.domain.model.EducationLoan;
import com.commons.bank.domain.model.HomeLoan;
import com.commons.bank.domain.model.Loan;

public class LoanFactory extends AbstractFactory {

	@Override
	public Bank getBank(String bank) {
		return null;
	}

	@Override
	public Loan getLoan(String loan) {
		if (loan == null) {
			return null;
		}
		if (loan.equalsIgnoreCase("Home")) {
			return new HomeLoan();
		} else if (loan.equalsIgnoreCase("Business")) {
			return new BussinessLoan();
		} else if (loan.equalsIgnoreCase("Education")) {
			return new EducationLoan();
		}
		return null;
	}
}