package com.transport.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawStation extends JPanel {
	List<Station> stations;

	public DrawStation(JFrame frame) {
		stations = new ArrayList<>();
		stations.add(new Station(100, 100));
		
		for (Station station : stations) {
			repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Station station : stations) {
			station.drawStation(g);
		}
	}

	public class Station {
		private int x, y;

		public Station(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void drawStation(Graphics g) {
			g.setColor(Color.GRAY);
			g.fillRect(x, y, 75, 30);
		}
	}

}