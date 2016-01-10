package com.transport.classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * This class represents the entire logic of the station bus, 
 * the seasons are the representation of bus stations. His work in the simulation is static, 
 * no have movement but is able to stop other agents.
 */
public class Station {
	private int x, y;
	public int width = 110;
	public int height = 40;
	private int id;
	static AtomicInteger nextId = new AtomicInteger();

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
		this.id = nextId.incrementAndGet();
	}

	public void drawStation(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);
		g.setFont(new Font("Gerogia", 1, 17));
		g.drawString("BUS #" + this.id, x + 5, y + 15);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Gerogia", 1, 17));
		g.drawString("STATION #" + this.id, x + 5, y + 15);
	}
}