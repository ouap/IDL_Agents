package agents;

import grille.Environnement;
import grille.EnvironnementHunter;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import utils.Direction;

public class You extends Agent {

	public You(int x, int y, Environnement env) {
		super(x, y, env);
		color = Color.blue;
		Random r = new Random();

		int direction = r.nextInt(8);
		super.dir = Direction.values()[direction];
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}

	@Override
	public void doIt() {
		Point nexpos = Direction.getPoint(dir);
		if (!env.isOutOfBounds(posX + nexpos.x, posY + nexpos.y) && env.isFree(posX + nexpos.x, posY + nexpos.y)) {
			updatePosition(posX + nexpos.x, posY + nexpos.y);

		}
		((EnvironnementHunter) env).initDijkstra(posX, posY);
		((EnvironnementHunter) env).doDijkstra(super.getX(), super.getY(), 1);

	}

	@Override
	public String type() {
		return "you";
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub

	}

}
