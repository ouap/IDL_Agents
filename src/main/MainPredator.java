package main;

import Core.SMAPredator;
import vue.GraphicViewPredator;
import vue.View;

public class MainPredator {

	public static void main(String[] args) throws InterruptedException {
		SMAPredator simulation = new SMAPredator(10000, 40, 50, 50, 5, true, true, false, false, 1, 100);
		// NbAgents, nbTours, vitesse, height, width, agentsize, showGrid, equit
		View v = new GraphicViewPredator(simulation, "Chambre d'evolution");
		v.setVisible(true);
		simulation.run();
	}
}
