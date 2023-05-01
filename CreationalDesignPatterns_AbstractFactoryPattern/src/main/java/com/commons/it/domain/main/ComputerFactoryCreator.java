package com.commons.it.domain.main;

import com.commons.it.domain.abstractfactory.ComputerAbstractFactory;
import com.commons.it.domain.model.Computer;

public class ComputerFactoryCreator {
	public static Computer getComputer(ComputerAbstractFactory computerAbstractFactory){
		return computerAbstractFactory.createComputer();
	}
}