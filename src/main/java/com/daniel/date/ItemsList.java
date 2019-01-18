package com.daniel.date;

import java.util.ArrayList;

public class ItemsList extends ArrayList<Item<? extends Object>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ItemsList(ArrayList<? extends Object> items) {
		for(Object object : items)
			addItem(new Item<Object>(object));
			
	}
	public ItemsList(Item<? extends Object>[] items) {
		for(Item<? extends Object> item : items) 
			addItem(item);
	}
	public ItemsList(Object[] items) {
		for(Object item : items) 
			addItem(item);
	}
	
	public void addItem(Item<? extends Object> item) {
		this.add(item);
	}
	
	public void addItem(Object item) {
		this.add(new Item<Object>(item));
	}
}
