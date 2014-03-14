package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import arbitre.Jugada;
import arbitre.Tauler;

public class testTauler {
	
	private Tauler tauler;
	@Before
	public void init()
	{
		tauler=new TaulerMock(10);
	}
	
	@Test
	public void test() {
		tauler=new TaulerMock(10);
		assertEquals("prova jugada correcte",Tauler.CORRECTE,tauler.executaJugada(new Jugada(4, true, true, true)));
	}
	
	@Test
	public void testSubstraccioCorrecte() {
		tauler=new TaulerMock(10);
		assertEquals("prova jugada correcte",Tauler.CORRECTE,tauler.executaJugada(new Jugada(4, true, true, true)));
		int x=tauler.getX();
		int y=tauler.getY();
		int z=tauler.getZ();
		boolean resultat = (x==6 && y==6 && z==6);
		assertEquals("prova substraccio correcte",true,resultat);
	}
	@Test
	public void testSubstraccioIncorrecte() {
		tauler=new TaulerMock(2);
		assertEquals("prova jugada incorrecte",Tauler.INCORRECTE,tauler.executaJugada(new Jugada(4, true, true, true)));
		assertEquals("prova jugada incorrecte",Tauler.INCORRECTE,tauler.executaJugada(new Jugada(-1, true, true, true)));
		assertEquals("prova jugada incorrecte",Tauler.INCORRECTE,tauler.executaJugada(new Jugada(4, false, false, false)));
		
		
	}
	public void testSubstraccioFI(){
		tauler=new TaulerMock(2);
		assertEquals("prova jugada FI",Tauler.FI,tauler.executaJugada(new Jugada(2, true, true, true)));
	}
	@Test
	public void creaTaulerDeVeritat(){
		tauler=new Tauler(200);
		int aux=tauler.getX();
		assertTrue("Prova constructor valors aleatoris", ( tauler instanceof Tauler));
		assertTrue("Prova constructor valors aleatoris getters", ( (tauler.getX()<=200)));
		tauler=new Tauler(200);
		assertFalse("La X es_: "+tauler.getX(), tauler.getX()!=aux);
	}


}
