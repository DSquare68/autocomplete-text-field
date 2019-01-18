package com.daniel;

import java.util.ArrayList;

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
        root.getChildren().add(new AutoCompleteTextField(new ArrayList<>()));
        stage.setScene(scene);
        stage.show();
	}
}
