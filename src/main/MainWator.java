package main;

import java.io.IOException;

import vue.GraphicViewWator;
import vue.View;
import Core.SMAWator;

public class MainWator {

	public static void main(String[] args) throws InterruptedException, IOException {
		SMAWator simulation = new SMAWator(2000, 100, 200, 200, 4, false, true, true, 8000, 500);
		// NbAgents, nbTours, vitesse, height, width, agentsize, showGrid, equit
		View v = new GraphicViewWator(simulation, "Chambre d'evolution");
		v.setVisible(true);
		simulation.run();
	}

}
