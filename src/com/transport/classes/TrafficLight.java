package com.transport.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/*
 * This class represents a traffic light agent, interacts directly with the agents of bus type, 
 * simulates a real traffic situation.
 * 
 * It represents autonomy of an agent that does not require any other to function, 
 * all logic for autonomy are write in changeColor() method. 
 * 
 * The algorithm is a time sequence in which each color is.
 * 
 */
public class TrafficLight {

	private int x, y, width = 25, height = 50;

	private int redLigth = 4000;
	private int greenLigth = 12000;
	private int greenToRedLigth = 500;
	private int redToGreenLigth = 500;
	public String status = "red";
	private Timer timer;
	

	public TrafficLight(int x, int y) {
		this.x = x;
		this.y = y;
		
		timer = new Timer(greenToRedLigth, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				status = "red";
			}
		});
		timer.start();
		timer.setRepeats(false);
	}

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

	public int getRedLigth() {
		return redLigth;
	}

	public void setRedLigth(int redLigth) {
		this.redLigth = redLigth;
	}

	public int getGreenLigth() {
		return greenLigth;
	}

	public void setGreenLigth(int greenLigth) {
		this.greenLigth = greenLigth;
	}

	/*
	 * Different States.
	 * 
	 * This method change the state of Agent
	 * The state of agent interact with another Agents in environment.
	 */ 
	public void changeColor() {
		
		if (status == "red" && timer.isRunning() == false) {
			
			timer = new Timer(redLigth, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					status = "redToGreen";
				}
			});
			
			timer.start();
			timer.setRepeats(false);
			

		} else if (status == "redToGreen" && timer.isRunning() == false) {
			
			timer = new Timer(redToGreenLigth, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					status = "green";
				}
			});
			timer.start();
			timer.setRepeats(false);
			
		} else if (status == "green" && timer.isRunning() == false) {
			
			timer = new Timer(greenLigth, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					status = "greenToRed";
				}
			});
			timer.start();
			timer.setRepeats(false);
			
		} else if (status == "greenToRed" && timer.isRunning() == false) {
			
			timer = new Timer(greenToRedLigth, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					status = "red";
				}
			});
			timer.start();
			timer.setRepeats(false);
		}

	}

	
	public void drawTrafficLigth(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);

		if (status == "green") {
			g.setColor(Color.white);
			g.fillOval(x + 5, y + 2, 15, 15);
			g.fillOval(x + 5, y + 17, 15, 15);
			g.setColor(Color.GREEN);
			g.fillOval(x + 5, y + 32, 15, 15);
		}
		if (status == "red") {
			g.setColor(Color.RED);
			g.fillOval(x + 5, y + 2, 15, 15);
			g.setColor(Color.WHITE);
			g.fillOval(x + 5, y + 17, 15, 15);
			g.fillOval(x + 5, y + 32, 15, 15);
		}
		if (status == "greenToRed") {
			g.setColor(Color.YELLOW);
			g.fillOval(x + 5, y + 17, 15, 15);
			g.setColor(Color.WHITE);
			g.fillOval(x + 5, y + 2, 15, 15);
			g.fillOval(x + 5, y + 32, 15, 15);
		}
		if (status == "redToGreen") {
			g.setColor(Color.RED);
			g.fillOval(x + 5, y + 2, 15, 15);
			g.setColor(Color.YELLOW);
			g.fillOval(x + 5, y + 17, 15, 15);
			g.setColor(Color.WHITE);
			g.fillOval(x + 5, y + 32, 15, 15);
		}
	}
}
