package Core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;

import agents.Agent;
import agents.Fish;
import agents.Shark;

public class SMAWator extends SMA {
	private int nbFish;
	private int nbShark;
	private int starveShark = 5;
	private int sharkBreedTime = 2;
	private int fishBreedTime = 5;

	public SMAWator(int nbTours, int vitesse, int height, int width, int agentSize, boolean showGrid, boolean equit, boolean toric, int nbFish, int nbShark) {
		super((nbFish + nbShark), nbTours, vitesse, height, width, agentSize, showGrid, equit, toric);
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
			Fish newFish = new Fish(env, x, y);

			env.getCell(x, y).setAgent(newFish);
			agents.add(env.getCell(x, y).getAgent());
			env.fishList.add(newFish);
		}

		for (int i = 0; i < nbShark; i++) {
			int x, y;
			do {
				y = r.nextInt(env.getWidth());
				x = r.nextInt(env.getHeight());
			} while (!env.getCell(x, y).isEmpty());

			Shark newShark = new Shark(env, x, y, starveShark);

			env.getCell(x, y).setAgent(newShark);
			agents.add(newShark);
			env.sharkList.add(newShark);
		}

	}

	public void run() throws InterruptedException, IOException {

		for (int i = 0; i < nbTours; i++) {
			if (equit) {
				Collections.shuffle(agents);
			}

			List<Agent> dup = new ArrayList<Agent>();
			dup.addAll(agents);
			for (Agent a : dup) {
				a.doIt();
			}
			nbFish = env.fishList.size();
			nbShark = env.sharkList.size();
			FileUtils.writeStringToFile(new File("result.data"), i + " " + nbFish + " " + nbShark + "\n", true);
			// System.out.println("Tour " + i);
			setChanged();
			notifyObservers();
			Thread.sleep(vitesse);
		}
	}

}
