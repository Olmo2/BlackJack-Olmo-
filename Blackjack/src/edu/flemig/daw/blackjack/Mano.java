package edu.flemig.daw.blackjack;

import edu.fleming.daw.naipes.*;
import java.util.Iterator;

public class Mano extends Mazo {
	
		public int getValor() {
			int valor = 0;
			Iterator<Naipe> i = naipes.iterator();
			while (i.hasNext()) {
				Naipe n = i.next();
				valor += n.getRango();
				if(n.getId() == Id.AS && valor <12) 
					 valor +=10;
			}
			return valor;
		}

}
