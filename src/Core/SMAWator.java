package Core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import agents.Agent;
import agents.Fish;
import agents.Shark;

public class SMAWator extends SMA{
	private int sharkLife;
	private int nbFish;
	private int nbShark;
	private int starveShark = 5;
	private int sharkBreedTime = 2;
	private int fishBreedTime = 5;

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

	public void run() throws InterruptedException {

		for (int i = 0; i < nbTours; i++) {
			if (equit) {
				Collections.shuffle(agents);
			}

			List<Agent> dup = new ArrayList<Agent>(agents);

			for (Agent a : dup) {
				a.doIt();
			}

			//System.out.println("Tour " + i);
			setChanged();
			notifyObservers();
			Thread.sleep(vitesse);
		}
	}


}
