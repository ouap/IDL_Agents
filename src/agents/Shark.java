package agents;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import grille.Environnement;
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
		super.color = color.blue;
		this.starveShark = starveShark;
		breed = 0;
		alive = true;
		starveShark = 0;
	}

	@Override
	public void doIt() {
		Point posDir;

		// C'est la maure :(
		if (!alive) {
			return;
		}

		if (starve >= starveShark) {
			die();
		}

		// Si on atteint le temps limite :
		if (breed == breedTime) {
			Random r = new Random();

			// On chope une position random
			do {
				int direction = r.nextInt(8);
				dir = Direction.values()[direction];
				posDir = Direction.getPoint(dir);
			} while (env.isOutOfBounds(posX + posDir.x, posY + posDir.y) && !env.isFree(posDir.x, posDir.y));

			// On bouge d'abord, après on créé un Shark à la position
			// précédente
			updatePosition(posDir.x, posDir.y);
			env.getCell(posX - posDir.x, posY - posDir.y).setAgent(new Shark(env, posX - posDir.x, posY - posDir.y, 0));
		}

		// Si y'a un poisson, on le nique !!
		if (isFishAround()) {
			env.getCell(fishPos.x, fishPos.y).getAgent().die();
			updatePosition(fishPos.x, fishPos.y);
			starve = 0;
		}

		// Sinon on bouge au hasard
		else {
			System.out.println("Starve : " + starve);
			starve++;
			randomMove();
		}
	}

	private boolean isFishAround() {

		List<Point> pointsDir = new ArrayList<Point>(Direction.pointsDir.values());
		Collections.shuffle(pointsDir);
		for (Point point : pointsDir) {
			if (!env.isOutOfBounds(posX + point.x, posY + point.y) && env.getCell(posX + point.x, posY + point.y).getAgent() instanceof Fish) {
				fishPos.setLocation(posX + point.x, posY + point.y);
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
		env.getCell(posX, posY).clear();
		env.removeAgent(this);
		alive=false;
	}

	public static void setBreedTime(int time) {
		breedTime = time;
	}


}
