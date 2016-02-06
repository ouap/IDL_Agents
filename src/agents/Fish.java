package agents;

import grille.EnvironnementWator;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.Direction;

public class Fish extends Agent {
	private static int breedTime;
	private int breed;
	private boolean alive;

	public Fish(EnvironnementWator env, int x, int y) {
		super(x, y, env);
		color = Color.lightGray;
		breed = 0;
		alive = true;
	}

	@Override
	public void doIt() {
		if (!alive) {
			return;
		}

		if (isSurrounded()) {
			return;
		}

		// Si on atteint le temps limite :
		if (breed >= breedTime) {
			// On chope une position random
			List<Point> pointsDir = new ArrayList<Point>(Direction.pointsDir.values());
			Collections.shuffle(pointsDir);
			for (Point point : pointsDir) {
				if (!env.isOutOfBounds(posX + point.x, posY + point.y) && env.getCell(posX + point.x, posY + point.y).isEmpty()) {
					// On bouge d'abord, après on créé un Shark à la position
					// précédente
					updatePosition(posX + point.x, posY + point.y);
					Fish newFish = new Fish((EnvironnementWator) env, posX - point.x, posY - point.y);
					env.getCell(posX - point.x, posY - point.y).setAgent(newFish);
					((EnvironnementWator) env).addAgent(newFish);
					breed = 0;
					return;
				}
			}
		} else {
			randomMove();
		}

		breed++;

	}

	private boolean isSurrounded() {
		for (int x = -1; x < 1; x++) {
			for (int y = -1; y < 1; y++) {
				// TODO by Ouamar Sais "Virer les sysout aussi !!" for 10/02/2016
				// System.out.println(posX+x+"   "+ (posY+y));
				if (!env.isOutOfBounds(posX + x, posY + y)) {
					if (env.getCell(posX + x, posY + y).isEmpty()) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public boolean isAlive() {
		return alive;
	}

	@Override
	public String type() {
		return "fish";
	}

	@Override
	public void die() {
		env.getCell(posX, posY).clearWator();
		((EnvironnementWator) env).removeAgent(this);
		alive = false;
	}

	public static void setBreedTime(int time) {
		breedTime = time;
	}

	@Override
	public void updatePosition(int newX, int newY) {
		// TODO by Yassine Badache "Gérer override" for 08/02/2016
		env.getCell(posX, posY).clearWator();
		if (env.isToric()) {
			posX = Math.floorMod(newX, env.getWidth());
			posY = Math.floorMod(newY, env.getHeight());
		} else {
			posX = newX;
			posY = newY;
		}

		env.getCell(posX, posY).setAgent(this);
	}

}