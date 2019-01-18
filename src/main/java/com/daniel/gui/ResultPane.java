package com.daniel.gui;

import java.util.ArrayList;

import com.daniel.date.Item;

import javafx.scene.layout.StackPane;

public class ResultPane extends StackPane {
	
	ArrayList<Result> resultList = new ArrayList<Result>();
	
	public ResultPane(ArrayList<Result> list){
		this.resultList=list;
	}
}
