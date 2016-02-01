package vue;

import java.util.Observable;

import Core.SMAWator;

public class GraphicViewWator extends View{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public GraphicViewWator(SMAWator sma, String name) {
		super(sma, name);

	}


	@Override
	public void update(Observable o, Object arg) {
		paint(getGraphics());
	}

}
