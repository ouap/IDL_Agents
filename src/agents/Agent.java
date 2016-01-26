package agents;

import grille.Environnement;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import utils.Direction;

public abstract class Agent {
	protected int posX;
	protected int posY;
	Environnement env;
	Color color;
	protected Direction dir;

	public Agent(int x, int y, Environnement env) {
		this.env = env;
		posX = x;
		posY = y;
	}

	public abstract void doIt();

	public int getX() {
		return posX;
	}

	public int getY() {
		return posY;
	}

	public Environnement getEnv() {
		return env;
	}

	public Color getColor() {
		return color;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void updatePosition(int newX, int newY) {
		System.out.println("NewPos : + (" + newX + ", " + newY + ")   Direction : " + dir);
		env.getCell(posX, posY).clear();
		posX = newX;
		posY = newY;
		env.getCell(posX, posY).setAgent(this);
	}

	public abstract String type();

	protected void randomMove() {
		Random r = new Random();
		Point posDir;
		do {
			int direction = r.nextInt(8);
			dir = Direction.values()[direction];
			posDir = Direction.getPoint(dir);
		} while (env.isOutOfBounds(posX + posDir.x, posY + posDir.y) && !env.isFree(posDir.x, posDir.y));

		updatePosition(posDir.x, posDir.y);
	}

}
