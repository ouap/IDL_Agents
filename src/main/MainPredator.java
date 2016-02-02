package main;

import Core.SMAPredator;
import vue.GraphicViewPredator;
import vue.View;

public class MainPredator {


	public static void main(String[] args) throws InterruptedException {
		SMAPredator simulation = new SMAPredator(0, 40, 20, 20, 15, true, true, false, 0, 1);
		// NbAgents, nbTours, vitesse, height, width, agentsize, showGrid, equit
		View v = new GraphicViewPredator(simulation, "Chambre d'evolution");
		v.setVisible(true);
		simulation.run();
	}
}
