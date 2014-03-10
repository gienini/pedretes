package arbitre;

public class Jugada {

	private boolean x;
	private boolean y;
	private boolean z;
	private int n;
	public Jugada(int n, boolean x, boolean y, boolean z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.n = n;
	}

	public boolean isX() {
		return x;
	}

	public void setX(boolean x) {
		this.x = x;
	}

	public boolean isY() {
		return y;
	}

	public void setY(boolean y) {
		this.y = y;
	}

	public boolean isZ() {
		return z;
	}

	public void setZ(boolean z) {
		this.z = z;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

}
