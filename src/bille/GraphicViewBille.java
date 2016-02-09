package bille;

import java.awt.Color;

import View.View;

public class GraphicViewBille extends View {

	private static final long serialVersionUID = 1L;

	public GraphicViewBille(SMABille sma, String name) {
		super(sma, name);
		setBackground(Color.white);
	}

}
