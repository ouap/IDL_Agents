package View;

import hunter.EnvironnementHunter;
import hunter.SMAPredator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Core.Agent;
import Core.SMA;
import utils.Direction;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	SMA sma;
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
		setFocusable(true);

		if (sma instanceof SMAPredator) {
			setListener();
		}

	}

	public void setListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					((SMAPredator) sma).getYou().setDir(Direction.NORD);
					break;
				case KeyEvent.VK_DOWN:
					((SMAPredator) sma).getYou().setDir(Direction.SUD);
					break;
				case KeyEvent.VK_LEFT:
					((SMAPredator) sma).getYou().setDir(Direction.OUEST);
					break;
				case KeyEvent.VK_RIGHT:
					((SMAPredator) sma).getYou().setDir(Direction.EST);
					break;
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
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

		for (Agent agent : agents) {
			graphics.setColor(agent.getColor());
			graphics.fillRect(agent.getX() * agentSize, (agent.getY() * agentSize), agentSize, agentSize);
		}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				graphics.setColor(Color.black);

				if (sma instanceof SMAPredator) {
					if (((SMAPredator) sma).showNumbers)
						graphics.drawString("" + ((EnvironnementHunter) sma.getEnv()).getDijkstraTab()[i][j], i * agentSize, (j * agentSize) + 12);
				}

			}

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
