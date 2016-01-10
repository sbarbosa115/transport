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

	/**
	 * This part of the code paints the overall environment, 
	 * is the party responsible for performing actions every 5 milliseconds.
	 */
	public DrawEnviroment(JFrame frame) {
		this.buildObjects();
		Timer timer = new Timer(5, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Bus bus : buses) {
					bus.stopStation(stationsPositionsX(), buses);
					bus.stopTrafficBus(stationsPositionsX(), buses);
					bus.stopTrafficBusNear(stationsPositionsX(), buses);
					bus.stopTrafficLight(600, buses, trafficLights.get(0));
					bus.changeDirection(frame);
					repaint();
				}
				
				for (TrafficLight trafficLigth : trafficLights) {
					trafficLigth.changeColor();
				}
			}
		});
		timer.start();
	}
	
	/**
	 * Here the agents are created the two agents. 
	 * In the class diagram and document talking about people but we ran out of time to implement it.
	 * 
	 * This part is dynamic, depending on the requirement classes to add more agents to the simulation are created, 
	 * we fail to solve problems that were added in a dynamic position.
	 * 
	 * Aggregates agents must follow the rules of object collisions, 
	 * so we must give the parameters in x, and taking into account the locations of the other objects in the window.
	 */
	private void buildObjects(){
		buses = new ArrayList<>();
		// --- Buses left
		buses.add(new Bus(100, 15, "left"));
		buses.add(new Bus(300, 15, "left"));
		buses.add(new Bus(500, 15, "left"));

		// --- Buses Rigth
		buses.add(new Bus(0, 100, "rigth"));
		buses.add(new Bus(200, 100, "rigth"));
		buses.add(new Bus(290, 100, "rigth"));
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

	/**
	 * This part of the code is responsible for social skills, 
	 * among the agents of bus type and station type agents, 
	 * in a nutshell is responsible for telling the bus agent that is close to a station and must stop. 
	 */
	public List<Integer> stationsPositionsX() {
		List<Integer> positions = new ArrayList<Integer>();
		for (Station station : stations) {
			positions.add(station.getX());
		}
		return positions;
	}

	/**
	 * It is responsible for rendering each of the agents within the frame.
	 */
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