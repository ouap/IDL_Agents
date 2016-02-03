package agents;

import grille.EnvironnementHunter;

import java.awt.Color;
import java.awt.Point;

import utils.Direction;

public class Predator extends Agent {

	public Predator(int x, int y, EnvironnementHunter env) {
		super(x, y, env);
		color = Color.RED;
	}

	@Override
	public void doIt() {
		Point min = null;
		int minVal = Integer.MAX_VALUE;
		for (Point p : Direction.pointsDir.values()) {
			if (!env.isOutOfBounds(posX + p.x, posY + p.y) && env.isFree(posX + p.x, posY + p.y)) {
				if (((EnvironnementHunter) env).getDijkstraTab()[posX + p.x][posY + p.y] < minVal
						&& ((EnvironnementHunter) env).getDijkstraTab()[posX + p.x][posY + p.y] != -1) {
					minVal = ((EnvironnementHunter) env).getDijkstraTab()[posX + p.x][posY + p.y];
					min = p;
				}
			}
		}

		if (((EnvironnementHunter) env).isFree(posX + min.x, posY + min.y))
			updatePosition(posX + min.x, posY + min.y);
	}

	@Override
	public String type() {
		return "predator";
	}

	@Override
	public void die() {
		return;
	}

}
