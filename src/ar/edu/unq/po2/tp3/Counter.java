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
		 * Retorna la cantidad de n�meros pares del array
		 */
		
		int ocurrences = 0; // inicializo contador
		
		for (int number : getNumbers()) { //recorrido por cada elemento de la lista
			if ((number%2) == 0) {
				ocurrences += 1; 			   // si el n�mero es par, se incrementa el contador
			}
		}
		return ocurrences;
	}
	
	public int getOddOcurrences() {
		/**
		 * Retorna la cantidad de n�meros impares del array
		 */
		int ocurrences = 0; // inicializo contador
		
		for (int number : getNumbers()) { //recorrido por cada elemento de la lista
			if ((number%2) != 0) {
				ocurrences += 1;			   // si el n�mero es impar, se incrementa el contador
			}
		}
		return ocurrences;
	}
	
	public int countMultiplesOf(int aNumber) {
		/**
		 * Retorna la cantidad de n�meros m�ltiplos del n�mero indicado en aNumber
		 */
		int ocurrences = 0; // inicializo contador
		
		for (int number : getNumbers()) { //recorrido por cada elemento de la lista
			if ((number%aNumber) == 0) {
				ocurrences += 1; 			   // si el n�mero es m�ltiplo, se incrementa el contador
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
		 * Dado dos int x,y retorna el n�mero m�s alto entre 0 y 1000 que sea m�ltiplo de esos dos n�meros
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
