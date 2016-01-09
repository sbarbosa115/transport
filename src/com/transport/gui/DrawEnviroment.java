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
	List<TrafficLight> trafficLights;

	public DrawEnviroment(JFrame frame) {
		this.buildObjects();
		Timer timer = new Timer(5, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Bus bus : buses) {
					bus.stop(stationsPositionsX(), buses);
					bus.setDirection(frame);
					repaint();
				}
				
				for (TrafficLight trafficLigth : trafficLights) {
					trafficLigth.changeColor();
				}
			}
		});
		timer.start();
	}
	
	private void buildObjects(){
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
		stations.add(new Station(700, 53));
		stations.add(new Station(900, 53));
		stations.add(new Station(1100, 53));
		
		// --- Stations
		trafficLights = new ArrayList<>();
		trafficLights.add(new TrafficLight(600, 150));
		
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
		}
		for (Bus bus : buses) {
			bus.drawBus(g);
		}
		for (TrafficLight trafficLigth : trafficLights) {
			trafficLigth.drawTrafficLigth(g);
		}
	}

}