package main;

import vue.GraphicViewWator;
import vue.View;
import Core.SMAWator;

public class MainWator {

	public static void main(String[] args) throws InterruptedException {
		SMAWator simulation = new SMAWator(2000, 50, 200, 200, 4, false, true, 8, 80, 1000);
		// NbAgents, nbTours, vitesse, height, width, agentsize, showGrid, equit
		View v = new GraphicViewWator(simulation, "Chambre d'evolution");
		simulation.run();
	}

}
