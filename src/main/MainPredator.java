package main;

import vue.GraphicViewPredator;
import vue.View;
import Core.SMAPredator;
import agents.GameOverException;

public class MainPredator {

	public static void main(String[] args) throws InterruptedException, GameOverException {
		if (args.length == 1 && args[0].equals("readme")) {
			// TODO by Yassine "Afficher readme" for 10/02/2016
		}

		else if (args.length != 12) {
			// TODO by Yassine "Afficher error file" for 10/02/2016
		}

		// Paramètre vitesse poursuivants
		SMAPredator simulation = new SMAPredator(10000, 80, 50, 50, 20, false, true, false, false, true, 4, 250);
		View v = new GraphicViewPredator(simulation, "Chambre d'evolution");
		v.setVisible(true);
		simulation.run();
	}
}
