package Agents;

import Grille.Environnement;
import utils.Direction;

public class Bille extends Agent {



	public Bille(Environnement env, int posx, int posy) {
		super.env = env;
		super.posX = posx;
		super.posY = posy;
	}

	@Override
	void doIt() {

		switch (dir) {
		case NORD:
			//Si on a pas atteint le mur
			if (posY - 1 < env.getHeight()) {
				if (env.getCell(posX, posY - 1).isEmpty()) {
					updatePosition(posX, posY - 1);
				}
			}else{
				dir=Direction.SUD;
				updatePosition(posX, posY + 1);
			}
			break;
		case NORD_EST:
			//Si on a pas atteint le mur
			if (posX + 1 < env.getWidth() && posY - 1 >= 0) {
				//Si la case ou l'on va est vide
				if (env.getCell(posX + 1, posY -1).isEmpty()) {
					updatePosition(posX + 1, posY - 1);
				}else{
					dir=Direction.NORD_OUEST;
					updatePosition(posX - 1, posY - 1);
				}
			}else{
				//cas mur vertical
				if (posX +1 < env.getWidth()) {
					//Si on est sur un coin
					if (isCorner(posX, posY)) {
						updatePosition(posX-1, posY+1);
						dir = Direction.SUD_OUEST;
					}else{
						updatePosition(posX -1 , posY - 1 );
						dir = Direction.NORD_OUEST;
					}
				}else if(posY - 1 >= 0) { //Cas mur horizontal
					//Si on est sur un coin
					if (isCorner(posX, posY)) {
						updatePosition(posX-1, posY+1);
						dir = Direction.SUD_OUEST;
					}else{
						updatePosition(posX +1 , posY + 1 );
						dir = Direction.SUD_EST;
					}
				}
			}
			break;
		case NORD_OUEST:
			//Si on a pas atteint le mur
			if (posX - 1 >= 0 && posY - 1 >= 0) {
				//Si la case ou l'on va est vide
				if (env.getCell(posX - 1, posY -1).isEmpty()) {
					updatePosition(posX - 1, posY - 1);
				}else{
					dir=Direction.SUD_EST;
					updatePosition(posX + 1, posY + 1);
				}
			}else{
				//cas mur vertical
				if (posX - 1 < 0) {
					//Si on est sur un coin
					if (isCorner(posX, posY)) {
						updatePosition(posX + 1, posY+1);
						dir = Direction.SUD_EST;
					}else{
						updatePosition(posX + 1 , posY - 1 );
						dir = Direction.NORD_EST;
					}
				}else if(posY - 1 <= 0) { //Cas mur horizontal
					//Si on est sur un coin
					if (isCorner(posX, posY)) {
						updatePosition(posX+1, posY+1);
						dir = Direction.SUD_EST;
					}else{
						updatePosition(posX - 1 , posY + 1);
						dir = Direction.SUD_OUEST;
					}
				}
			}

			break;
		case EST:
			//Si on a pas atteint le mur
			if (posX + 1 < env.getHeight()) {
				if (env.getCell(posX + 1, posY).isEmpty()) {
					updatePosition(posX + 1, posY);
				}
			}else{
				dir=Direction.OUEST;
				updatePosition(posX - 1, posY);
			}
			break;
		case OUEST:
			//Si on a pas atteint le mur
			if (posX - 1 < env.getHeight()) {
				if (env.getCell(posX - 1, posY).isEmpty()) {
					updatePosition(posX - 1, posY);
				}
			}else{
				dir=Direction.EST;
				updatePosition(posX + 1, posY);
			}
			break;
		case SUD_EST:
			//Si on a pas atteint le mur
			if (posX + 1 > env.getWidth() && posY + 1 > env.getHeight()) {
				//Si la case ou l'on va est vide
				if (env.getCell(posX + 1, posY +1).isEmpty()) {
					updatePosition(posX + 1, posY + 1);
				}else{
					dir=Direction.SUD_OUEST;
					updatePosition(posX - 1, posY + 1);
				}
			}else{
				//cas mur vertical
				if (posX + 1 > env.getWidth()) {
					//Si on est sur un coin
					if (isCorner(posX, posY)) {
						updatePosition(posX - 1, posY-1);
						dir = Direction.NORD_OUEST;
					}else{
						updatePosition(posX - 1 , posY + 1 );
						dir = Direction.SUD_OUEST;
					}
				}else if(posY + 1 > env.getHeight()) { //Cas mur horizontal
					//Si on est sur un coin
					if (isCorner(posX, posY)) {
						updatePosition(posX - 1, posY-1);
						dir = Direction.NORD_OUEST;
					}else{
						updatePosition(posX + 1 , posY - 1);
						dir = Direction.NORD_EST;
					}
				}
			}

			break;
		case SUD_OUEST:
			//Si on a pas atteint le mur
			if (posX - 1 >= 0 && posY + 1 < env.getHeight()) {
				//Si la case ou l'on va est vide
				if (env.getCell(posX - 1, posY + 1).isEmpty()) {
					updatePosition(posX - 1, posY + 1);
				}else{
					dir=Direction.NORD_OUEST;
					updatePosition(posX - 1, posY - 1);
				}
			}else{
				//cas mur vertical
				if (posX - 1 < 0) {
					//Si on est sur un coin
					if (isCorner(posX, posY)) {
						updatePosition(posX + 1, posY-1);
						dir = Direction.NORD_EST;
					}else{
						updatePosition(posX + 1 , posY + 1 );
						dir = Direction.SUD_EST;
					}
				}else if(posY + 1 > env.getHeight()) { //Cas mur horizontal
					//Si on est sur un coin
					if (isCorner(posX, posY)) {
						updatePosition(posX + 1, posY-1);
						dir = Direction.NORD_EST;
					}else{
						updatePosition(posX - 1 , posY - 1);
						dir = Direction.NORD_OUEST;
					}
				}
			}

			break;
		case SUD :
			//Si on a pas atteint le mur
			if (posY + 1 < env.getHeight()) {
				if (env.getCell(posX, posY+1).isEmpty()) {
					updatePosition(posX, posY +1);
				}
			}else{
				dir=Direction.NORD;
				updatePosition(posX, posY-1);
			}
			break;
		}
	}



	public boolean isCorner(int posX, int posY){
		if(posX - 1 < 0 && posY -1 <0) {
			return true;
		}
		if (posX + 1 > env.getWidth() && posY -1 < 0) {
			return true;
		}
		if(posX + 1 > env.getWidth() && posY + 1 > env.getHeight()) {
			return true;
		}
		if(posX - 1 < 0 && posY + 1 > env.getHeight()) {
			return true;
		}

		return false;
	}

	public void updatePosition(int newX, int newY){
		posX=newX;
		posY=newY;
	}


}