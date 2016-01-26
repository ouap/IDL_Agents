package main;

import Core.SMAWator;
import vue.GraphicViewWator;
import vue.View;

public class MainWator {

	public static void main(String[] args) throws InterruptedException {
		SMAWator simulation = new SMAWator(2000, 50, 200, 200, 2, false, true, 9000, 1000);
		// NbAgents, nbTours, vitesse, height, width, agentsize, showGrid, equit
		View v = new GraphicViewWator(simulation, "Chambre d'evolution");
		simulation.run();
	}

}
