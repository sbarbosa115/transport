package com.transport.gui;

import javax.swing.*;
import java.awt.*;

public class Enviroment {

	public int x = 0;
	public int y = 0;
	public int width = 500;
	public int height = 500;

	public void createEnviroment() {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new DrawEnviroment(frame));
                frame.setTitle("Traffic Simulator V1.0");
                frame.setSize(width, height);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
	}

}
