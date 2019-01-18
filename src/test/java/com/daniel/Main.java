package com.daniel;

import java.util.ArrayList;

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
        AutoCompleteTextField autoCompleteTextField =new AutoCompleteTextField(new ArrayList<>());
        root.getChildren().add(autoCompleteTextField);
        ListenersTests listenersTests = new ListenersTests();
        listenersTests.testSearchAlgorithm(autoCompleteTextField);
        stage.setScene(scene);
        stage.show();
	}
}
