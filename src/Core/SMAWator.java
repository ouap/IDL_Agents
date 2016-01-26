package Core;

import java.util.Random;

import agents.Fish;
import agents.Shark;

public class SMAWator extends SMA{
	private int sharkLife;
	private int nbFish;
	private int nbShark;
	private int starveShark = 8;
	private int sharkBreedTime = 10;
	private int fishBreedTime = 10;

	public SMAWator(int nbTours, int vitesse, int height, int width, int agentSize, boolean showGrid, boolean equit,  int starveShark, int nbFish, int nbShark) {
		super((nbFish + nbShark), nbTours,  vitesse,  height,  width,  agentSize,  showGrid,  equit);
		this.starveShark = starveShark;
		this.nbFish = nbFish;
		this.nbShark = nbShark;
		init();
		Fish.setBreedTime(fishBreedTime);
		Shark.setBreedTime(sharkBreedTime);
	}

	@Override
	public void init() {
		Random r = new Random();

		for (int i = 0; i < nbFish; i++) {
			int x, y;
			do {
				y = r.nextInt(env.getWidth());
				x = r.nextInt(env.getHeight());
				System.out.println("y : " + y + " - x : " + x);
			} while (!env.getCell(x, y).isEmpty());

			env.getCell(x, y).setAgent(new Fish(env, x, y));
			agents.add(env.getCell(x, y).getAgent());
		}

		for (int i = 0; i < nbShark; i++) {
			int x, y;
			do {
				y = r.nextInt(env.getWidth());
				x = r.nextInt(env.getHeight());
				System.out.println("y : " + y + " - x : " + x);
			} while (!env.getCell(x, y).isEmpty());

			env.getCell(x, y).setAgent(new Shark(env, x, y, starveShark));
			agents.add(env.getCell(x, y).getAgent());
		}

	}


}
