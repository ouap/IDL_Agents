package model;

import grille.Environnement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import agents.Agent;
import agents.Bille;

public class SMA extends Observable {
	public Environnement env;
	private int nbAgents;
	private int vitesse;
	List<Agent> agents = new ArrayList<Agent>();

	public SMA(int nbAgents, int vitesse, int height, int length) {
		super();
		this.nbAgents = nbAgents;
		this.vitesse = vitesse;
		env = new Environnement(height, length);
		init(nbAgents, height, length);
	}

	public void init(int nbBille, int height, int lenght) {
		Random r = new Random();

		for (int i = 0; i < nbBille; i++) {
			int x, y;
			do {
				y = r.nextInt(env.grille.length) % lenght;
				x = r.nextInt(env.grille[0].length) % height;
				System.out.println("y : " + y + " - x : " + x);
			} while (!env.grille[x][y].isEmpty());

			System.out.println("We set the cell !");
			env.getCell(x, y).setAgent(new Bille(env, x, y));
			agents.add(env.getCell(x, y).getAgent());
		}
	}

	public void run(int nbTour, int vitesse) throws InterruptedException {

		for (int i = 0; i < nbTour; i++) {

			Collections.shuffle(agents);

			for (Agent a : agents) {
				a.doIt();
			}

			Thread.sleep(vitesse);
			notifyObservers();
		}
	}

}