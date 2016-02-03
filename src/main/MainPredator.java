package main;

import vue.GraphicViewPredator;
import vue.View;
import Core.SMAPredator;

public class MainPredator {

	public static void main(String[] args) throws InterruptedException {
		SMAPredator simulation = new SMAPredator(10000, 40, 50, 50, 15, true, true, false, true, 5, 100);
		// NbAgents, nbTours, vitesse, height, width, agentsize, showGrid, equit
		View v = new GraphicViewPredator(simulation, "Chambre d'evolution");
		v.setVisible(true);
		simulation.run();
	}
}
