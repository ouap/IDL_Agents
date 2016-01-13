
public abstract class Agent {
	int posx;
	int posy;
	Environnement env;

	abstract void doIt();
	public int getX(){
		return posx;
	}
	public int getY(){
		return posy;
	}

}
