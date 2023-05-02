package com.commons.demo2;

//Cloneable interface allows the implementing class to
//have its objects to be cloned instead of using a new operator.
//It is available in Java.lang.Cloneable.
abstract class Color implements Cloneable {

	protected String colorName;
	abstract void addColor();

	public Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}