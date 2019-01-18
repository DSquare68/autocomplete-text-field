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

	public void setValue(T value) {
		this.value = value;
	}
	
}
