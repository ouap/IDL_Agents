package main;

import Core.SMABille;
import vue.GraphicViewBille;
import vue.View;

public class MainBille {

	public static void main(String[] args) throws InterruptedException {
		SMABille simulation = new SMABille(100, 2000, 40, 100, 100, 7, false, true);
		//NbAgents, nbTours, vitesse, height, width, agentsize, showGrid, equit
		View v = new GraphicViewBille(simulation, "Chambre d'evolution");
		simulation.run();
	}
}
