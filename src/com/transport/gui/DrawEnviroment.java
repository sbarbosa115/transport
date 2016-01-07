package com.transport.gui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.transport.classes.*;

public class DrawEnviroment extends JPanel {
	List<Bus> buses;
	List<Station> stations;

	public DrawEnviroment(JFrame frame) {
		buses = new ArrayList<>();
		buses.add(new Bus(0, 15, "left"));
		buses.add(new Bus(80, 15, "left"));
		buses.add(new Bus(130, 15, "left"));
		buses.add(new Bus(frame.getWidth(), 100, "rigth"));
		buses.add(new Bus(frame.getWidth() + 100, 100, "rigth"));

		stations = new ArrayList<>();
		stations.add(new Station(80, 60));
		stations.add(new Station(220, 60));
		stations.add(new Station(360, 60));

		Thread paintThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(7);
						for (Bus bus : buses) {
							bus.stop(stationsPositionsX(), buses);
							bus.setDirection(frame);
							//stopQueue(bus);
							repaint();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		paintThread.start();
	}
	

	public List<Integer> stationsPositionsX() {
		List<Integer> positions = new ArrayList<Integer>();
		for (Station station : stations) {
			positions.add(station.getX());
		}
		return positions;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Station station : stations) {
			station.drawStation(g);
			for (Bus bus : buses) {
				bus.drawBus(g);
			}
		}
	}

}