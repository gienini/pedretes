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
	public int compareTo(Object o) {
		
		if (o instanceof Participant)
		{
		Participant res = (Participant) o;
		return this.puntuacio > res.getPuntuacio() ? 1 : this.puntuacio< res.getPuntuacio() ? -1 : 0;
		}
		else
		{
			return -1;
		}
		
	}
	@Override 
	public int hashCode() {
		int prime = 7;
		int hash;
		hash = derrotes*prime;
		hash += victories*prime;
		hash += descalif*prime;
		hash += jugador.getClass().hashCode();
		return hash;	
	}
	

	public boolean equals(Object obj) {
        if (obj == null)
            return false;
        else if (!(obj instanceof Participant))
            return false;
        else {
        	Participant r = (Participant) obj;
        	return this.getPuntuacio() == r.getPuntuacio();
        }
	}
}
