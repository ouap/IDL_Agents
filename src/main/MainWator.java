package main;

import vue.GraphicViewWator;
import vue.View;
import Core.SMAWator;

public class MainWator {

	public static void main(String[] args) throws InterruptedException {
		SMAWator simulation = new SMAWator(2000, 50, 100, 100, 3, false, true, 12, 9000, 1000);
		// NbAgents, nbTours, vitesse, height, width, agentsize, showGrid, equit
		View v = new GraphicViewWator(simulation, "Chambre d'evolution");
		simulation.run();
	}

}
