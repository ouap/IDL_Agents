package main;

import model.SMA;
import vue.GraphicView;
import vue.View;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		SMA simulation = new SMA(200, 2000, 40, 100, 100, 7, false, true);
		//NbAgents, nbTours, vitesse, height, width, agentsize, showGrid, equit
		View v = new GraphicView(simulation, "Chambre d'evolution");
		simulation.run();
	}
}
