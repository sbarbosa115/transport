package com.transport.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * It represents the behavior of a bus on a route has problems as
 * 
 * Station stops Crash with other buses (Reactivity) Stops at traffic lights
 * (Social Skills) Movement across highway (Autonomy)
 */
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

	/*
	 * This method's is responsible for communicating with the different agents of
	 * bus type, station type and traffic lights for actions in accordance with
	 * position or status of other agents
	 */
	public void stopStation(List<Integer> positions, List<Bus> buses) {

		if (positions.contains(x)) {
			status = "stop";

			Timer timer = new Timer(7000, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					status = "run";
				}
			});
			timer.setRepeats(false);
			timer.start();
			if (this.direction == "left") {
				x++;
			}
			if (this.direction == "rigth") {
				x--;
			}
		}
	}

	public void stopTrafficBus(List<Integer> positions, List<Bus> buses) {
		for (Bus bus : buses) {
			if (bus.direction == "rigth") {
				if ((bus.getX() + bus.width + 8) == this.x) {
					status = "stop";
					x = x + 2;
					Timer timer = new Timer(2000, new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							status = "run";
						}
					});
					timer.setRepeats(false);
					timer.start();
				}
			} else if (bus.direction == "left") {
				if ((bus.getX() - bus.width - 8) == this.x) {
					status = "stop";
					x = x - 2;
					Timer timer = new Timer(2000, new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							status = "run";
						}
					});
					timer.setRepeats(false);
					timer.start();
				}
			}
		}
	}

	public void stopTrafficBusNear(List<Integer> positions, List<Bus> buses) {
		for (Bus bus : buses) {
			if (bus.direction == "rigth") {
				if ((bus.getX() + bus.width + 1) == this.x) {
					status = "stop";
					x = x + 2;
					Timer timer = new Timer(2000, new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							status = "run";
						}
					});
					timer.setRepeats(false);
					timer.start();
				}
			} else if (bus.direction == "left") {
				if ((bus.getX() - bus.width - 1) == this.x) {
					status = "stop";
					x = x - 2;
					Timer timer = new Timer(2000, new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							status = "run";
						}
					});
					timer.setRepeats(false);
					timer.start();
				}
			}
		}
	}

	public void stopTrafficLight(int xCoordinate, List<Bus> buses, TrafficLight trafficLights) {
		for (Bus bus : buses) {

			if (bus.direction == "rigth") {
				if (xCoordinate + 20 == this.x && trafficLights.status == "red") {
					status = "stop";
					x = x + 6;
					Timer timer = new Timer(1000, new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							status = "run";
						}
					});
					timer.setRepeats(false);
					timer.start();
				}
			}

		}
	}

}