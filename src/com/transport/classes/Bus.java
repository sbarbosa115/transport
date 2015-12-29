package com.transport.classes;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Bus extends Vehicle {

	private static final int INCREMENT = 5;
	private int x, y;
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String direction;

	public Bus(int x, int y, String direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public void drawBus(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 75, 30);
	}

	public void moveLeft(JFrame frame) {
		if (frame.getWidth() == x) {
			x = 0;
		} else {
			x += INCREMENT;
		}
	}

	public void moveRigth(JFrame frame) {
		if (x == 0) {
			x = frame.getWidth();
		} else {
			x -= INCREMENT;
		}

	}
	
	public void stop() {
		
			this.x = 500;
		
	}
}
