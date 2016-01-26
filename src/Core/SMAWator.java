package Core;

import java.util.Random;

import agents.Fish;
import agents.Shark;

public class SMAWator extends SMA{
	private int sharkLife;
	private int nbFish;
	private int nbShark;
	private int starveShark = 7;
	private int sharkBreedTime = 12;
	private int fishBreedTime = 8;

	public SMAWator(int nbTours, int vitesse, int height, int width, int agentSize, boolean showGrid, boolean equit, int nbFish, int nbShark) {
		super((nbFish + nbShark), nbTours,  vitesse,  height,  width,  agentSize,  showGrid,  equit);
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
			} while (!env.getCell(x, y).isEmpty());

			env.getCell(x, y).setAgent(new Fish(env, x, y));
			agents.add(env.getCell(x, y).getAgent());
		}

		for (int i = 0; i < nbShark; i++) {
			int x, y;
			do {
				y = r.nextInt(env.getWidth());
				x = r.nextInt(env.getHeight());
			} while (!env.getCell(x, y).isEmpty());

			env.getCell(x, y).setAgent(new Shark(env, x, y, starveShark));
			agents.add(env.getCell(x, y).getAgent());
		}

	}


}
