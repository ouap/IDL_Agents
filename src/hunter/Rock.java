package hunter;

import java.awt.Color;

import Core.Agent;
import Core.Environnement;

public class Rock extends Agent {

	public Rock(int x, int y, Environnement env) {
		super(x, y, env);
		color = Color.BLACK;
	}

	@Override
	public void doIt() {
		return;
	}

	@Override
	public String type() {
		return "rock";
	}

	@Override
	public void die() {
		return;
	}

	@Override
	public void updatePosition(int newX, int newY) {
		// TODO Auto-generated method stub

	}

}
