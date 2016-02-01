package grille;

import agents.Agent;

public class Cellule {
	public int x;
	public int y;
	Agent agent;
	boolean free;

	public Cellule(int x, int y) {
		this.x = x;
		this.y = y;
		free = true;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent a) {
		agent = a;
		free = false;
	}

	public boolean isEmpty() {
		return free;
	}

	public void clear() {
		free = true;
	}

}