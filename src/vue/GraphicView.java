package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import agents.Agent;
import model.SMA;

public class GraphicView extends View implements Observer {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private SMA sma;
	private JPanel p;
	private JButton[][] grid;

	public GraphicView(SMA sma, String name) {
		super();
		this.sma = sma;
		sma.addObserver(this);

		this.initGrid();
		
		this.p = new JPanel();
		p.setLayout(new BoxLayout(this.p, BoxLayout.Y_AXIS));
		
		setSize(new Dimension(sma.getEnv().getWidth() * sma.getAgentSize(), sma.getEnv().getHeight()*sma.getAgentSize()+22));

		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public void initGrid(){

		int size = sma.getEnv().getGrid().length;
		this.grid = new JButton[size][size];

		this.setLayout(new GridLayout(this.grid.length, this.grid.length));

		for(int i = 0 ; i < size; i++){
			for( int j = 0; j < size; j++){
				final int x = i;
				final int y = j;
				grid[i][j] = new JButton();

				this.grid[i][j].setPreferredSize(new Dimension(sma.getAgentSize(), sma.getAgentSize()));

				grid[i][j].addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.out.println(" pos : " + sma.getEnv().getCell(x, y).getAgent().getX() + " " + sma.getEnv().getCell(x, y).getAgent().getY() + "; dir : " + sma.getEnv().getCell(x, y).getAgent().getDir());
					}

				});
				
				if (!sma.showGrid())	{
					Border border = BorderFactory.createEmptyBorder();
					grid[i][j].setBorder(border);
				}
				this.add(grid[i][j]);
			}

		}

		this.actualiseGrid();
	}

	public void actualiseGrid(){
		for(int i = 0 ; i < this.grid.length; i++){
			for(int j = 0; j < this.grid[i].length; j++){
				if(sma.getEnv().getGrid()[i][j].isEmpty()){
					grid[i][j].setBackground(Color.WHITE);
				}else{
					grid[i][j].setBackground(Color.BLACK);
				}



			}

		}
	}

	@Override
	public void update(Observable o, Object arg) {
		actualiseGrid();
		repaint();
	}

}
