package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.WindowConstants;

import model.SMA;

public class GraphicView extends View implements Observer {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private SMA sma;

	public GraphicView(SMA sma, String name) {
		super();
		this.sma = sma;
		sma.addObserver(this);

		System.out.println(sma.showGrid());
		System.out.println(sma.getEnv().getHeight());
		System.out.println(sma.getAgentSize());


		setSize(new Dimension(sma.getEnv().getWidth() * sma.getAgentSize(), sma.getEnv().getHeight()*sma.getAgentSize()+22));
		//setPreferredSize(new Dimension(sma.getEnv().getWidth() * sma.getAgentSize(), sma.getEnv().getHeight()*sma.getAgentSize()));

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		paint(getGraphics());

	}

	private void paintAgents(Graphics graphics) {
		int agentSize = sma.getAgentSize();


		for (int x = 0; x < sma.getEnv().getWidth(); x++) {
			for (int y = 0; y < sma.getEnv().getHeight(); y++) {
				if (!sma.getEnv().getCell(x, y).isEmpty()) {
					graphics.fillRect(x*agentSize, (y*agentSize) + 22 , agentSize, agentSize);
				}
			}
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
		getContentPane().removeAll();
		revalidate();
		repaint();
	}

}
