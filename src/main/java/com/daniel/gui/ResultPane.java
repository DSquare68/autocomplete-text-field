package com.daniel.gui;

import java.util.ArrayList;
import java.util.HashMap;

import com.daniel.AutoCompleteTextField;
import com.daniel.date.Item;

import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ResultPane extends StackPane {
	
	ArrayList<Result> resultList = new ArrayList<Result>();
	private ScrollPane scroll= new ScrollPane();
	private int nrHover=Integer.MIN_VALUE;
	
	public ResultPane(AutoCompleteTextField textField){
		setList(textField);
		init(textField);
	}

	@SuppressWarnings("unchecked")
	private void setList(AutoCompleteTextField textField) {
		ArrayList<? extends Object> list= textField.getItemsList();
		HashMap<Item<? extends Object>, Result> resultMap = textField.getResultMap();
		switch(list.get(0).getClass().getSimpleName()) {
			case "Result":
				this.resultList=(ArrayList<Result>) list;
				break;
			case "Item":
				for(Object item : list) {
					Result r =new Result((Item<? extends Object>) item);
					resultMap.put((Item<? extends Object>) item,r);
					this.resultList.add(r);
				}
				break;
			case "Object":
				for(Object item : list) {
					Result r =new Result((Item<? extends Object>) item);
					resultMap.put((Item<? extends Object>) item,r);
					this.resultList.add(r);
				}
				break;
			default:
				break;
		}	
	}

	private void init(AutoCompleteTextField textField) {
		scroll.setPrefSize(textField.getWidth(), textField.getHeight()*3);
		scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.getChildren().add(scroll);
		this.setManaged(false);
		resultList.forEach(r->{
			r.setEditable(false);
			r.setFocusTraversable(false);
			r.setOnMouseClicked(e->{
				if(e.getButton()==MouseButton.PRIMARY&&e.getClickCount()==1) {
					resultList.get(textField.getNrHover()).setStyle("-fx-background-color: #FFFFFF;"
							+ "-fx-text-fill: #0076a3");
					r.setStyle("-fx-background-color: #FFFF22;"
							+ "-fx-text-fill: #9976a3");
					nrHover=resultList.indexOf(r);
					textField.setNrHover(nrHover);
				}else if(e.getButton()==MouseButton.PRIMARY&&e.getClickCount()==2) {
					textField.setText(r.getText()); 
					hide();
				}	
			});
		});
	}
	public void show(AutoCompleteTextField textField) {
		if(((Group) textField.getParent()).getChildren().indexOf(this) == -1)
			((Group) textField.getParent()).getChildren().add(this);
		setVisible(true);
		setLocation(textField);
		setResult(textField);
	}
	public void hide() {
		this.setVisible(false);
	}

	public ArrayList<Result> getResultList() {
		return resultList;
	}

	public void setResultList(ArrayList<Result> resultList) {
		this.resultList = resultList;
	}
	private void setResult(AutoCompleteTextField textField) {
		VBox vBox= new VBox(5);
		textField.getItemsList().getResultList().forEach(e->vBox.getChildren().add(textField.getResultMap().get(e)));
		scroll.setContent(vBox);
	}
	public void setLocation(AutoCompleteTextField textField) {
		Bounds bounds = textField.localToScene(textField.getBoundsInLocal());
		this.setWidth(textField.getWidth());
		this.setHeight(textField.getHeight()*3);
		this.setTranslateX(bounds.getMinX());
		this.setTranslateY(bounds.getMinY()+textField.getHeight());
	}
}
