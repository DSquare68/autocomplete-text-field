package com.daniel.gui;

import com.daniel.date.Item;
import com.daniel.logic.ListenerControl;

import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Result extends TextField{
	
	private Item<? extends Object>item;
	private Color textColor=Color.BLACK,backgroundColor=Color.WHITE, focusTextColor=Color.FUCHSIA, focusBackgroundColor=Color.DARKVIOLET;
	
	String cssCode="-fx-background-color: #%s;"+"-fx-text-fill: #%s";
	
	public Result(Item<? extends Object> item, Color textColor, Color backgroudColor, Color focusTextColor, Color focusBackgroudColor) {
		this.item=item;
		this.textColor=textColor;
		this.backgroundColor=backgroudColor;
		this.focusTextColor=focusTextColor;
		this.focusBackgroundColor=focusBackgroudColor;
		ListenerControl listenerControl = new ListenerControl();
		this.focusedProperty().addListener(listenerControl.onFocusListenerResult(this));
		init();
	}
	
	public Result(Item<? extends Object> item) {
		this.item=item;
		init();
	}

	private void init() {
		setFocused(false);
		setNotFocused();
		this.setText(item.toString());
	}
	
	public void setFocused() {
		String cssCodeFinal = String.format(cssCode,"#"+focusTextColor.toString().substring(2),"#"+focusBackgroundColor.toString().substring(2));
		this.setStyle(cssCodeFinal);
	}
	
	public void setNotFocused() {
		String cssCodeFinal = String.format(cssCode,"#"+textColor.toString().substring(2),"#"+backgroundColor.toString().substring(2));
		this.setStyle(cssCodeFinal);
	}
	
	public Item<? extends Object> getItem() {
		return item;
	}

	public void setItem(Item<? extends Object> item) {
		this.item = item;
	}

	public Color getTextColor() {
		return textColor;
	}

	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public Color getFocusTextColor() {
		return focusTextColor;
	}

	public void setFocusTextColor(Color focusTextColor) {
		this.focusTextColor = focusTextColor;
	}

	public Color getFocusBackgroundColor() {
		return focusBackgroundColor;
	}

	public void setFocusBackgroundColor(Color focusBackgroundColor) {
		this.focusBackgroundColor = focusBackgroundColor;
	}

	public String getCssCode() {
		return cssCode;
	}

	public void setCssCode(String cssCode) {
		this.cssCode = cssCode;
	}
}
