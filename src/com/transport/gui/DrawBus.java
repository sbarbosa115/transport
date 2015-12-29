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

import com.transport.classes.Bus;
import com.transport.classes.Station;

public class DrawBus extends JPanel {
	List<Bus> buses;
	List<Station> stations;

	public DrawBus(JFrame frame) {
		buses = new ArrayList<>();
		buses.add(new Bus(frame.getWidth(), 10, "left"));
		buses.add(new Bus(0, 100, "rigth"));

		stations = new ArrayList<>();
		stations.add(new Station(500, 60));
		for (Station station : stations) {
			repaint();
		}

		Timer timer = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Bus bus : buses) {
					if (bus.getX() == 500) {
						System.out.print("------------- Stop");
						bus.stop();
					}

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
			bus.drawBus(g);
		}

		for (Station station : stations) {
			station.drawStation(g);
		}
	}

	

}