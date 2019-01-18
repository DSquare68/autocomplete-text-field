package com.daniel.gui;

import com.daniel.date.Item;
import com.daniel.logic.ListenerControl;

import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Result extends TextField{
	
	private Item<? extends Object>item;
	private Color textColor=Color.BLACK,backGroundColor=Color.WHITE, focusTextColor=Color.FUCHSIA, focusBackgroundColor=Color.DARKVIOLET;
	
	
	
	public Result(Item<? extends Object> item, Color textColor, Color backgroudColor, Color focusTextColor, Color focusBackgroudColor) {
		this.item=item;
		this.textColor=textColor;
		this.backGroundColor=backgroudColor;
		this.focusTextColor=focusTextColor;
		this.focusBackgroundColor=focusBackgroudColor;
		ListenerControl listenerControl = new ListenerControl();
		this.focusedProperty().addListener(listenerControl.onFocusListenerResult(this));
		init();
	}
	
	public Result(Item<? extends Object> item) {
		init();
	}

	private void init() {
		setFocused(false);
		setNotFocused();
	}
	public void setFocused() {
		
	}
	public void setNotFocused() {
		// TODO Auto-generated method stub
	}
}
