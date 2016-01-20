package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import agents.Agent;
import agents.Bille;
import grille.Environnement;

public class SMA extends Observable {
	private Environnement env;
	private int nbAgents;
	private int nbTours;
	private int agentSize;
	private int vitesse;
	private boolean equit;
	private boolean showGrid;
	List<Agent> agents = new ArrayList<Agent>();

	public SMA(int nbAgents,int nbTours, int vitesse, int height, int length, int agentSize, boolean showGrid, boolean equit) {
		super();
		System.out.println(""+height+ "  "+length);
		this.nbAgents = nbAgents;
		this.vitesse = vitesse;
		this.nbTours=nbTours;
		this.equit = equit;
		this.showGrid = showGrid;
		this.agentSize = agentSize;
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

			env.getCell(x, y).setAgent(new Bille(env, x, y));
			agents.add(env.getCell(x, y).getAgent());
		}
	}

	public void run() throws InterruptedException {

		for (int i = 0; i < nbTours; i++) {
			if (equit) {
				Collections.shuffle(agents);
			}

			for (Agent a : agents) {
				a.doIt();
			}

			System.out.println("Tour " + i);
			setChanged();
			notifyObservers();
			Thread.sleep(vitesse);
		}
	}

	public List<Agent> getAgents() {
		return agents;
	}

	public Environnement getEnv(){
		return env;
	}
	public int getAgentSize(){
		return agentSize;
	}

	public boolean showGrid() {
		// TODO Auto-generated method stub
		return showGrid;
	}
}