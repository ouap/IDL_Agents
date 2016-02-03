package main;

import java.io.IOException;

import vue.GraphicViewWator;
import vue.View;
import Core.SMAWator;
import agents.GameOverException;

public class MainWator {

	public static void main(String[] args) throws InterruptedException, IOException, GameOverException {
		SMAWator simulation = new SMAWator(2000, 20, 200, 200, 5, false, true, true, 25000, 10000);
		// NbAgents, nbTours, vitesse, height, width, agentsize, showGrid, equit
		View v = new GraphicViewWator(simulation, "Chambre d'evolution");
		v.setVisible(true);
		simulation.run();
	}
}
