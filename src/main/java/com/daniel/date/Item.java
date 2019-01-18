package com.daniel.date;

public class Item<T> {
	private T value;
	
	public Item(T value) {
		super();
		this.value = value;
	}

	public T getValue() {
		return value;
	}
	public boolean compare(String s){
		return getValue().toString().startsWith(s);
	}
	public void setValue(T value) {
		this.value = value;
	}
	
}
