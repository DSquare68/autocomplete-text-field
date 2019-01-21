package com.daniel.logic;

import com.daniel.AutoCompleteTextField;
import com.daniel.gui.Result;
import com.daniel.gui.ResultPane;

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
			int size =textField.getItemsList().getResultList().size();
			int nrHover= textField.getNrHover();
			switch(e.getCode()) {
				case UP:
					if(nrHover==Integer.MIN_VALUE) 
						textField.setNrHover(size-1);
					else
						textField.setNrHover(--nrHover==-1 ? size-1 : nrHover);
					break;
				case DOWN: 
					if(nrHover==Integer.MIN_VALUE) 
						textField.setNrHover(0);
					else
						textField.setNrHover(++nrHover==size ? 0 : nrHover);
					break;
				case ENTER:
					if(nrHover!=Integer.MIN_VALUE)
						textField.setNrHover(Integer.MIN_VALUE);
						textField.setText(textField.getResultPane().getResultList().get(nrHover).getText());
					textField.getResultPane().setVisible(false);
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
					else 
						textField.getResultPane().hide();
					if(newValue.equals(""))
						textField.getResultPane().setVisible(false);
			}
		};
	}
			
	public EventHandler<MouseEvent> onMouseListenerResult(AutoCompleteTextField textField, ResultPane pane, Result result) {
			return e->{
				if(e.getButton()==MouseButton.PRIMARY&&e.getClickCount()==1) {
					textField.setNrHover(pane.getResultList().indexOf(result));
				}else if(e.getButton()==MouseButton.PRIMARY&&e.getClickCount()==2) {
					textField.setNrHover(Integer.MIN_VALUE);
					textField.setText(result.getText());
					pane.setVisible(false);
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

	public ChangeListener<? super Number> nrHoverValueObservable(ResultPane pane) {
		return new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if(newValue.intValue()!=Integer.MIN_VALUE)
					pane.getResultList().get(newValue.intValue()).setFocused();
				if(oldValue.intValue()!=Integer.MIN_VALUE) 
					pane.getResultList().get(oldValue.intValue()).setNotFocused();	
			}
		};
	}
}
