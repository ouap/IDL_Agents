package grille;

import java.util.ArrayList;
import java.util.List;

import agents.Agent;
import agents.Fish;
import agents.Shark;

public class EnvironnementWator extends Environnement{

	public List<Fish> fishList;
	public List<Shark> sharkList;

	public EnvironnementWator(int x, int y, List<Agent> agents, boolean toric) {
		super(x, y,agents, toric);
		fishList = new ArrayList<Fish>();
		sharkList = new ArrayList<Shark>();

	}

	@Override
	public boolean isFree(int posX, int posY){

		return getCell(posX, posY).getAgent() == null;
	}

	public void removeAgent(Agent agent) {
		agents.remove(agent);
		if (agent.type().equals("fish")) {
			fishList.remove(agent);
		}else {
			sharkList.remove(agent);
		}
	}


	public void addAgent(Agent newAgent) {
		agents.add(newAgent);
		if (newAgent.type().equals("fish")) {
			fishList.add((Fish) newAgent);
		}else {
			sharkList.add((Shark)newAgent);
		}
	}



}