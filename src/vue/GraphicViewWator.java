package vue;

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

	public GraphicViewWator(SMAWator sma, String name) {
		super();
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


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
