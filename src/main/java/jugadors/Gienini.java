package jugadors;
import arbitre.Jugada;


public class Gienini implements Jugable {
	
	@Override
	public Jugada fesJugada(int x, int y, int z, int torn) {
		Jugada retorn= new Jugada(1,true,true,true); 
		
		if (x==y&&x==z) {
			retorn = new Jugada(x, true, true, true);
		}
		else {
			if (x==0)retorn.setX(false);
			if (y==0)retorn.setY(false);
			if (z==0)retorn.setZ(false);
			retorn.setN(getMinim(x, y, z));
		}
		
		
		return retorn;
	}
	
	public int getMinim(int x, int y, int z) {
		if (x<y&&x<z && x>0) return x;
		else if (y<z&& y>0) return y;
		else return z;
	}
	
 
}
