package Core;

import grille.Environnement;

import java.util.Collections;
import java.util.Random;

import agents.Agent;
import agents.Bille;
import agents.GameOverException;

public class SMABille extends SMA {

	public SMABille(int nbAgents, int nbTours, int vitesse, int height, int length, int agentSize, boolean showGrid, boolean equit, boolean toric) {
		super(nbAgents, nbTours, vitesse, height, length, agentSize, showGrid, equit, toric);
		System.out.println("" + height + "  " + length);
		env = new Environnement(height, length, agents, toric);
		super.nbAgents = nbAgents;
		super.vitesse = vitesse;
		super.nbTours = nbTours;
		super.equit = equit;
		super.showGrid = showGrid;
		super.toric = false;
		this.agentSize = agentSize;
		init();
	}

	@Override
	public void init() {
		Random r = new Random();

		for (int i = 0; i < nbAgents; i++) {
			int x, y;
			do {
				y = r.nextInt(env.getWidth());
				x = r.nextInt(env.getHeight());
				System.out.println("y : " + y + " - x : " + x);
			} while (!env.getCell(x, y).isEmpty());

			env.getCell(x, y).setAgent(new Bille(env, x, y));
			agents.add(env.getCell(x, y).getAgent());
		}
	}

	@Override
	public void run() throws GameOverException {

		for (int i = 0; i < nbTours; i++) {
			if (equit) {
				Collections.shuffle(agents);
			}

			for (Agent a : agents) {
				a.doIt();
			}

			// System.out.println("Tour " + i);
			setChanged();
			notifyObservers();
			try {
				Thread.sleep(vitesse);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}