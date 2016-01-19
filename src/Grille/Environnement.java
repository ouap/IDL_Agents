package Grille;
public class Environnement {
	Cellule [][] grille;
	boolean thorique;

	public Environnement(int x, int y){
		grille = new Cellule[x][y];
		init();
	}


	public void init(){
		for (int i = 0 ; i< grille.length ; i++) {
			for (int j = 0; j < grille[0].length; j++) {
				grille[i][j] = new Cellule(i, j);
			}
		}
	}


	public Cellule getCell(int x, int y){
		return grille[x][y];
	}

	public int getHeight(){
		return grille[0].length;
	}

	public int getWidth(){
		return grille.length;
	}



}
