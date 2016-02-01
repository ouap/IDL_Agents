package agents;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import grille.Environnement;
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

	public Color getColor() {
		return color;
	}

	public void updatePosition(int newX, int newY) {
		// System.out.println("NewPos : + (" + newX + ", "+newY
		// +")   Direction : "+ dir);
		env.getCell(posX, posY).clear();
		if (env.isToric()) {
			posX = Math.floorMod(newX, env.getWidth());
			posY = Math.floorMod(newY, env.getHeight());
		}else{
			posX = newX;
			posY = newY;
		}

		env.getCell(posX, posY).setAgent(this);
	}

	public abstract String type();

	protected void randomMove() {

		List<Point> pointsDir = new ArrayList<Point>(Direction.pointsDir.values());
		Collections.shuffle(pointsDir);
		for (Point point : pointsDir) {
			if (!env.isOutOfBounds(posX + point.x, posY + point.y) && env.isFree(posX + point.x, posY + point.y)) {
				updatePosition((posX + point.x), (posY + point.y));
				break;

			}
		}
	}



	public abstract void die();

}