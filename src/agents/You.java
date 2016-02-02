package agents;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import grille.Environnement;
import grille.EnvironnementHunter;
import utils.Direction;

public class You extends Agent {

	public You(int x, int y, Environnement env) {
		super(x, y, env);
		color = Color.blue;
		Random r = new Random();

		int direction = r.nextInt(8);
		super.dir = Direction.values()[direction] ;
	}


	public void setDir(Direction dir){
		this.dir = dir;
	}

	@Override
	public void doIt() {
		Point nexpos = Direction.getPoint(dir);
		//System.out.println("outofb     "+ !env.isOutOfBounds(posX + nexpos.x, posY + nexpos.y));
		//System.out.println("free       "+ env.isFree(posX + nexpos.x, posY + nexpos.y));
		if (!env.isOutOfBounds(posX + nexpos.x, posY + nexpos.y) && env.isFree(posX + nexpos.x, posY + nexpos.y)) {
			//System.out.println(dir);
			updatePosition(posX + nexpos.x, posY + nexpos.y);
		}
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
