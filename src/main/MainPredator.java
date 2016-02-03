package main;

import vue.GraphicViewPredator;
import vue.View;
import Core.SMAPredator;
import agents.GameOverException;

public class MainPredator {

	public static void main(String[] args) throws InterruptedException, GameOverException {
		// nbTours, vitesse, height, width, agentSize, showGrid, equit, toric,
		// showNumbers, nbPred, nbRocks
		SMAPredator simulation = new SMAPredator(10000, 100, 50, 50, 15, true, true, false, true, 1, 0);
		// NbAgents, nbTours, vitesse, height, width, agentsize, showGrid, equit
		View v = new GraphicViewPredator(simulation, "Chambre d'evolution");
		v.setVisible(true);
		simulation.run();
	}
}
