package campionat;

import java.util.ArrayList;
import java.util.HashMap;






import arbitre.Arbitre;
import jugadors.*;

public class Campionat {
	
	private HashMap<Jugable,Resultat> lliga;
	
	public Campionat() {
		lliga = new HashMap<Jugable, Resultat>();
		//creem jugadors a sacox
		lliga.put(new Garcia(), new Resultat());
		lliga.put(new playerU(), new Resultat());
		lliga.put(new playerDos(), new Resultat());
		lliga.put(new Gienini(), new Resultat());	
		
		Arbitre arbitre = new Arbitre();
	}
	
	public static void main(String[] args) {
		
	}
	
	
}
