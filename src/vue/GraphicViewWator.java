package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;

import javax.swing.JFrame;

import Core.SMAWator;

public class GraphicViewWator extends View{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private SMAWator sma;
	Panel c;

	public GraphicViewWator(SMAWator sma, String name) {
		super();
		this.sma = sma;
		this.sma.addObserver(this);
		setTitle(name);

		c = new Panel(sma);
		setLayout(new BorderLayout());
		this.add(c, BorderLayout.CENTER);
		setSize(new Dimension(sma.getEnv().getWidth() * sma.getAgentSize() +2, sma.getEnv().getHeight()*sma.getAgentSize() + 20));
		//setPreferredSize(new Dimension(sma.getEnv().getWidth() * sma.getAgentSize(), sma.getEnv().getHeight()*sma.getAgentSize()));
		setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}


	@Override
	public void update(Observable o, Object arg) {
		paint(getGraphics());
	}

}
