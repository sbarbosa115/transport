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
		buses.add(new Bus(0, 15, "left"));
		buses.add(new Bus(frame.getWidth(), 100, "rigth")); 

		stations = new ArrayList<>();
		stations.add(new Station(80, 60));
		stations.add(new Station(220, 60));
		stations.add(new Station(360, 60));
	
		Timer timer = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Station station : stations){
					for (Bus bus : buses) {						
						bus.stop(station);
						bus.setDirection(frame);
						repaint();
					}
				}
			}
		});
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Station station : stations) {
			station.drawStation(g);
			for (Bus bus : buses) {
				if(bus.status == "run"){
					bus.drawBus(g);
				}	
			}
		}
	}
	


}