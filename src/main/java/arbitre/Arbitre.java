package arbitre;

import java.util.Calendar;

import jugadors.Garcia;
import jugadors.Gienini;
import jugadors.Jugable;

public class Arbitre {

	protected Jugable primer;
	protected Jugable segon;
	protected int torn;
	protected Tauler tauler;

	private static final int TEMPS_MAXIM = 6000;

	public Arbitre() {
		super();
	}

	public Arbitre(Tauler tauler) {
		super();
		this.primer = null;
		this.segon = null;
		this.torn = 0;
		this.tauler = tauler;
	}

	/**
	 * Funcio per portar els torns, decideix a quin jugador cridar a partir del
	 * torn actual
	 * 
	 * @return el Jugador al que li toca
	 */
	public Jugable tornSeguent() {
		Jugable retorn = null;
		if (torn % 2 == 0) {
			retorn = segon;
		} else {
			retorn = primer;
		}
		return retorn;
	}

	/**
	 * Decideix aleatoriament qui juga primer en el partit
	 * 
	 * @param j1
	 * @param j2
	 * @return el Primer decidit de manera aleatoria
	 */
	public void decideixPrimer(Jugable j1, Jugable j2) {
		long seed = Calendar.getInstance().getTimeInMillis();
		if (seed % 2 == 0) {
			primer = j1;
			segon = j2;
		} else {
			primer = j2;
			segon = j1;
		}
	}

	public Partida resolPartit(Jugable j1, Jugable j2) {
		// Inicialitzar valors
		Partida retorn = null;
		int resultatJugada = 0;
		decideixPrimer(j1, j2);

		System.out.println("Tauler creat x:" + tauler.getX() + " y:"
				+ tauler.getY() + " z:" + tauler.getZ());
		// Realitzar les jugades sobre el tauler
		String seguimentPartida = "";
		Jugada seguimentJugada = null;
		FilJugada filJugada = null;
		int tempsBase = 0;
		int tempsActual = 0;
		do {
			torn++;
			filJugada = new FilJugada(tauler.getX(), tauler.getY(),
					tauler.getZ(), torn, tornSeguent());
			tempsBase = (int) Calendar.getInstance().getTimeInMillis()
					+ TEMPS_MAXIM;
			tempsActual = (int) Calendar.getInstance().getTimeInMillis();
			filJugada.start();
			while (tempsBase > tempsActual) {
				tempsActual = (int) Calendar.getInstance().getTimeInMillis();
				if (!filJugada.isAlive()) {
					tempsActual = tempsBase;
				}
			}
			if (filJugada.isAlive()) {
				filJugada.interrupt();
				seguimentJugada = new Jugada(0, true, true, true);
			} else {
				seguimentJugada = filJugada.getRetorn();
			}
			System.out.println("Jugada feta: jugador="
					+ tornSeguent().getClass() + " n= "
					+ seguimentJugada.getN() + " x=" + seguimentJugada.isX()
					+ " y=" + seguimentJugada.isY() + " z="
					+ seguimentJugada.isZ());
			resultatJugada = tauler.executaJugada(seguimentJugada);
			System.out.println("Jugada n" + torn + " estat del tauler: "
					+ tauler.x + "-" + tauler.y + "-" + tauler.z);
		} while (resultatJugada == Tauler.CORRECTE);
		// Comprobar el resultat
		if (resultatJugada == Tauler.FI) {
			System.out.println("Victoria! ha guanyat: "
					+ tornSeguent().getClass() + "estat del tauler: "
					+ tauler.x + "-" + tauler.y + "-" + tauler.z);
			// acavar oer a que torni partida
			if (torn % 2 == 0) {
				retorn = new Partida(segon, primer, false);
			} else {
				retorn = new Partida(primer, segon, false);
			}

		} else {
			System.out.println("Derrota" + tornSeguent().getClass()
					+ " ha estat descalificat!, estat del tauler: " + tauler.x
					+ "-" + tauler.y + "-" + tauler.z);
			if (torn % 2 == 0) {
				retorn = new Partida(primer, segon, true);
			} else {
				retorn = new Partida(segon, primer, true);
			}
		}

		return retorn;
	}

}
