package agents;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import grille.Environnement;
import utils.Direction;

public class Fish extends Agent{
	private static int breedTime;
	private int breed;
	private boolean alive;

	public Fish(Environnement env, int x, int y) {
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

		randomMove();

	}


	private boolean isSurrounded() {
		for (int x = -1; x < 1; x++) {
			for (int y = -1; y < 1; y++) {
				System.out.println(posX+x+"   "+ (posY+y));
				if (!env.isOutOfBounds(posX+x, posY+y)) {
					if (env.getCell(posX+x, posY+y).getAgent() != null) {
						return false;
					}
				}
			}
		}
		return true;
	}


	private void randomMove() {
		Random r = new Random();
		Point posDir;
		do {
			int direction = r.nextInt(8);
			dir = Direction.values()[direction];
			posDir = Direction.getPoint(dir);
		} while (env.isOutOfBounds(posX+ posDir.x, posY + posDir.y) && !env.isFree(posDir.x, posDir.y));

		updatePosition(posDir.x, posDir.y);
	}


	public boolean isAlive(){
		return alive;
	}

	@Override
	public String type(){
		return "fish";
	}

	public static void setBreedTime(int time){
		breedTime = time;
	}
}
