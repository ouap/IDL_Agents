package wator;

import java.awt.Color;
import java.util.Observable;

import View.View;

public class GraphicViewWator extends View{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public GraphicViewWator(SMAWator sma, String name) {
		super(sma, name);
		setBackground(Color.white);

	}


	@Override
	public void update(Observable o, Object arg) {
		paint(getGraphics());
	}

}
