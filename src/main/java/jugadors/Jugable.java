package jugadors;

import arbitre.Jugada;

/**
 * Interficie per als jugadors, implementa un metode que sera cridat per la
 * classe arbitre per resoldre jugades
 * 
 * @author Francesc Garcia, Francisco Gienini
 * 
 */
public interface Jugable {
	/**
	 * Funcio per a resoldre jugades, els valors d'entrada son les
	 * caracteristiques del tauler al torn actual
	 * 
	 * @param x
	 *            Pila de pedres 1
	 * @param y
	 *            Pila de pedres 2
	 * @param z
	 *            Pila de pedres 3
	 * @param torn
	 *            Torn actual
	 * @return un objecte Jugada indicant el numero de pedres a moure (n) i les
	 *         piles objectiu (x, y i z)
	 */
	public Jugada fesJugada(int x, int y, int z, int torn);

}
