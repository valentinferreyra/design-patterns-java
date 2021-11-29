package ar.edu.unq.po2.tpTestDoubles;

import java.util.List;

public class Jugada {

	List<Carta> cartas1;
	List<Carta> cartas2;
	PokerStatusConCarta miPokerStatus;
	
	public Jugada(List<Carta> cartas1, List<Carta> cartas2) {
		this.setCartas1(cartas1);
		this.setCartas2(cartas2);
	}

	public List<Carta> getCartas1() {
		return cartas1;
	}
	
	public PokerStatusConCarta getPokerStatus() {
		return miPokerStatus;
	}

	public void setCartas1(List<Carta> cartas1) {
		this.cartas1 = cartas1;
	}

	public List<Carta> getCartas2() {
		return cartas2;
	}

	public void setCartas2(List<Carta> cartas2) {
		this.cartas2 = cartas2;
	}

	public List<Carta> ganadorDeLaMano() {
		String jugada1 = this.getPokerStatus().verificar(cartas1);
		String jugada2 = this.getPokerStatus().verificar(cartas2);
		
		if(jugada1.equals(jugada2)) {
			return this.ganadorDeLaJugadaPorNumero();
		} else {
			return this.ganadorDeLaJugadaPorValor();
		}
	}

	private List<Carta> ganadorDeLaJugadaPorValor() {
		int valores1 = this.sumarTodosLosValores(cartas1);
		int valores2 = this.sumarTodosLosValores(cartas2);
		
		if(valores1 >= valores2) {
			return cartas1;
		} else {
			return cartas2;
		}
	}

	private int sumarTodosLosValores(List<Carta> cartas) {
		return cartas.stream().
			   mapToInt(carta -> carta.getNumero().ordinal())
			   .sum();
	}

	private List<Carta> ganadorDeLaJugadaPorNumero() {
		String jugada1 = this.getPokerStatus().verificar(cartas1);
		String jugada2 = this.getPokerStatus().verificar(cartas2);
		
		if(((jugada1 == "Poker") && !(jugada2 == "Poker") || 
		  ((jugada1 == "Color") && (jugada2 == "Trio"))  ||
		  ((jugada1 == "Trio")  && (jugada2 == "Nada")))) {
			return cartas1;
		} else {
			return cartas2;
		}
	}
	
	
}
