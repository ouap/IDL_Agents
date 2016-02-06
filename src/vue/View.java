package vue;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import Core.SMA;

public abstract class View extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;

	Panel c;

	public View(SMA sma, String name) {
		// TODO by Ouamar Sais "Interface programmable sans arg. commande" for 10/02/2016
		c = new Panel(sma);
		c.sma.addObserver(this);
		setTitle(name);
		setContentPane(c);
		setSize(new Dimension(sma.getEnv().getWidth() * sma.getAgentSize(), sma.getEnv().getHeight() * sma.getAgentSize() + 22));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		revalidate();
		paint(getGraphics());
	}

}
