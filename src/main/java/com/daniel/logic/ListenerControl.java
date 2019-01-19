package com.daniel.logic;

import com.daniel.AutoCompleteTextField;
import com.daniel.gui.Result;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ListenerControl {
	
	public ListenerControl() {
		
	}
	
	public EventHandler<KeyEvent>  keyPressedAutocomplete(final AutoCompleteTextField textField){
		return e->{
			switch(e.getCode()) {
				case UP:
					//TODO up
					break;
				case DOWN: 
					//TODO down
				case ENTER:
					//TODO enter
				default:
					break;
					}
		};
	}
	public EventHandler<MouseEvent> onMouseListenerAutocomplete() {
		return e->{
			if(e.getButton()==MouseButton.PRIMARY) {
				//TODO primary button
			}
		};
	}
	public  ChangeListener<String> onChangeTextListenerAutocomplete(AutoCompleteTextField textField){
		return new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue,
					String newValue) {
					if(textField.getItemsList().find(newValue)>0) 
						textField.showResult();
					
			}
		};
	}
			
	public EventHandler<MouseEvent> onMouseListenerResult() {
			return e->{
				if(e.getButton()==MouseButton.PRIMARY&&e.getClickCount()==1) {
					//TODO primary button pressed once
				}else if(e.getButton()==MouseButton.PRIMARY&&e.getClickCount()==2) {
					//TODO primary button pressed twice
				}		
		};
	}

	public ChangeListener<Boolean> onFocusListenerResult(Result result) {
		return new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(newValue)
					result.setFocused();
				else 
					result.setNotFocused();
			} 
		};
	}
}
