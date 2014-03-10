package test;

import arbitre.Tauler;

public class TaulerMock extends Tauler {

	
	public TaulerMock(int maxim) {
		super();
		x=maxim;
		y=maxim;
		z=maxim;
	}

	public void setX(int i){
		x=i;
	}
	public void setY(int i){
		y=i;
	}
	public void setZ(int i){
		z=i;
	}
}
