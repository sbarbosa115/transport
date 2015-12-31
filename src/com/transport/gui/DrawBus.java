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
		buses.add(new Bus(frame.getWidth(), 0, "left"));
		buses.add(new Bus(0, 100, "rigth"));

		stations = new ArrayList<>();
		stations.add(new Station(500, 60));
		for (Station station : stations) {
			repaint();
		}

		Timer timer = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Bus bus : buses) {
					bus.stop();
					bus.setDirection(frame);
					repaint();
				}
			}
		});
		timer.start();
	}
	
	public void pull(){
		
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
				this.near(bus, station);
			}
		}
	}
	
	public void near(Bus bus, Station station){
		if(bus.getX() == station.getX()){
			System.out.print("Near");
		}
	}

}