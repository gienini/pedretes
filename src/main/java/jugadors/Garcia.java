package jugadors;

import arbitre.Jugada;

public class Garcia implements Jugable {

	@Override
	public Jugada fesJugada(int x, int y, int z, int torn) {

		if (torn == 1) {
			if (x > y && x > z) {
				return new Jugada(x, true, false, false);
			}
			if (y > x && y > z) {
				return new Jugada(y, false, true, false);
			}
			if (z > x && z > y) {
				return new Jugada(z, false, false, true);
			} else {
				return new Jugada(1, true, true, true);
			}

		} else {
			if (x > 0 && y > 0 && z > 0) {
				return new Jugada(1, true, true, true);
			}
			if (x == 0 && y > 0 && z > 0) {
				return new Jugada(1, false, true, true);
			}
			if (y == 0 && x > 0 && z > 0) {
				return new Jugada(1, true, false, true);
			}
			if (z == 0 && x > 0 && y > 0) {
				return new Jugada(1, true, true, false);
			}
			if (x == 0 && y == 0) {
				return new Jugada(z, false, false, true);
			}
			if (x == 0 && z == 0) {
				return new Jugada(y, false, true, false);
			}
			if (y == 0 && z == 0) {
				return new Jugada(x, true, false, false);
			} else {
				return new Jugada(1, true, true, true);
			}

		}
	}

}