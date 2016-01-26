package agents;

import java.awt.Color;

import grille.Environnement;

public class Fish extends Agent {
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
				//	System.out.println(posX+x+"   "+ (posY+y));
				if (!env.isOutOfBounds(posX+x, posY+y)) {
					if (env.getCell(posX+x, posY+y).getAgent() != null) {
						return false;
					}
				}
			}
		}
		return true;
	}


	public boolean isAlive(){
		return alive;
	}

	@Override
	public String type() {
		return "fish";
	}

	public static void setBreedTime(int time) {
		breedTime = time;
	}
}
