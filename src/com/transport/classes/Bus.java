package com.transport.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Bus {

	private static final int INCREMENT = 1;
	private int x, y;
	public String status = "run";
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
		if (x >= frame.getWidth()) {
			x = 0;

		} else if (status == "run") {
			x += INCREMENT;
		}
	}

	public void moveRigth(JFrame frame) {
		if (x <= 0) {
			x = frame.getWidth();

		} else if (status == "run") {
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

	public void stop(List<Integer> positions, List<Bus> buses) {
		if (positions.contains(x)) {
			status = "stop";
			Timer timer = new Timer(1000, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					status = "run";
				}
			});
			timer.start();
		}

		for (Bus bus : buses) {
			if (this != bus) {
				if ((bus.getX() + bus.width + 25) == this.getX() && this.direction == bus.direction && this.direction == "left") {
					System.out.print("Same position rigth to left \n");
					status = "stop";
					Timer timer = new Timer(8000, new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							status = "run";
						}
					});
					timer.start();
				}

			}
		}
		
		for (Bus bus : buses) {
			if (this != bus) {
				if ((bus.getX() + bus.width + 25) == this.getX() && this.direction == bus.direction && this.direction == "rigth") {
					System.out.print("Same position \n");
					status = "stop";
					Timer timer = new Timer(800, new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							status = "run";
						}
					});
					timer.start();
				}

			}
		}
	}

}