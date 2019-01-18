package com.daniel;


import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class AutoCompleteTextField extends TextField implements Controls{
	
	/**
	 *  index of hovered item 
	 */
	private int nrHover=Integer.MIN_VALUE;
	
	
	public AutoCompleteTextField(ArrayList<Object> items) {
		
	}
	public AutoCompleteTextField(Object[] items) {
		
	}
	
	
}
