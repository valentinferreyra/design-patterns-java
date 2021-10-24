package ar.edu.unq.po2.tpTestDoubles;

import java.util.Iterator;
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

	public List<Carta> ganador() {
		
		if(this.getPokerStatus().verificar(cartas1) == (this.getPokerStatus().verificar(cartas2))) {
			return this.verificarGanadorPorNumeros();
		} else if ((this.getPokerStatus().verificar(cartas1) == "Poquer")
		        || (this.getPokerStatus().verificar(cartas1) == "Trio")) {
			return cartas1;
		} else if ((this.getPokerStatus().verificar(cartas1) == "Color") 
				&& (this.getPokerStatus().verificar(cartas2) != "Nada")) {
			return cartas2;
		}
		
		
	}

	private List<Carta> verificarGanadorPorNumeros() {
		
		Integer ganadoresCarta1 = 0;
		Integer ganadoresCarta2 = 0;
		
		for(i=0; i < this.getCartas1().size(); i++) {
			if(this.getCartas1().indexOf(i).elValorEsMayorQue(this.getCartas2().indexOf(i))) {
				ganadoresCarta1 ++;
			} else if (this.getCartas2().indexOf(i).elValorEsMayorQue(this.getCartas1().indexOf(i))) {
				ganadoresCarta2 ++;
			}
		}
		
		if (ganadoresCarta1 > ganadoresCarta2) {
			return cartas1;
		} else {
			return cartas2;
		}
		
		
	}
}
