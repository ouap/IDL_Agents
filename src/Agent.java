
public abstract class Agent {
	int posX;
	int posY;
	Environnement env;
	Direction dir;

	abstract void doIt();

	public int getX(){
		return posX;
	}
	public int getY(){
		return posY;
	}

}
