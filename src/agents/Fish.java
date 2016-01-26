package agents;

import java.awt.Point;
import java.util.Random;

import grille.Environnement;
import utils.Direction;

public class Fish extends Agent{
	private static int breedTime;
	private int breed;
	private boolean alive;

	public Fish(Environnement env, int x, int y) {
		super.env = env;
		super.posX = x;
		super.posY =y;
		super.color = color.lightGray;
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
		Point pos;
		do {
			int direction = r.nextInt(8);
			dir = Direction.values()[direction];
			pos = Direction.getPoint(dir);
		} while (env.isFree(pos.x, pos.y));

		updatePosition(pos.x, pos.y);


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
