package com.daniel;


import java.util.ArrayList;

import com.daniel.date.Item;
import com.daniel.date.ItemsList;
import com.daniel.gui.ResultPane;

import javafx.scene.control.TextField;

public class AutoCompleteTextField extends TextField implements Controls{
	
	/**
	 *  index of hovered item 
	 */
	private int nrHover=Integer.MIN_VALUE;
	private ResultPane resultPane;
	private ItemsList itemsList;
	
	public AutoCompleteTextField(ArrayList<? extends Object> items) {
		itemsList= new ItemsList(items);
	}
	public AutoCompleteTextField(Object[] items) {
		
	}
	
	
}
