package main;

import vue.GraphicViewBille;
import vue.View;
import Core.SMABille;
import agents.GameOverException;

public class MainBille {

	public static void main(String[] args) throws InterruptedException, GameOverException {
		SMABille simulation = new SMABille(100, 2000, 40, 100, 100, 7, false, true, true);
		// NbAgents, nbTours, vitesse, height, width, agentsize, showGrid, equit
		View v = new GraphicViewBille(simulation, "Chambre d'evolution");
		v.setVisible(true);
		simulation.run();
	}
}
