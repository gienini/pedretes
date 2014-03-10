package campionat;

public class Resultat implements Comparable {
	//total victories 
	private int victories;
	//total derrotes
	private int derrotes;
	//total descalificacions
	private int descalif;
	// puntuació que obeeix a la formula victories - derrotes - descalificacions*2
	private int puntuacio;
	
	public Resultat() {
		victories=0;
		derrotes=0;
		descalif=0;
	}
	public int getVictories() {
		return victories;
	}
	public void setVictories(int victories) {
		this.victories = victories;
	}
	public int getDerrotes() {
		return derrotes;
	}
	public void setDerrotes(int derrotes) {
		this.derrotes = derrotes;
	}
	public int getDescalif() {
		return descalif;
	}
	public void setDescalif(int descalif) {
		this.descalif = descalif;
	}
	public int getPuntuacio() {
		return this.puntuacio = (victories - derrotes) - (descalif*2);
	}
	public int compareTo(Object o) {
		
		if (o instanceof Resultat)
		{
		Resultat res = (Resultat) o;
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
		return hash;	
	}
	

	public boolean equals(Object obj) {
        if (obj == null)
            return false;
        else if (!(obj instanceof Resultat))
            return false;
        else {
        	Resultat r = (Resultat) obj;
        	return this.getPuntuacio() == r.getPuntuacio();
        }
	}
}
