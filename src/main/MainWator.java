package main;

import java.io.IOException;

import vue.GraphicViewWator;
import vue.View;
import Core.SMAWator;
import agents.GameOverException;

public class MainWator {

	public static void main(String[] args) throws InterruptedException, IOException, GameOverException {
		if (args.length == 1 && args[0].equals("readme")) {
			// TODO by Yassine Badache "Afficher readme" for 10/02/2016
		}

		else if (args.length != 13) {
			// TODO by Yassine Badache "Afficher error file" for 10/02/2016
		}
		SMAWator simulation = new SMAWator(2000, 20, 100, 100, 5, false, true, true, 5000, 1000, 2, 9, 3);
		// NbAgents, nbTours, vitesse, height, width, agentsize, showGrid, equit
		View v = new GraphicViewWator(simulation, "Chambre d'evolution");
		v.setVisible(true);
		simulation.run();
	}
}
