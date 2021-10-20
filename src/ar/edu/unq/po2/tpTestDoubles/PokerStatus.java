package ar.edu.unq.po2.tpTestDoubles;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PokerStatus {

	/**
	 * @param carta1, carta2, carta3, carta4, carta5 son Strings que representan
	 *        distintos tipos de cartas
	 *        
	 * @return un booleano indicando si existe Poker
	 */
	public String verificar(String carta1, String carta2, String carta3, String carta4, String carta5) {
		
		List<String> cartas = Arrays.asList(carta1, carta2, carta3, carta4, carta5);
		
		List<String> igualesAC1 = cartas.stream().
				                  filter(carta -> this.esMismoNumero(carta1, carta)).
				                  collect(Collectors.toList());
		
		List<String> igualesAC2 = cartas.stream(). 
			                      filter(carta -> this.esMismoNumero(carta2, carta)). 
			                      collect(Collectors.toList());
		
		List<String> igualesAC3 = cartas.stream(). 
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

	private boolean hayPoquer(List<String> igualesAC1, List<String> igualesAC2) {
		return (igualesAC1.size() == 4) || (igualesAC2.size() == 4);
	}

	private boolean hayTrio(List<String> igualesAC1, List<String> igualesAC2, List<String> igualesAC3) {
		return (igualesAC1.size() == 3) || (igualesAC2.size() == 3) || (igualesAC3.size() == 3);
	}

	/**
	 * @param cartas: es un List<String> que representa cartas de una mano de Poquer
	 * @return un booleano que indica si todas las cartas son del mismo color
	 */
	private boolean sonMismoColor(List<String> cartas) {
		
		String primerCarta = cartas.get(0);
		
		List<String> mismoColorQueC1 = cartas.stream(). 
				                       filter(carta -> this.esMismoColor(carta, primerCarta.charAt(primerCarta.length() -1))). 
				                       collect(Collectors.toList());
		
		return mismoColorQueC1.size() == 5; 
	}

	/**
	 * @param carta: String que representan cartas de Poquer
	 * @param color: Character que representa el color de una carta de Poquer
	 * @return un booleano indicando si las dos cartas son del mismo color
	 */
	private boolean esMismoColor(String carta, Character color) {
		Character colorC = carta.charAt(carta.length() -1);
		return colorC == color;
	}

	/**
	 * @param carta1, carta2 son Strings que representan distintos tipos de cartas
	 * @return un booleano indicando si las dos cartas dadas tienen el mismo número
	 */
	private boolean esMismoNumero(String carta1, String carta2) {
		Character numeroC1 = carta1.charAt(0);
		Character numeroC2 = carta2.charAt(0);
		
		return (carta1.length() == carta2.length()) && (numeroC1 == numeroC2);
	}

}
