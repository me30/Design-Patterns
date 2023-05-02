package com.commons.demo1;

import java.util.List;

public class EmployeePrototypePatternTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Employees emps = new Employees();
		emps.loadData();
		
		//Use the clone method to get the Employee object
		Employees empsNew = (Employees) emps.clone();
		// we add new employee
		List<String> list = empsNew.getEmpList();
		list.add("Minesh");
		
		Employees empsNew1 = (Employees) emps.clone();
		//we remove exsisting employee..
		List<String> list1 = empsNew1.getEmpList();
		list1.remove("Tarun");
		
		System.out.println("emps List: "+emps.getEmpList());
		System.out.println("empsNew List: "+list);
		System.out.println("empsNew1 List: "+list1);
	}

}
