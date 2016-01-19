package Grille;

import Agents.Agent;

public class Cellule {
	int x;
	int y;
	Agent agent;

	public Cellule(int x, int y){
		this.x =x;
		this.y=y;
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

	public void setAgent(Agent a){
		agent = a;
	}
	public boolean isEmpty(){
		return agent == null ? true : false;
	}

}
