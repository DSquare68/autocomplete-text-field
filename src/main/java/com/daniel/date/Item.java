package com.daniel.date;

import com.daniel.AutoCompleteTextField;
import com.daniel.Controls;

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
		String value = null;
		if(Controls.IGNORE_UPPER_CASES==AutoCompleteTextField.upperCase)
			value = getValue().toString().toLowerCase();
		else if (Controls.INCLUDE_UPPER_CASES==AutoCompleteTextField.upperCase)
			value = getValue().toString();
		switch(AutoCompleteTextField.searchMode) {
			case Controls.SEARCH_FROM_BEGGINING:
				return value.startsWith(s);
			case Controls.SEARCH_WITHIN_FILE:
				return value.contains(s);
			default:
				return false;
		}
	}
	public void setValue(T value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return value.toString();
	}
}
