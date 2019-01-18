package com.daniel;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;

public class Basic {

	 @Test
	    public void putOnScreen() throws InterruptedException {
	        Thread thread = new Thread(new Runnable() {

	            @Override
	            public void run(){
	                new JFXPanel(); 
	                Platform.runLater(new Runnable() {

	                    @Override
	                    public void run(){
	                        try {
								new Main().start(new Stage());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
	                    }
	                });
	            }
	        });
	        thread.start();
	        Thread.sleep(1000000); 
	    }
}
