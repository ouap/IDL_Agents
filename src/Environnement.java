public class Environnement {
	Agent [][] grille;

	public Environnement(int x, int y){
		grille = new Agent[x][y];
		init();
	}


	public void init(){
		for (int i = 0 ; i< grille.length ; i++) {
			for (int j = 0; j < grille[0].length; j++) {
				grille[i][j] = null;
			}
		}
	}



}
