package ar.edu.unq.po2.tpTestDoubles;

import java.util.List;
import java.util.stream.Collectors;

public class PokerStatusConCarta {
	
	List<Carta> cartas;
	
	public String verificar(List<Carta> cartas) {
		
		Carta carta1 = cartas.get(0);
		Carta carta2 = cartas.get(1);
		Carta carta3 = cartas.get(2);
		
		List<Carta> igualesAC1 =  cartas.stream().
				                  filter(carta -> this.esMismoNumero(carta1, carta)).
				                  collect(Collectors.toList());
		
		List<Carta> igualesAC2 =  cartas.stream(). 
			                      filter(carta -> this.esMismoNumero(carta2, carta)). 
			                      collect(Collectors.toList());
		
		List<Carta> igualesAC3 =  cartas.stream(). 
                                  filter(carta -> this.esMismoNumero(carta3, carta)). 
                                  collect(Collectors.toList());

		if (this.hayPoquer(igualesAC1, igualesAC2)) {
			return "Poquer";
		} else if (this.hayTrio(igualesAC1, igualesAC2, igualesAC3)) {
			return "Trio";
		} else if (this.sonMismoColor(cartas)) {
			return "Color";
		} else {
			return "Nada";
		}
	}
	
	private boolean esMismoNumero(Carta carta1, Carta carta2) {
		return carta1.getNumero() == carta2.getNumero();
	}
	
	private boolean sonMismoColor(List<Carta> cartas) {
		Carta primerCarta = cartas.get(0);
		
		List<Carta> mismoColorQueC1 = cartas.stream(). 
				                      filter(carta -> this.esMismoColor(carta, primerCarta.getColor())). 
				                      collect(Collectors.toList());
		
		return mismoColorQueC1.size() == 5;
	}
	
	private boolean esMismoColor(Carta carta, ColorDeCarta color) {
		return carta.getColor() == color;
	}

	private boolean hayPoquer(List<Carta> igualesAC1, List<Carta> igualesAC2) {
		return (igualesAC1.size() == 4) || (igualesAC2.size() == 4);
	}

	private boolean hayTrio(List<Carta> igualesAC1, List<Carta> igualesAC2, List<Carta> igualesAC3) {
		return (igualesAC1.size() == 3) || (igualesAC2.size() == 3) || (igualesAC3.size() == 3);
	}
}
