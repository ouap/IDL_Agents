package Core;

import grille.EnvironnementHunter;

import java.util.Collections;
import java.util.Random;

import agents.Agent;
import agents.GameOverException;
import agents.Predator;
import agents.Rock;
import agents.You;

public class SMAPredator extends SMA {
	private int nbPredator;
	private int nbRock;
	public boolean showNumbers;
	public boolean isFairPlay;
	private You you;

	public SMAPredator(int nbTours, int vitesse, int height, int width, int agentSize, boolean showGrid, boolean equit, boolean toric, boolean showNumbers,
			boolean isFairPlay, int nbPredator, int nbRock) {
		super(nbRock + nbPredator + 1, nbTours, vitesse, height, width, agentSize, showGrid, equit, toric);
		this.nbPredator = nbPredator;
		this.nbRock = nbRock;
		this.showNumbers = showNumbers;
		this.isFairPlay = isFairPlay;
		super.env = new EnvironnementHunter(width, height, agents, toric);
		init();
	}

	@Override
	public void init() {
		int x, y;
		Random r = new Random();

		for (int i = 0; i < nbRock; i++) {
			do {
				y = r.nextInt(env.getWidth());
				x = r.nextInt(env.getHeight());
			} while (!env.getCell(x, y).isEmpty());
			Rock newRock = new Rock(x, y, env);

			env.getCell(x, y).setAgent(newRock);

			agents.add(env.getCell(x, y).getAgent());
		}

		for (int i = 0; i < nbPredator; i++) {

			do {
				y = r.nextInt(env.getWidth());
				x = r.nextInt(env.getHeight());
			} while (!env.getCell(x, y).isEmpty());
			Predator newPredator = new Predator(x, y, ((EnvironnementHunter) env), isFairPlay);

			env.getCell(x, y).setAgent(newPredator);
			agents.add(env.getCell(x, y).getAgent());
		}

		do {
			y = r.nextInt(env.getWidth());
			x = r.nextInt(env.getHeight());
		} while (!env.getCell(x, y).isEmpty());
		you = new You(x, y, env);

		env.getCell(x, y).setAgent(you);
		agents.add(env.getCell(x, y).getAgent());
		((EnvironnementHunter) env).initDijkstra(x, y);
		((EnvironnementHunter) env).doDijkstra(x, y, 0);
	}

	public You getYou() {
		return you;
	}

	@Override
	public void run() throws InterruptedException, GameOverException {
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
