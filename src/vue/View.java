package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import Core.SMA;
import agents.Agent;

public abstract class View extends JFrame implements Observer {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	SMA sma;
	Panel c;

	public View(SMA sma, String name){
		this.sma = sma;
		this.sma.addObserver(this);

		setTitle(name);
		setSize(new Dimension(sma.getEnv().getWidth() * sma.getAgentSize(), sma.getEnv().getHeight()*sma.getAgentSize() + 22));
		//setPreferredSize(new Dimension(sma.getEnv().getWidth() * sma.getAgentSize(), sma.getEnv().getHeight()*sma.getAgentSize()));
		setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void paintAgents(Graphics graphics) {
		int agentSize = sma.getAgentSize();

		for (Agent a : sma.getAgents()) {
			graphics.setColor(a.getColor());
			graphics.fillRect(a.getX()*agentSize, (a.getY()*agentSize) + 22 , agentSize, agentSize);
		}
	}

	private void paintGrid(Graphics graphics) {
		int width = sma.getEnv().getWidth();
		int height = sma.getEnv().getHeight();
		int agentSize = sma.getAgentSize();

		if (sma.showGrid()) {
			graphics.setColor(Color.BLACK);

			for (int x = 0; x < width; x++) {
				graphics.drawLine(x*agentSize,0 + 22, x * agentSize, (height * agentSize) + 22);
			}

			for (int y = 0; y < height; y++) {
				graphics.drawLine(0, (y * agentSize) + 22, width * agentSize, (y * agentSize) + 22);
			}

		}
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);

		if (sma.showGrid()) {
			paintGrid(graphics);
		}

		paintAgents(graphics);

	}

	@Override
	public void update(Observable o, Object arg) {
		revalidate();
		paint(getGraphics());
	}


}
