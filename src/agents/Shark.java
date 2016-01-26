package agents;

import grille.Environnement;

public class Shark extends Agent{
	private static int breedTime;
	private int breed;
	private boolean alive;
	private int starveShark;

	public Shark(Environnement env, int x, int y, int starveShark) {
		super(x, y, env);
		super.color = color.blue;
		this.starveShark = starveShark;
		breed = 0;
		alive = true;
	}


	@Override
	public void doIt() {
		// TODO Auto-generated method stub

	}


	public boolean isAlive(){
		return alive;
	}

	@Override
	public String type(){
		return "shark";
	}

	public static void setBreedTime(int time){
		breedTime = time;
	}
}
