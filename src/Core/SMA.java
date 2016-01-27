package Core;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import agents.Agent;
import grille.Environnement;

public abstract class SMA extends Observable{


	protected Environnement env;
	protected int nbTours;
	protected int vitesse;
	protected boolean equit;
	protected boolean toric;
	protected int nbAgents;
	protected int agentSize;
	protected boolean showGrid;
	List<Agent> agents = new ArrayList<Agent>();


	public SMA(int nbAgents, int nbTours, int vitesse, int height, int width, int agentSize, boolean showGrid, boolean equit ) {
		System.out.println(""+height+ "  "+width);
		this.nbAgents = nbAgents;
		this.vitesse = vitesse;
		this.nbTours=nbTours;
		this.equit = equit;
		this.showGrid = showGrid;
		toric = false;
		this.agentSize = agentSize;
		env = new Environnement(height, width, agents);
	}

	public  abstract void init();



	public List<Agent> getAgents() {
		return agents;
	}

	public Environnement getEnv(){
		return env;
	}
	public int getAgentSize(){
		return agentSize;
	}
	public boolean isToric(){
		return toric;
	}
	public boolean showGrid() {
		// TODO Auto-generated method stub
		return showGrid;
	}
}
