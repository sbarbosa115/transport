package com.transport.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class DrawBus extends JPanel {
	List<Bus> buses;

	public DrawBus(JFrame frame) {
		buses = new ArrayList<>();
		buses.add(new Bus(100, 10, "left"));
		buses.add(new Bus(100, 100, "rigth"));

		Timer timer = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Bus bus : buses) {
					if (bus.direction == "left") {
						bus.moveLeft(frame);
					}
					if (bus.direction == "rigth") {
						bus.moveRigth(frame);
					}
					repaint();
				}
			}
		});
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Bus bus : buses) {
			bus.drawCar(g);
		}
	}

	public class Bus {
		private static final int INCREMENT = 5;
		private int x, y;
		private String direction;

		public Bus(int x, int y, String direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}

		public void drawCar(Graphics g) {
			g.setColor(Color.RED);
			g.fillRect(x, y, 100, 20);
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
	}

}