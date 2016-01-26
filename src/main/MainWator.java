package main;

import Core.SMAWator;
import vue.GraphicViewWator;
import vue.View;

public class MainWator {

	public static void main(String[] args) throws InterruptedException {
		SMAWator simulation = new SMAWator(2000, 50, 200, 200, 4, false, true, 8, 8000, 100);
		//NbAgents, nbTours, vitesse, height, width, agentsize, showGrid, equit
		View v = new GraphicViewWator(simulation, "Chambre d'evolution");
		simulation.run();
	}

}
