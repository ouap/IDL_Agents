package main;

import model.SMA;
import vue.GraphicView;
import vue.View;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		SMA simulation = new SMA(100, 1000, 50, 100, 100, true);
		View v = new GraphicView(simulation);
		v.setVisible(true);
		simulation.run();

	}
}
