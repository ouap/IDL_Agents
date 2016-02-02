package grille;

import java.util.List;

import agents.Agent;

public class EnvironnementHunter extends Environnement{
	private int[][] dijkstraTab;

	public EnvironnementHunter(int x, int y, List<Agent> agents, boolean toric) {
		super(x, y, agents, toric);
		dijkstraTab = new int[x][y];
		initDijkstra();
		// TODO Auto-generated constructor stub
	}


	public void initDijkstra(){
		for (int i = 0; i < getWidth(); i++) {
			for (int j = 0; j < getHeight(); j++) {
				dijkstraTab[i][j] = 0;
			}
		}
	}

	public void doDijkstra(int x, int y, int inception)	{
		int value = inception;
		if (isOutOfBounds(x, y) || (dijkstraTab[x][y] != 0 && dijkstraTab[x][y] < value)) {
			return;
		} else	{
			//System.out.println("Value : " + dijkstraTab[x][y]);

			setDijkstraValue(x, y, value);
			doDijkstra(x, y-1, value+1);
			doDijkstra(x+1, y, value+1);
			doDijkstra(x, y+1, value+1);
			doDijkstra(x-1, y, value+1);
		}
	}

	public void setDijkstraValue(int x, int y, int value)	{
		dijkstraTab[x][y] = value;
	}


	public int[][] getDijkstraTab() {
		return dijkstraTab;
	}
}
