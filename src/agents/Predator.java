package agents;

import grille.EnvironnementHunter;

import java.awt.Color;
import java.awt.Point;

import utils.Direction;

public class Predator extends Agent {

	private boolean isFairPlay;

	public Predator(int x, int y, EnvironnementHunter env, boolean isFairPlay) {
		super(x, y, env);
		this.isFairPlay = isFairPlay;
		color = Color.RED;
	}

	@Override
	public void doIt() throws GameOverException {
		Point min = null;
		int minVal = Integer.MAX_VALUE;
		for (Point p : Direction.pointsDir.values()) {
			if (isFairPlay && !isFair(p))
				continue;
			if (env.getCell(posX + p.x, posY + p.y).getAgent() instanceof You) {
				env.getCell(posX + p.x, posY + p.y).getAgent().die();
				throw new GameOverException();
			}
			if (!env.isOutOfBounds(posX + p.x, posY + p.y) && env.isFree(posX + p.x, posY + p.y)) {
				if (((EnvironnementHunter) env).getDijkstraTab()[posX + p.x][posY + p.y] < minVal
						&& ((EnvironnementHunter) env).getDijkstraTab()[posX + p.x][posY + p.y] != -1) {
					minVal = ((EnvironnementHunter) env).getDijkstraTab()[posX + p.x][posY + p.y];
					min = p;
				}
			}
		}

		// Dirtier trick than Thibault Rosa
		try {
			if (((EnvironnementHunter) env).getCell(posX + min.x, posY + min.y).isEmpty())
				updatePosition(posX + min.x, posY + min.y);
		} catch (NullPointerException e) {

		}
	}

	private boolean isFair(Point p) {
		if (Direction.pointsDir.get("NORD_EST").equals(p) || Direction.pointsDir.get("NORD_OUEST").equals(p) || Direction.pointsDir.get("SUD_EST").equals(p)
				|| Direction.pointsDir.get("SUD_OUEST").equals(p))
			return false;
		return true;
	}

	@Override
	public String type() {
		return "predator";
	}

	@Override
	public void die() {
		return;
	}

	@Override
	public void updatePosition(int newX, int newY) {
		env.getCell(posX, posY).clear();
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