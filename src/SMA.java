import java.util.Random;

public class SMA {
	Environnement env;


	public void init(int nbBille){
		Random r = new Random();
		for (int i = 0 ; i < nbBille ; i++) {
			int x, y;
			do {
				y = r.nextInt(env.grille.length);
				x = r.nextInt(env.grille[0].length);
			} while (env.grille[x][y] != null);

			env.grille[x][y] = new Bille(env, x, y);
		}
	}

	public void run(int nbTour, int vitesse){

	}
}
