package agents;

import grille.Environnement;

public class Predator extends Agent {
	private boolean alive;

	public Predator(int x, int y, Environnement env) {
		super(x, y, env);
	}

	@Override
	public void doIt() {
		// TODO Method doIt

	}

	@Override
	public String type() {
		return "predator";
	}

	@Override
	public void die() {
		env.getCell(posX, posY).clear();
		env.removeAgent(this);
		alive = false;
	}

}
