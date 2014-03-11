package campionat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


import java.util.List;
import java.util.Map.Entry;

import arbitre.Arbitre;
import arbitre.Instanciador;
import arbitre.Partida;
import arbitre.Tauler;
import jugadors.*;

public class Campionat {
	
	private ArrayList<Participant> participants;
	private int rondes;
	
	
	public Campionat(List<Jugable> jugadors,int rondes) {
		participants= Instanciador.getJugables(); 
		participants = new ArrayList<Participant>();
		participants.add(new Participant(new Garcia()));
		participants.add(new Participant(new playerDos()));
		participants.add(new Participant(new Gienini()));
		participants.add(new Participant(new playerU()));
		this.rondes=rondes;
	
	}
	
	public Campionat(int rondes) {
		participants= Instanciador.getJugables(); 
//		participants = new ArrayList<Participant>();
//		participants.add(new Participant(new Garcia()));
//		participants.add(new Participant(new playerDos()));
//		participants.add(new Participant(new Gienini()));
//		participants.add(new Participant(new playerU()));
		this.rondes=rondes;
	
	}
	
	public void fesCampionat() {
		for (int r=0;r<rondes;r++) {
			for (int i=0; i<participants.size();i++)	
			{
				Participant p1 = participants.get(i);
				
				for (int j=i+1;j<participants.size();j++) {
	
					Participant p2 = participants.get(j);
						
					Enfrontament(p1,p2);
				}
			}
		}
		
		Collections.sort(participants);
		System.out.println(this);
		
	}
	@Override
	public String toString() {
		String s;
		s = "\n\n      RESULTATS DEL CAMPIONAT        \n";
		for (int i=0; i<participants.size(); i++)
		{
			Jugable jugador = participants.get(i).getJugador();
			int victories = participants.get(i).getVictories();
			int derrotes = participants.get(i).getDerrotes();
			int descal = participants.get(i).getDescalif();
			int punts = participants.get(i).getPuntuacio();
			
			s+=("#" + i + "  " + jugador.getClass()
					+ " VICTORIES:" + victories 
					+ " DERROTES:" + derrotes 
					+ " DESCALIFICACIONS " + descal + " TOTAL PUNTS " + punts + "\n");
		}
		
		return s;
	}
	public void Enfrontament(Participant p1, Participant p2)
	{
		Arbitre arbitre = new Arbitre(new Tauler(100));
		
		Jugable j1 = p1.getJugador();
		Jugable j2 = p2.getJugador();
		
		System.out.println("*********************************");
		System.out.println(j1.getClass() + " VS " + j2.getClass());
		System.out.println("*********************************");
		
		//Enfrontament 
		Partida partida = arbitre.resolPartit(j1,j2);
		System.out.println(partida);
		//gestio del resultat
		if (j1.getClass() == partida.getGuanyador().getClass())
		{
			p1.addVictoria();
			
			if (partida.isDescalificat())
			{
				p2.addDescalif();
			}
			else{
				p2.addDerrotes();
			}
		}
		else
		{
			p2.addVictoria();
			
			if (partida.isDescalificat())
			{
				p1.addDescalif();
			}
			else{
				p1.addDerrotes();
			}
		}
	}
	public static void main(String[] args) {
		int rondes = 3;
		Campionat c = new Campionat(rondes);
		c.fesCampionat();
	}
		
}
