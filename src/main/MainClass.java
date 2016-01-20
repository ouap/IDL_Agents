package main;

import model.SMA;
import vue.GraphicView;
import vue.View;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		// int nbAgents,int nbTours, int vitesse, int height, int length, int agentSize, boolean showGrid, boolean equit
		SMA simulation = new SMA(1500, 200, 100, 200, 200, 20, false, true);
		View v = new GraphicView(simulation, "Chambre d'evolution");
		simulation.run();

	}
}
