package Core;

import java.util.Collections;
import java.util.Random;

import agents.Agent;
import agents.Predator;
import agents.Rock;

public class SMAPredator extends SMA {
	private int nbPredator;
	private int nbRock;

	public SMAPredator(int nbAgents, int nbTours, int vitesse, int height, int width, int agentSize, boolean showGrid,
			boolean equit, boolean toric, int nbPredator, int nbRock) {
		super(nbAgents, nbTours, vitesse, height, width, agentSize, showGrid, equit, toric);
		this.nbPredator=nbPredator;
		this.nbRock = nbRock;
	}

	@Override
	public void init() {
		Random r = new Random();
		for (int i = 0; i < nbRock; i++) {
			int x, y;
			do {
				y = r.nextInt(env.getWidth());
				x = r.nextInt(env.getHeight());
			} while (!env.getCell(x, y).isEmpty());
			Rock newRock = new Rock(x, y, env);

			env.getCell(x, y).setAgent(newRock);
			agents.add(env.getCell(x, y).getAgent());
		}


		for (int i = 0; i < nbPredator; i++) {
			int x, y;
			do {
				y = r.nextInt(env.getWidth());
				x = r.nextInt(env.getHeight());
			} while (!env.getCell(x, y).isEmpty());
			Predator newRock = new Predator(x, y, env);

			env.getCell(x, y).setAgent(newRock);
		}

	}

	@Override
	public void run() throws InterruptedException {
		for (int i = 0; i < nbTours; i++) {
			if (equit) {
				Collections.shuffle(agents);
			}

			for (Agent a : agents) {
				a.doIt();
			}

			//System.out.println("Tour " + i);
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
