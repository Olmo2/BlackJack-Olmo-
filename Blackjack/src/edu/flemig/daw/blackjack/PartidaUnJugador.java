package edu.flemig.daw.blackjack;

import edu.fleming.daw.naipes.*;


public class PartidaUnJugador {
			/*Mazo BJ*/
		private MazoBJ deck = new MazoBJ();
		/*Mazo vacío*/
		private Mazo descarte = new Mazo();
		/*Mano "Crupier"*/
		private Mano crupier = new Mano();
		/**/
		private Mano jugador = new Mano();
		/**/
		private boolean finalizada = false;
		
		
		public  boolean repartir() {
			if(!finalizada)
				System.out.println("No puedo repartir, La partida no Ha finalizado");
			else {
				if (crupier.numeroNaipes()>0)
					descarte.add(crupier);
				if (jugador.numeroNaipes()>0)
					descarte.add(jugador);
				if(deck.numeroNaipes() < 52)
					deck.add(descarte);
				jugador.add(deck.getNaipe());
				jugador.add(deck.getNaipe());
				finalizada = jugador.getValor() ==21;
				crupier.add(deck.getNaipe());
				crupier.add(deck.getNaipe());
				
				mostrarMano();
				
				
			}
			return finalizada;
		}
		
		
		
		public boolean pedir() {
			if(!finalizada)
				System.out.println("El jugador no puede pedir, La partida ha finalizado");
			else {
				jugador.add(deck.getNaipe());
				if(deck.numeroNaipes() < 52)
					deck.add(descarte);
				finalizada = jugador.getValor() >=21;
				mostrarMano();
				
			}
			return finalizada;
		}
			public void plantarse() {
				finalizada = true;
				while(crupier.getValor() < 17)
					crupier.add(deck.getNaipe());
				mostrarMano();
		}
		
		public void mostrarMano() {
			System.out.print("Jugador: ");
			mostrarMano(jugador, false);
			for(Naipe n : jugador.get())
				System.out.print(n);
			System.out.println();
			mostrarMano(crupier, true);
			if(!finalizada) {
				
			}
				
		}
		
		private void mostrarMano(Mano m, boolean ocultar) {
			Naipe [] naipes = m.get();
			for(int i = 0; i<naipes.length; i++)
				if(ocultar && i ==0)
					System.out.print("***");
				else
					System.out.print(naipes[i]);
		}
}
