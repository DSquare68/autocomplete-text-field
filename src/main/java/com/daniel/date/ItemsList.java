package com.daniel.date;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ItemsList extends ArrayList<Item<? extends Object>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Item<? extends Object>> resultList = new ArrayList<>();
	
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

	
	public void find(String s) {
		resultList.removeAll(resultList);
		for(Item<? extends Object> item :  this.stream().filter(i->i.compare(s)).collect(Collectors.toCollection(ArrayList::new)))
			resultList.add(item);
	}
	
	public void addItem(Item<? extends Object> item) {
		this.add(item);
	}
	public void addItem(Object item) {
		this.add(new Item<Object>(item));
	}
			
	public ArrayList<Item<? extends Object>> getResultList() {
		return resultList;
	}
	public void setResultList(ItemsList resultList) {
		this.resultList = resultList;
	}
	
}
