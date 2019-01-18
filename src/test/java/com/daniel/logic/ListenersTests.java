package com.daniel.logic;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.daniel.AutoCompleteTextField;

public class ListenersTests {

	ArrayList<Cat> catsList = new ArrayList<>();
	
	@Test
	public void testSearchAlgorithm(AutoCompleteTextField autoCompleteTextField) {
		catsList.add(new Cat(5,5,5));
		catsList.add(new Cat(5,10,5));
		catsList.add(new Cat(5,10,5));
		catsList.add(new Cat(5,20,5));
		catsList.add(new Cat(5,5,50));
		autoCompleteTextField = new AutoCompleteTextField(catsList);
		autoCompleteTextField.setText("5 10");
		System.out.println("@Test  testSearchAlgorithm: "+2+" = "+autoCompleteTextField.getItemsList().getResultList().size());
		assertEquals(2,autoCompleteTextField.getItemsList().getResultList().size());
		//TODO maybe checks not only size but the value
	}
	class Cat{
		int age;
		int weight;
		int height;
		public Cat(int age, int weight, int height) {
			this.age=age;
			this.weight=weight;
			this.height=height;
			
		}
		@Override
		public String toString() {
			return age+" "+weight+" "+height;
		}
	}
}
