package test;

import jugadors.Jugable;
import arbitre.Arbitre;
import arbitre.Partida;
import arbitre.Tauler;

public class ArbitreMock extends Arbitre {

	private TaulerMock tauler;
	
	public void setPrimer (Jugable j){
		primer=j;
	}
	public void setSegon (Jugable j){
		segon=j;
	}

	public void setTorn(int i){
		torn=i;
	}
	
	public ArbitreMock(TaulerMock tauler) {
		super();
		this.primer = null;
		this.segon = null;
		this.torn = 0;
		this.tauler = tauler;
	}

//	public Partida resolPartit(Jugable j1, Jugable j2) {
//		// Inicialitzar valors
//		Jugable retorn = null;
//		int resultatJugada = 0;
//
//		decideixPrimer(j1, j2);
//		if (primer.getClass() == j1.getClass()) {
//			segon = j2;
//		} else {
//			segon = j1;
//		}
//
//		// Realitzar les jugades sobre el tauler
//		do {
//			torn++;
//			resultatJugada = tauler.executaJugada(tornSeguent().fesJugada(
//					tauler.getX(), tauler.getY(), tauler.getZ(), torn));
//			System.out
//					.println("Jugada n" + torn + " estat del tauler: "
//							+ tauler.getX() + "-" + tauler.getY() + "-"
//							+ tauler.getZ());
//		} while (resultatJugada == Tauler.CORRECTE && torn < 200);
//
//		// Comprobar el resultat
//		if (resultatJugada == Tauler.FI) {
//			System.out.println("Victoria! ha guanyat: " + tornSeguent().getClass()
//					+ "estat del tauler: " + tauler.getX() + "-"
//					+ tauler.getY() + "-" + tauler.getZ());
//			retorn = tornSeguent();
//		} else {
//			System.out.println("Derrota" + tornSeguent().getClass()
//					+ " ha estat descalificat!, estat del tauler: "
//					+ tauler.getX() + "-" + tauler.getY() + "-" + tauler.getZ()
//					+ "DEBUG torn=" + torn + " resultatJugada="
//					+ resultatJugada);
//			torn++;
//			retorn = tornSeguent();
//		}
//
//		return retorn;
//	}

}
