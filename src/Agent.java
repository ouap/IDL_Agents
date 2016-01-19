
public abstract class Agent {
	int posx;
	int posy;
	Environnement env;
	Direction dir;

	abstract void doIt();

	public int getX(){
		return posx;
	}
	public int getY(){
		return posy;
	}

}
