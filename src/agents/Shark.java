package agents;

import java.awt.Point;
import java.util.Random;

import grille.Environnement;
import utils.Direction;

public class Shark extends Agent {
	private static int breedTime;
	private int breed;
	private boolean alive;
	private int starveShark;
	private Point fishPos;

	public Shark(Environnement env, int x, int y, int starveShark) {
		super(x, y, env);
		super.color = color.blue;
		this.starveShark = starveShark;
		breed = 0;
		alive = true;
	}

	@Override
	public void doIt() {
		Point posDir;

		// C'est la maure :(
		if (!alive) {
			return;
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

			// On bouge d'abord, après on créé un Shark à la position précédente
			updatePosition(posDir.x, posDir.y);
			env.getCell(posX - posDir.x, posY - posDir.y).setAgent(new Shark(env, posX - posDir.x, posY - posDir.y, 0));
		}

		// Si y'a un poisson, on le nique !!
		if (isFishAround()) {
			env.getCell(fishPos.x, fishPos.y).getAgent().die();
			updatePosition(fishPos.x, fishPos.y);
			starveShark = 0;
		}

		// Sinon on bouge au hasard
		else {
			randomMove();
		}
	}

	private boolean isFishAround() {
		for (int x = -1; x < 1; x++) {
			for (int y = -1; y < 1; y++) {
				//System.out.println(posX + x + "   " + (posY + y));
				if (!env.isOutOfBounds(posX + x, posY + y)) {
					if (env.getCell(posX + x, posY + y).getAgent() instanceof Fish) {
						fishPos = new Point(posX + x, posY + x);
						return true;
					}
				}
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
		// TODO Auto-generated method stub

	}

	public static void setBreedTime(int time) {
		breedTime = time;
	}


}
