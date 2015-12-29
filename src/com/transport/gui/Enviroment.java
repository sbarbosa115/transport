package com.transport.gui;

import javax.swing.*;
import java.awt.*;

public class Enviroment {

	public int x = 0;
	public int y = 0;
	public int width = 1024;
	public int height = 768;

	public void createEnviroment() {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                //JPanel panel = new JPanel(new GridLayout(1, 2));
                //panel.add(new DrawStation(frame));
                //panel.add(new DrawBus(frame));
                frame.add(new DrawBus(frame));
                //frame.add(new DrawBus(frame));
                frame.setTitle("Traffic Simulator V1.0");
                frame.setSize(width, height);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
	}

}
