package test;

import static org.junit.Assert.*;
import jugadors.playerDos;
import jugadors.playerU;

import org.junit.Test;


public class testArbitre {
	private ArbitreMock arbitre = new ArbitreMock(new TaulerMock(100));
	private playerDos j1= new playerDos();
	private playerU j2= new playerU();
	@Test
	public void testPartidaNormal() {
		arbitre.resolPartit(j1, j2);
	}
	@Test
	public void testTornSeguent(){
		arbitre.setPrimer(j1);
		arbitre.setSegon(j2);
		arbitre.setTorn(1);
	assertEquals("S'espera al j1 al primer torn", j1.getClass(), arbitre.tornSeguent().getClass());
	arbitre.setTorn(2);
	assertEquals("S'espera al j2 al segon torn", j2.getClass(), arbitre.tornSeguent().getClass());	
	}

}
