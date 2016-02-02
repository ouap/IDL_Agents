package grille;

import java.util.List;

import agents.Agent;

public class Environnement {
	private  Cellule[][] grille;
	boolean thorique;
	protected List<Agent> agents;

	public Environnement(int x, int y, List<Agent> agents, boolean toric) {
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

		return getCell(posX, posY).isEmpty();
	}

	public Cellule getCell(int x, int y) {
		if (isToric()) {
			return grille[Math.floorMod(x, getWidth())][Math.floorMod(y, getHeight())];
		}
		return grille[x][y];
	}

	public boolean isOutOfBounds(int posX, int posY){
		if (isToric()) {
			return false;
		}
		return !((posX >= 0 && posX < getWidth()) &&  (posY >= 0 && posY < getHeight()));
	}

	public int getHeight() {
		return grille[0].length;
	}

	public int getWidth() {
		return grille.length;
	}

	public boolean isToric() {
		return thorique;
	}

}
