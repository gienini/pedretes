package campionat;

import jugadors.Jugable;

public class Participant implements Comparable {
	//total victories 
	private int victories;
	//total derrotes
	private int derrotes;
	//total descalificacions
	private int descalif;
	// puntuació que obeeix a la formula victories - derrotes - descalificacions*2
	private int puntuacio;
	// jugador
	private Jugable jugador;
	
	public Participant(Jugable jugador) {
		victories=0;
		derrotes=0;
		descalif=0;
		this.jugador=jugador;
	}
	public int getVictories() {
		return victories;
	}
	public void addVictoria() {
		this.victories++;
	}
	public int getDerrotes() {
		return derrotes;
	}
	public void addDerrotes() {
		this.derrotes++;
	}
	public int getDescalif() {
		return descalif;
	}
	public void addDescalif() {
		this.descalif++;
	}
	public int getPuntuacio() {
		return this.puntuacio = (victories - derrotes) - (descalif*2);
	}
	
	public Jugable getJugador() {
		return jugador;
	}
	public void setJugador(Jugable jugador) {
		this.jugador = jugador;
	}
	@Override
	public int compareTo(Object o) {
		
		if (o instanceof Participant)
		{
			Participant res = (Participant) o;
			if (this.getPuntuacio()<res.getPuntuacio())
			{
				
				return 1;
				
			}
			if(this.getPuntuacio()>res.getPuntuacio())
			{
				return -1;
			}
		}
		return 0;
	}
	@Override 
	public int hashCode() {
		int prime = 7;
		int hash;
		hash = derrotes*prime;
		hash += victories*prime;
		hash += descalif*prime;
		hash += jugador.hashCode();
		return hash;	
	}
}
