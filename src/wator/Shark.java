package wator;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Core.Agent;
import Core.Environnement;
import utils.Direction;

public class Shark extends Agent {
	private static int breedTime;
	private int breed;
	private boolean alive;
	private int starveShark;
	private int starve = 0;
	private Point fishPos = new Point();

	public Shark(Environnement env, int x, int y, int starveShark) {
		super(x, y, env);
		super.color = Color.BLUE;
		this.starveShark = starveShark;
		breed = 0;
		alive = true;
	}

	@Override
	public void doIt() {
		// C'est la maure :(
		if (!alive) {
			return;
		}

		if (starve >= starveShark) {
			die();
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
					// System.out.println("Let's move !");
					updatePosition(posX + point.x, posY + point.y);
					Shark newShark = new Shark(env, posX - point.x, posY - point.y, starveShark);
					env.getCell(posX - point.x, posY - point.y).setAgent(newShark);
					((EnvironnementWator) env).addAgent(newShark);
					breed = 0;
					break;
				}
			}
		}

		// Si y'a un poisson, on le nique !!
		if (isFishAround()) {
			// System.out.println("FIIIISH");
			env.getCell(fishPos.x, fishPos.y).getAgent().die();
			updatePosition(fishPos.x, fishPos.y);
			starve = 0;
			breed++;
		}

		// Sinon on bouge au hasard
		else {
			starve++;
			breed++;
			randomMove();
		}
	}

	private boolean isFishAround() {

		List<Point> pointsDir = new ArrayList<Point>(Direction.pointsDir.values());
		Collections.shuffle(pointsDir);
		for (Point point : pointsDir) {
			if (!env.isOutOfBounds(posX + point.x, posY + point.y) && env.getCell(posX + point.x, posY + point.y).getAgent() instanceof Fish) {
				fishPos.setLocation((posX + point.x), (posY + point.y));
				return true;
			}
		}
		return false;
	}

	public boolean isAlive() {
		return alive;
	}

	@Override
	public String type() {
		return "shark";
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