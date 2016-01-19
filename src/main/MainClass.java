package main;

import model.SMA;
import vue.GraphicView;
import vue.View;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		SMA simulation = new SMA(5,1000, 1000, 800, 600, true);
		View v = new GraphicView(simulation);
		simulation.run();
	}
}
