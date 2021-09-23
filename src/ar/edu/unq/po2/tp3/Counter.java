package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

import java.util.List;

public class Counter {
	
	private List<Integer> numbers = new ArrayList<>();
	
	public Counter() {
		super();
	}
	
	private List<Integer> getNumbers() {
		return this.numbers;
	}
	
	public void addNumber(int number) { 
		getNumbers().add(number);
	}
	
	public int getEvenOcurrences() {
		/**
		 * Retorna la cantidad de números pares del array
		 */
		
		int ocurrences = 0; // inicializo contador
		
		for (int number : getNumbers()) { //recorrido por cada elemento de la lista
			if ((number%2) == 0) {
				ocurrences += 1; 			   // si el número es par, se incrementa el contador
			}
		}
		return ocurrences;
	}
	
	public int getOddOcurrences() {
		/**
		 * Retorna la cantidad de números impares del array
		 */
		int ocurrences = 0; // inicializo contador
		
		for (int number : getNumbers()) { //recorrido por cada elemento de la lista
			if ((number%2) != 0) {
				ocurrences += 1;			   // si el número es impar, se incrementa el contador
			}
		}
		return ocurrences;
	}
	
	public int countMultiplesOf(int aNumber) {
		/**
		 * Retorna la cantidad de números múltiplos del número indicado en aNumber
		 */
		int ocurrences = 0; // inicializo contador
		
		for (int number : getNumbers()) { //recorrido por cada elemento de la lista
			if ((number%aNumber) == 0) {
				ocurrences += 1; 			   // si el número es múltiplo, se incrementa el contador
			}
		}
		return ocurrences;
	}
	
//	public int numeroConMayorCantidadDePares(ArrayList<Integer> numeros) {
//		
//		
//	}
	
	public int numeroMasAltoMultiploDe(int x, int y) {
		/**
		 * Dado dos int x,y retorna el número más alto entre 0 y 1000 que sea múltiplo de esos dos números
		 */
		int numeroMultiplo = 1000;
		
		while(numeroMultiplo > 0) {
			if((numeroMultiplo%x == 0) && (numeroMultiplo%y == 0)) {
				return numeroMultiplo;
			}
			numeroMultiplo -= 1;
		}
		return -1;
	}
}
