package vue;

import java.awt.Dimension;
import java.util.Observable;

import javax.swing.JFrame;

import model.SMA;

public class GraphicView extends View {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public GraphicView(SMA sma) {
		super.sma = sma;
		sma.addObserver(this);

		System.out.println("On lance la fenêtre");
		JFrame f = new JFrame("Chambre d'evolution");
		f.setPreferredSize(new Dimension(sma.env.grille.length, sma.env.grille[0].length));

		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();

	}

}
