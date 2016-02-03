package main;

import vue.GraphicViewPredator;
import vue.View;
import Core.SMAPredator;
import agents.GameOverException;

public class MainPredator {

	public static void main(String[] args) throws InterruptedException, GameOverException {
		// nbTours, vitesse, height, width, agentSize, showGrid, equit, toric,
		// showNumbers, nbPred, nbRocks
		SMAPredator simulation = new SMAPredator(10000, 80, 80, 80, 10, true, true, false, false, false, 4, 250);
		// NbAgents, nbTours, vitesse, height, width, agentsize, showGrid, equit
		View v = new GraphicViewPredator(simulation, "Chambre d'evolution");
		v.setVisible(true);
		simulation.run();
	}
}
