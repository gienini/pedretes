package jugadors;

import arbitre.Jugada;

public class ACaralt implements Jugable {

	@Override
	public Jugada fesJugada(int x, int y, int z, int torn) {
		Jugada j = new Jugada(1, true, true, true);
		if (x == y && y == z) {
			j.setN(x);
		} else {
			if (x == 0) {
				j.setX(false);
			}
			if (y == 0) {
				j.setY(false);
			}
			if (z == 0) {
				j.setZ(false);
			}

			//Dos pilots estan a 0 = buidem tot 
			if (!j.isX() && !j.isY()){
				j.setN(z);
			}
			else if (!j.isY() && !j.isZ()){
				j.setN(x);
			}
			else if (!j.isX() && !j.isZ()){
				j.setN(y);
			}
			else {
			if (x > 0 && y > 0 && z > 0) {
				j.setN(getMinim(x, y, z));
			} else {
				if (x == 0) {
					if (y < z) {
						j.setN(esNegatiu(y - 1));
					} else {
						j.setN(esNegatiu(z - 1));
					}
				} else if (y == 0) {
					if (x < z) {
						j.setN(esNegatiu(x - 1));
					} else {
						j.setN(esNegatiu(z - 1));
					}
				} else  {
					if (x < y) {
						j.setN(esNegatiu(x - 1));
					} else {
						j.setN(esNegatiu(y - 1));
					}
				}
			}
		 }

		}
		return j;
	}

	public int getMinim(int x, int y, int z) {
		if (x == 0) {
			return getMinimisim(y, z);
		}
		if (y == 0) {
			return getMinimisim(z, x);
		}
		if (z == 0) {
			return getMinimisim(y, x);
		}
		if (x < y && x < z)
			return x;
		if (y < z && y < x)
			return y;
		return z;
	}

	public int getMinimisim(int i1, int i2) {
		if (i1 == 0)
			return i2;
		if (i2 == 0)
			return i1;
		if (i1 < i2)
			return i1;
		else
			return i2;
	}
	
	public int esNegatiu(int num) {
		int res = 1;
		if (num > 0) {
			res = num;
		}
		return res;
	}
}
