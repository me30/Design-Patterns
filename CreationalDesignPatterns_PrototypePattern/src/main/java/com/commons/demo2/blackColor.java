package com.commons.demo2;

public class blackColor extends Color {

	public blackColor() {
		this.colorName = "black";
	}

	@Override
	void addColor() {
		System.out.println("Black color added");
	}
}