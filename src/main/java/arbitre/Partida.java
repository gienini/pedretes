package arbitre;

import jugadors.Jugable;


public class Partida {
	private Jugable guanyador;
	private Jugable perdedor;
	private boolean descalificat;
	
	public Partida(Jugable guanyador, Jugable perdedor, boolean descalificat)
	{
		this.guanyador=guanyador;
		this.perdedor=perdedor;
		this.descalificat=descalificat;
	}

	public Jugable getGuanyador() {
		return guanyador;
	}

	public void setGuanyador(Jugable guanyador) {
		this.guanyador = guanyador;
	}

	public Jugable getPerdedor() {
		return perdedor;
	}

	public void setPerdedor(Jugable perdedor) {
		this.perdedor = perdedor;
	}

	public boolean isDescalificat() {
		return descalificat;
	}

	public void setDescalificat(boolean descalificat) {
		this.descalificat = descalificat;
	}
	@Override
	public String toString() {
		String s= " \n *** Guanya el jugador " + guanyador.getClass() + " *** \n";
		if (descalificat)
		{
			s+="    Per jugada ilegal de " + perdedor.getClass();
		}
		return s;
	}

}
