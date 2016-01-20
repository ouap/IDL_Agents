package main;

import model.SMA;
import vue.GraphicView;
import vue.View;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		SMA simulation = new SMA(500, 100, 300, 500, 500, 5, false, true);
		View v = new GraphicView(simulation, "Chambre d'evolution");
		simulation.run();

	}
}
