package com.transport.classes;

import java.awt.Color;
import java.awt.Graphics;

public class Station {
	private int x, y;
	public int width = 75;
	public int height = 30;

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

	public Station(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void drawStation(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);
	}
}