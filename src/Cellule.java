
public class Cellule {
	int x;
	int y;
	Agent agent;

	public Cellule(int x, int y){
		this.x =x;
		this.y=y;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Agent getAgent() {
		return agent;
	}

	public boolean isEmpty(){
		return agent == null ? true : false;
	}

}
