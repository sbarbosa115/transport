package com.transport.classes;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Bus  {

	private static final int INCREMENT = 5;
	private int x, y;
	public String status = "run";
	public int temp = 0;
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

	public String direction;

	public Bus(int x, int y, String direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public void drawBus(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, this.width, this.height);
	}

	public void moveLeft(JFrame frame) {
		if(x >= frame.getWidth()) {
			x = 0;
			temp = 0;
		} else {
			x += INCREMENT;
		}
	}

	public void moveRigth(JFrame frame) {
		if (x <= 0) {
			x = frame.getWidth();
			temp = frame.getWidth();
		} else {
			x -= INCREMENT;
		}
	}

	public void setDirection(JFrame frame) {
		if (this.direction == "left") {
			this.moveLeft(frame);
		}
		if (this.direction == "rigth") {
			this.moveRigth(frame);
		}
	}
	

	public void stop(Station station) {
		if (this.direction == "left") {
			temp += INCREMENT;
			if (temp > station.getX() && temp < station.getX() + station.width) {
				x = station.getX();
			}
		} else if(this.direction == "rigth") {
			temp -= INCREMENT;
			if (temp > station.getX() - this.height - 20 && temp < station.getX() + station.width - this.height - 20) {
				x = station.getX();
			}
			
		}
	}

}
