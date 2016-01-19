package model;

import java.util.List;
import java.util.Observable;
import java.util.Random;

import Agents.Agent;
import Agents.Bille;
import Grille.Environnement;


public class SMA extends Observable{
	Environnement env;
	private int nbAgents;
	private int vitesse;
	List<Agent> agents;

	public SMA(int nbAgents, int vitesse, int height, int length) {
		super();
		this.nbAgents = nbAgents;
		this.vitesse = vitesse;
		env = new Environnement(height, length);
	}


	public void init(int nbBille){
		Random r = new Random();

		for (int i = 0 ; i < nbBille ; i++) {
			int x, y;
			do {
				y = r.nextInt(env.grille.length);
				x = r.nextInt(env.grille[0].length);
			} while (env.grille[x][y] != null);

			env.getCell(x, y).setAgent(new Bille(env, x, y));
			agents.add(env.getCell(x, y).getAgent());
		}
	}

	public void run(int nbTour, int vitesse) throws InterruptedException{

		for (int i = 0; i < nbTour; i++) {
			for (Agent a : agents) {
				a.doIt();
			}

			Thread.sleep(vitesse);
			notifyObservers();
		}
	}


}