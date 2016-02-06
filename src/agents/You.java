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
			((EnvironnementHunter) env).initDijkstra(posX, posY);
			((EnvironnementHunter) env).doDijkstra(super.getX(), super.getY(), 1);
		}
	}

	@Override
	public String type() {
		return "you";
	}

	@Override
	public void die() {
		// TODO by Yassine Badache "méthode die()" for 10/02/2016
	}

	@Override
	public void updatePosition(int newX, int newY) {
		// TODO by Ouamar Sais "Virer les Sysout !!!" for 10/02/2016
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
