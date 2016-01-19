package Vue;

import java.util.Observable;

import model.SMA;

public class GraphicView extends View{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public  GraphicView(SMA sma) {
		super.sma = sma;
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
