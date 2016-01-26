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

	public Agent() {
		// TODO Auto-generated constructor stub
	}
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

	public void updatePosition(int newX, int newY) {
		System.out.println("NewPos : + (" + newX + ", "+newY +")   Direction : "+ dir);
		env.getCell(posX, posY).clear();
		posX = newX;
		posY = newY;
		env.getCell(posX, posY).setAgent(this);
	}

	public abstract String type();

}
