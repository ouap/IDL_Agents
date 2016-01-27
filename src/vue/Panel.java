package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Core.SMA;
import agents.Agent;

public class Panel extends JPanel{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private SMA sma;
	private boolean showGrid;
	private int agentSize;
	private int width;
	private int height;

	public Panel(SMA sma) {
		width = sma.getEnv().getWidth();
		height = sma.getEnv().getHeight();
		showGrid = sma.showGrid();
		agentSize = sma.getAgentSize();
		this.sma = sma;

		this.setSize(width * agentSize, height * agentSize);

	}

	@Override
	public void paintComponent(Graphics g) {
		if (showGrid) {
			paintGrid(g);
		}

		paintAgents(g);
	}


	private void paintAgents(Graphics graphics) {

		List<Agent> agents = new ArrayList<Agent>(sma.getAgents());

		for(Agent agent : agents) {
			graphics.setColor(agent.getColor());
			graphics.fillRect(agent.getX() * agentSize, (agent.getY() * agentSize), agentSize, agentSize);
		}

	}

	private void paintGrid(Graphics graphics) {
		graphics.setColor(Color.BLACK);

		for (int i = 0; i <= height; i++) {
			graphics.drawLine(0, (i * agentSize), width * agentSize, (i * agentSize));
		}

		for (int i = 0; i <= width; i++) {
			graphics.drawLine((i * agentSize), 0, i * agentSize, (height * agentSize));
		}
	}


}
