package jugadors;

import arbitre.Jugada;

public class playerDos implements Jugable {

	@Override
	public Jugada fesJugada(int x, int y, int z, int torn) {
		return new Jugada(1,true,true,true);
	}
	@Override
	public int hashCode() {
		return "playerdos".hashCode();
	}
}
