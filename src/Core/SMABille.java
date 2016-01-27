package Core;

import java.util.Collections;
import java.util.Random;

import agents.Agent;
import agents.Bille;

public class SMABille extends SMA {


	public SMABille(int nbAgents,int nbTours, int vitesse, int height, int length, int agentSize, boolean showGrid, boolean equit) {
		super( nbAgents, nbTours,  vitesse,  height,  length,  agentSize,  showGrid,  equit);
		System.out.println(""+height+ "  "+length);
		super.nbAgents = nbAgents;
		super.vitesse = vitesse;
		super.nbTours=nbTours;
		super.equit = equit;
		super.showGrid = showGrid;
		super.toric = false;
		this.agentSize = agentSize;
		init();
	}

	@Override
	public void init() {
		Random r = new Random();

		for (int i = 0; i < nbAgents; i++) {
			int x, y;
			do {
				y = r.nextInt(env.getWidth());
				x = r.nextInt(env.getHeight());
				System.out.println("y : " + y + " - x : " + x);
			} while (!env.getCell(x, y).isEmpty());

			env.getCell(x, y).setAgent(new Bille(env, x, y));
			agents.add(env.getCell(x, y).getAgent());
		}
	}

	public void run() throws InterruptedException {

		for (int i = 0; i < nbTours; i++) {
			if (equit) {
				Collections.shuffle(agents);
			}


			for (Agent a : agents) {
				a.doIt();
			}

			//System.out.println("Tour " + i);
			setChanged();
			notifyObservers();
			Thread.sleep(vitesse);
		}
	}




}