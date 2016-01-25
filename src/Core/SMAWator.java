package Core;

public class SMAWator extends SMA{
	private int sharkLife;
	private int nbFish;
	private int nbShark;
	public SMAWator(int nbTours, int vitesse, int height, int width, int agentSize, boolean showGrid, boolean equit,  int sharkLife, int nbFish, int nbShark) {
		super((nbFish + nbShark), nbTours,  vitesse,  height,  width,  agentSize,  showGrid,  equit);
		this.sharkLife = sharkLife;
		this.nbFish = nbFish;
		this.nbShark = nbShark;
		init();
	}

	@Override
	public void init() {
		for (int i = 0; i < nbFish; i++) {
			// TODO Create Fishes
		}

		for (int i = 0; i < nbShark; i++) {
			// TODO Create Skarks
		}

	}

	@Override
	public void run() throws InterruptedException {
		// TODO Auto-generated method stub

	}

}
