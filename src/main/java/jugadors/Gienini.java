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
		if (x==0){
			return getMinimisim(y, z);
		}
		if (y==0){
			return getMinimisim(z, x);
		}
		if (z==0){
			return getMinimisim(y, x);
		}
		if (x<y&&x<z) return x;
		if (y<z&& y<x) return y;
		return z;
	}

	public int getMinimisim(int i1, int i2){
		if (i1==0) return i2;
		if (i2==0) return i1;
		if (i1<i2) return i1;
		else return i2;
	}
	@Override
	public int hashCode() {
		return "Gienini".hashCode();
	}
	 
}
