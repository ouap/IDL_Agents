package grille;

import java.util.ArrayList;
import java.util.List;

import agents.Agent;
import agents.Fish;
import agents.Shark;

public class Environnement {
	private  Cellule[][] grille;
	boolean thorique;
	private List<Agent> agents;
	public List<Fish> fishList;
	public List<Shark> sharkList;

	public Environnement(int x, int y, List<Agent> agents, boolean toric) {
		fishList = new ArrayList<Fish>();
		sharkList = new ArrayList<Shark>();
		grille = new Cellule[x][y];
		this.agents = agents;
		thorique = toric;
		init();
	}

	public void init() {
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[0].length; j++) {
				grille[i][j] = new Cellule(i, j);
			}
		}
	}

	public boolean isFree(int posX, int posY){

		return grille[posX][posY].getAgent() == null;
	}

	public Cellule getCell(int x, int y) {
		return grille[x][y];
	}

	public boolean isOutOfBounds(int posX, int posY){
		return !((posX >= 0 && posX < getWidth()) &&  (posY >= 0 && posY < getHeight()));
	}

	public int getHeight() {
		return grille[0].length;
	}

	public int getWidth() {
		return grille.length;
	}

	public void removeAgent(Agent agent) {
		agents.remove(agent);
		if (agent.type().equals("fish")) {
			fishList.remove(agent);
		}else {
			sharkList.remove(agent);
		}
	}

	public void addAgent(Agent newAgent) {
		agents.add(newAgent);
		if (newAgent.type().equals("fish")) {
			fishList.add((Fish) newAgent);
		}else {
			sharkList.add((Shark)newAgent);
		}
	}

	public boolean isToric() {
		return thorique;
	}


}
