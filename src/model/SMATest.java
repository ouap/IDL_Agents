package model;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	import java.util.Observable;
	import java.util.Random;

	import agents.Agent;
	import agents.Bille;
	import grille.Environnement;

public class SMATest extends Observable	{
	
		public Environnement env;
		private int nbAgents;
		private int nbTours;
		private int vitesse;
		private int x;
		private int y;
		private boolean equit;
		List<Agent> agents = new ArrayList<Agent>();

		public SMATest(int x, int y, int nbTours, int vitesse, int height, int length) {
			super();
			this.vitesse = vitesse;
			this.nbTours=nbTours;
			this.x = x;
			this.y = y;
			env = new Environnement(height, length);
			init(x, y);
		}

		public void init(int x, int y) {
			env.getCell(x, y).setAgent(new Bille(env, x, y));
			agents.add(env.getCell(x, y).getAgent());
		}

		public void run() throws InterruptedException {

			for (int i = 0; i < nbTours; i++) {
				for (Agent a : agents) {
					a.doIt();
				}

				Thread.sleep(vitesse);
				System.out.println("Tour " + i);
				setChanged();
				notifyObservers();
			}
		}

		public List<Agent> getAgents() {
			return agents;
		}
}
