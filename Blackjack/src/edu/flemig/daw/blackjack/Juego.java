package edu.flemig.daw.blackjack;

import java.util.Scanner;
import edu.flemig.daw.blackjack.*;
import edu.fleming.daw.naipes.*;


public class Juego {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("¿Empezar partida? SI(1)/NO(0)");
		int respuesta = teclado.nextInt();
		if(respuesta == 1) {
			 
			Mazo m1 = new Mazo(6);
			MazoBJ m = new MazoBJ();
			m.add(m);
			m.getNaipe();
			PartidaUnJugador p = new PartidaUnJugador();
			Mano mj1 = new Mano();
			do {
			p.mostrarMano();
//			mj1.getValor();
			System.out.println("¿Quieres carta? SI(1)/NO(0)");
			respuesta = teclado.nextInt();
			if(respuesta == 1) {
				p.pedir();
			}else {
				System.out.println("Te plantas");
				p.plantarse();
			}
			}while(respuesta!=1);
		}else {
			System.out.println("Okay");
		}

	}

}
