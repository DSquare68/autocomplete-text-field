package com.daniel;

import java.util.ArrayList;

import com.daniel.date.ItemsList;
import com.daniel.logic.ListenersTests;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{
	public static void main(String[] args) {
		
	}
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Test view");
        Group root = new Group();
        Scene scene = new Scene(root, 400, 250, Color.WHITE);
        ListenersTests listenersTests = new ListenersTests();
        AutoCompleteTextField autoCompleteTextField= null;
        listenersTests.setCats();
        autoCompleteTextField =new AutoCompleteTextField(new ItemsList(listenersTests.getCats()));
        autoCompleteTextField.setTranslateX(40);
        autoCompleteTextField.setTranslateY(100);
        root.getChildren().add(autoCompleteTextField);
        stage.setScene(scene);
        stage.show();
	}
}
