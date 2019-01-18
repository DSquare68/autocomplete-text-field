package com.daniel;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Basic {

	@Test
	public void check() {
		Paint p = Paint.valueOf("4f4f4f");
		System.out.println(p.toString());
	}

}
