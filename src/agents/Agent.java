package agents;

import java.awt.Color;

import grille.Environnement;
import utils.Direction;

public abstract class Agent {
	int posX;
	int posY;
	Environnement env;
	Color color;
	Direction dir;

	public abstract void doIt();

	public int getX() {
		return posX;
	}

	public int getY() {
		return posY;
	}

	public Color getColor() {
		return color;
	}

}
