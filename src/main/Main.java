package main;

import com.transport.gui.Enviroment;

public class Main {

	/**
	 * Run all simulation.
	 * @param args
	 */
	public static void main(String[] args) {
		// Instance  the environment class, this launch all Simulation. 
		Enviroment env = new Enviroment();
		env.createEnviroment();
	}

}
