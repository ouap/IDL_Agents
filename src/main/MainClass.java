package main;

import model.SMA;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		SMA simulation = new SMA(10,1000, 1, 100, 300, true);
		//View v = new GraphicView(simulation);
		//v.setVisible(true);
		simulation.run();

	}
}
