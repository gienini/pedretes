package arbitre;

import jugadors.Jugable;

public class FilJugada extends Thread {
	private int x;
	private int y;
	private int z;
	private int torn;
	private Jugable jugador;
	private Jugada retorn = new Jugada(0, true, true, true);

	public Jugada getRetorn() {
		return retorn;
	}

	public void setRetorn(Jugada retorn) {
		this.retorn = retorn;
	}

	public FilJugada(int x, int y, int z, int torn, Jugable jugador) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.torn = torn;
		this.jugador = jugador;
	}

	public void run() {

		retorn = jugador.fesJugada(x, y, z, torn);
	}

	@Override
	public void interrupt() {

		super.interrupt();
		retorn = new Jugada(0, true, true, true);
		System.out.println("El jugador " + jugador.getClass()
				+ " ha tardat massa a pensar");
	}
}
