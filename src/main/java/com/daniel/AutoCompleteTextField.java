package com.daniel;


import java.util.ArrayList;
import java.util.HashMap;

import com.daniel.date.Item;
import com.daniel.date.ItemsList;
import com.daniel.gui.Result;
import com.daniel.gui.ResultPane;
import com.daniel.logic.ListenerControl;

import javafx.scene.control.TextField;

public class AutoCompleteTextField extends TextField implements Controls{
	
	/**
	 *  index of hovered item 
	 */
	private int nrHover=Integer.MIN_VALUE;
	private ResultPane resultPane;
	private ItemsList itemsList;
	private HashMap<Item<? extends Object>, Result> resultMap;
	
	public AutoCompleteTextField(ArrayList<? extends Object> items) {
		ListenerControl listenerControl = new ListenerControl();
		itemsList= new ItemsList(items);
		this.setOnKeyPressed(listenerControl.keyPressedAutocomplete(this));
		this.textProperty().addListener(listenerControl.onChangeTextListenerAutocomplete(this));
		this.resultPane= new ResultPane(items,this);
		resultMap=resultPane.getMap();
	}
	public AutoCompleteTextField(Object[] items) {
		//TODO test it how it works
	}
	
	public int getNrHover() {
		return nrHover;
	}
	public void setNrHover(int nrHover) {
		this.nrHover = nrHover;
	}
	public ResultPane getResultPane() {
		return resultPane;
	}
	public void setResultPane(ResultPane resultPane) {
		this.resultPane = resultPane;
	}
	public ItemsList getItemsList() {
		return itemsList;
	}
	public void setItemsList(ItemsList itemsList) {
		this.itemsList = itemsList;
	}
	public void showResult() {
		ArrayList<Result> array = new ArrayList<>();
		for(Item<? extends Object> item : itemsList.getResultList())
			array.add(resultMap.get(item));
		resultPane.getResultList().removeAll(resultPane.getResultList());
		resultPane.setResultList(array);
		if(!resultPane.isVisible())
			resultPane.show(this);
		
	}
}
