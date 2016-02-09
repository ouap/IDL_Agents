package Core;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import bille.GameOverException;

public abstract class SMA extends Observable {

	protected Environnement env;
	protected int nbTours;
	protected int vitesse;
	protected boolean equit;
	protected boolean toric;
	protected int nbAgents;
	protected int agentSize;
	protected boolean showGrid;
	protected List<Agent> agents = new ArrayList<Agent>();

	public SMA(int nbAgents, int nbTours, int vitesse, int height, int width, int agentSize, boolean showGrid, boolean equit, boolean toric) {
		this.nbAgents = nbAgents;
		this.vitesse = vitesse;
		this.nbTours = nbTours;
		this.equit = equit;
		this.showGrid = showGrid;
		this.toric = toric;
		this.agentSize = agentSize;
	}

	public abstract void init();

	public abstract void run() throws InterruptedException, GameOverException;

	public List<Agent> getAgents() {
		return agents;
	}

	public Environnement getEnv() {
		return env;
	}

	public int getAgentSize() {
		return agentSize;
	}

	public boolean isToric() {
		return toric;
	}

	public boolean showGrid() {
		// TODO Auto-generated method stub
		return showGrid;
	}
}
