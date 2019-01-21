package com.daniel;


import java.util.ArrayList;
import java.util.HashMap;

import com.daniel.date.Item;
import com.daniel.date.ItemsList;
import com.daniel.gui.Result;
import com.daniel.gui.ResultPane;
import com.daniel.logic.ListenerControl;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class AutoCompleteTextField extends TextField implements Controls{
	
	/**
	 *  index of hovered item 
	 */
	private int nrHover=Integer.MIN_VALUE;
	private IntegerProperty hoverProperty = new SimpleIntegerProperty();
	private ResultPane resultPane;
	private ItemsList itemsList;
	private HashMap<Item<? extends Object>, Result> resultMap = new HashMap<>();
	
	public AutoCompleteTextField(ArrayList<? extends Object> items) {
		ListenerControl listenerControl = new ListenerControl();
		itemsList= new ItemsList(items);
		this.setOnKeyPressed(listenerControl.keyPressedAutocomplete(this));
		this.textProperty().addListener(listenerControl.onChangeTextListenerAutocomplete(this));
		this.resultPane= new ResultPane(this);
		hoverProperty.set(nrHover);
		hoverProperty.addListener(listenerControl.nrHoverValueObservable(resultPane));
	}
	public AutoCompleteTextField(Object[] items) {
		//TODO test it how it works
	}
	
	public int getNrHover() {
		return hoverProperty.get();
	}
	public void setNrHover(int nrHover) {
		this.hoverProperty.set(nrHover);;
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
	
	public HashMap<Item<? extends Object>, Result> getResultMap() {
		return resultMap;
	}
	public void setResultMap(HashMap<Item<? extends Object>, Result> resultMap) {
		this.resultMap = resultMap;
	}
	@SuppressWarnings("unlikely-arg-type")
	public void showResult() {
		ArrayList<Result> array = new ArrayList<>();
		for(Item<? extends Object> item : itemsList.getResultList())
			array.add(resultMap.get(item));
		resultPane.getResultList().removeAll(resultPane.getResultList());
		resultPane.setResultList(array);
		resultPane.show(this);
		
	}
}
