package jugadors;

import arbitre.Jugada;

public class Bolli implements Jugable {


	public Jugada fesJugada(int x, int y, int z, int torn) {

		if (x == y && x == z) {
			return new Jugada(x, true, true, true);
		}
		if (x == y && z == 0) {
			return new Jugada(x, true, true, false);
		}
		if (x == z && y == 0) {
			return new Jugada(x, true, false, true);
		}
		if (y == z && x == 0) {
			return new Jugada(y, false, true, true);
		}
		if (y == 0 && x == 0) {
			return new Jugada(z, false, false, true);
		}
		if (z == 0 && x == 0) {
			return new Jugada(y, false, true, false);
		}
		if (z == 0 && y == 0) {
			return new Jugada(x, true, false, false);
		}

		if ((y == 1 && z > 0 && x > 0) || (z == 1 && x > 0 && y > 0)
				|| (x == 1 && z > 0 && y > 0)) {
			return new Jugada(1, true, true, true);
		}

		if (x == 0 && y == 1 && z > 3) {
			return new Jugada(z - 3, false, false, true);
		} else {
			if (x == 0 && y == 1 && z <= 3) {
				return new Jugada(1, false, false, true);
			}
		}

		if (y == 0 && x == 1 && z > 3) {
			return new Jugada(z - 3, false, false, true);
		} else {
			if (x == 0 && y == 1 && z <= 3) {
				return new Jugada(1, false, false, true);
			}
		}

		if (z == 0 && x == 1 && y > 3) {
			return new Jugada(y - 3, false, true, false);
		} else {
			if (x == 0 && y == 1 && y <= 3) {
				return new Jugada(1, false, true, false);
			}
		}

		if (x == 0 && z == 1 && y > 3) {
			return new Jugada(y - 3, false, true, false);
		} else {
			if (x == 0 && y == 1 && y <= 3) {
				return new Jugada(1, false, true, false);
			}
		}

		if (y == 0 && z == 1 && x > 3) {
			return new Jugada(x - 3, true, false, false);
		} else {
			if (x == 0 && y == 1 && x <= 3) {
				return new Jugada(1, true, false, false);
			}
		}

		if (z == 0 && y == 1 && x > 3) {
			return new Jugada(x - 3, true, false, false);
		} else {
			if (x == 0 && y == 1 && x <= 3) {
				return new Jugada(1, true, false, false);
			}
		}

		if (x == 0 && y > z) {
			return new Jugada(1, false, true, true);
		}
		if (y == 0 && x > z) {
			return new Jugada(1, true, false, true);
		}
		if (z == 0 && y > x) {
			return new Jugada(1, true, true, false);
		}
		if (x == 0 && z > y) {
			return new Jugada(1, false, true, true);
		}
		if (y == 0 && z > x) {
			return new Jugada(1, true, false, true);
		}
		if (z == 0 && x > y) {
			return new Jugada(1, true, true, false);
		}
		return new Jugada(1,true,true,true);

	}
}
