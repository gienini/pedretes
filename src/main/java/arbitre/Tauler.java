package arbitre;

public class Tauler {

	protected int x;
	protected int y;
	protected int z;

	public static final int CORRECTE = 1;
	public static final int INCORRECTE = 2;
	public static final int FI = 3;

	public Tauler() {
		super();
	}

	public Tauler(int maxim) {
		x = (int) (Math.random() * maxim);
		y = (int) (Math.random() * maxim);
		z = (int) (Math.random() * maxim);
		
	}

	public int executaJugada(Jugada jugada) {
		int n = jugada.getN();
		boolean jugaX = jugada.isX();
		boolean jugaY = jugada.isY();
		boolean jugaZ = jugada.isZ();
		int retorn;
		try {
			// Comprova que treiem com a mínim una pedra
			// i que no intentem treuren més de les que hi han.
			if (((jugaX && n > x) || (jugaY && n > y) || (jugaZ && n > z))
					|| (!jugaX && !jugaY && !jugaZ) || n < 1) {
				retorn = INCORRECTE;
			}

			else {
				if (jugaX) {
					x -= n;
				}
				if (jugaY) {
					y -= n;
				}
				if (jugaZ) {
					z -= n;
				}
				if (esFi()) {
					retorn = FI;
				} else {
					retorn = CORRECTE;
				}
			}
			return retorn;
		} catch (Exception e) {
			return INCORRECTE;
		}
	}

	private boolean esFi() {
		boolean fi = false;
		if (x == 0 && y == 0 && z == 0) {
			fi = true;
		}
		return fi;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

}
