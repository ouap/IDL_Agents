package vue;

import java.awt.Color;
import java.util.Observable;

import Core.SMAPredator;

public class GraphicViewPredator extends View {

	private static final long serialVersionUID = 1L;

	public GraphicViewPredator(SMAPredator sma, String name) {
		super(sma, name);
		setBackground(Color.white);
	}

	@Override
	public void update(Observable o, Object arg) {
		paint(getGraphics());
	}

}
