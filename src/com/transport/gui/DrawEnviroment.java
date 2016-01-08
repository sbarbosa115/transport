package com.transport.gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.transport.classes.*;

public class DrawEnviroment extends JPanel {
	List<Bus> buses;
	List<Station> stations;

	public DrawEnviroment(JFrame frame) {
		buses = new ArrayList<>();
		// --- Buses left
		buses.add(new Bus(100, 15, "left"));
		buses.add(new Bus(300, 15, "left"));
		buses.add(new Bus(500, 15, "left"));
		
		// --- Buses Rigth
		
		buses.add(new Bus(0, 100, "rigth"));
		buses.add(new Bus(200, 100, "rigth"));
		buses.add(new Bus(400, 100, "rigth"));
		buses.add(new Bus(600, 100, "rigth"));
		

		// --- Stations
		stations = new ArrayList<>();
		stations.add(new Station(200, 53));
		stations.add(new Station(400, 53));
		stations.add(new Station(600, 53));
		stations.add(new Station(800, 53));
		stations.add(new Station(1000, 53));

		/*Thread paintThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
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
		paintThread.start();*/
		Timer timer = new Timer(5, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //for(Station station : stations){
                    for (Bus bus : buses) {       
                    	
                        bus.stop(stationsPositionsX(), buses);
                        bus.setDirection(frame);
                        //stopQueue(bus);
                        repaint();
                    }
                //}
            }
        });
        timer.start();
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