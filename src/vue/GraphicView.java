package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.SMA;

public class GraphicView extends View implements Observer {

	private JButton[][] cells;

	private JPanel jp;

	private SMA sma;

	private static final long serialVersionUID = 1L;

	public GraphicView(SMA sma) {
		this.sma = sma;
		sma.addObserver(this);

		JFrame f = new JFrame("Chambre d'evolution");
		jp = new JPanel();
		initGrid();

		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		jp.add(this);
		System.out.println("Added this to jp");
		f.add(jp);
		System.out.println("Added jp to f");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("setDefaultCloseOperation");
		f.setVisible(true);
	}

	public void initGrid() {

		cells = new JButton[sma.env.grille.length][sma.env.grille[0].length];

		setLayout(new GridLayout(cells.length, cells[0].length));

		for (int i = 0; i < sma.env.grille.length; i++) {
			for (int j = 0; j < sma.env.grille[0].length; j++) {
				final int x = i;
				final int y = j;
				cells[i][j] = new JButton();

				cells[i][j].setPreferredSize(new Dimension(sma.env.grille.length, sma.env.grille[0].length));

				Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
				cells[i][j].setBorder(border);

				this.add(cells[i][j]);
			}
		}
		actualiseGrid();
	}

	public void actualiseGrid() {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				if (sma.env.grille[i][j].isEmpty()) {
					cells[i][j].setBackground(Color.WHITE);
				} else {
					cells[i][j].setBackground(Color.BLACK);
				}
				System.out.println("Cell " + i + " " + j);
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		actualiseGrid();
		repaint();
		System.out.println("Update !");
	}

}
