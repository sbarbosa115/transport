package com.transport.classes;

import java.awt.Color;
import java.awt.Graphics;

/*
 * This class represents the entire logic of the station bus, 
 * the seasons are the representation of bus stations. His work in the simulation is static, 
 * no have movement but is able to stop other agents.
 */
public class Station {
	private int x, y;
	public int width = 110;
	public int height = 40;

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