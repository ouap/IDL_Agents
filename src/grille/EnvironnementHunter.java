package grille;

import java.util.List;

import agents.Agent;

public class EnvironnementHunter extends Environnement {
	private int[][] dijkstraTab;

	public EnvironnementHunter(int x, int y, List<Agent> agents, boolean toric) {
		super(x, y, agents, toric);
		dijkstraTab = new int[x][y];
	}

	public void initDijkstra(int x, int y) {
		for (int i = 0; i < getWidth(); i++) {
			for (int j = 0; j < getHeight(); j++) {
				dijkstraTab[i][j] = -1;
			}
		}
		dijkstraTab[x][y] = 0;
	}

	public void doDijkstra(int x, int y, int inception) {
		int value = inception;

		dijkstraTab[x][y] = value;
		if (!isOutOfBounds(x, y - 1) && (dijkstraTab[x][y - 1] == -1 || dijkstraTab[x][y - 1] > value + 1) && dijkstraTab[x][y - 1] != 0
				&& super.isFree(x, y - 1)) {
			doDijkstra(x, y - 1, value + 1);
		}

		if (!isOutOfBounds(x + 1, y) && (dijkstraTab[x + 1][y] == -1 || dijkstraTab[x + 1][y] > value + 1) && dijkstraTab[x + 1][y] != 0
				&& super.isFree(x + 1, y)) {
			doDijkstra(x + 1, y, value + 1);
		}
		if (!isOutOfBounds(x, y + 1) && (dijkstraTab[x][y + 1] == -1 || dijkstraTab[x][y + 1] > value + 1) && dijkstraTab[x][y + 1] != 0
				&& super.isFree(x, y + 1)) {
			doDijkstra(x, y + 1, value + 1);
		}
		if (!isOutOfBounds(x - 1, y) && (dijkstraTab[x - 1][y] == -1 || dijkstraTab[x - 1][y] > value + 1) && dijkstraTab[x - 1][y] != 0
				&& super.isFree(x - 1, y)) {
			doDijkstra(x - 1, y, value + 1);
		}

	}

	public int[][] getDijkstraTab() {
		return dijkstraTab;
	}
}
