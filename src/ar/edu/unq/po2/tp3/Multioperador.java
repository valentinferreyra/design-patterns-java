package ar.edu.unq.po2.tp3;

import java.util.List;

public class Multioperador {
	
	private List<Integer> arrayDeEnteros;
	
	public Multioperador(List<Integer> array) {
		/**
		 * param array = una lista de enteros 
		 */
		
		this.arrayDeEnteros = array;
	}
	
	private List<Integer> getArrayDeEnteros() {
		/**
		 * Retorna una lista de enteros
		 */
		
		return this.arrayDeEnteros;
	}
	
	public void addNumber(int n) {
		/**
		 * param n = número que será agregado al array
		 */
		
		getArrayDeEnteros().add(n);
	}
	
	public int sumarNumeros() {
		/**
		 * Función que se encarga de sumar todos los números del array
		 */
		
		int resultado = 0;
		
		for(int numero : getArrayDeEnteros()) {
			resultado += numero;
		}
		return resultado;
	}
	
	public int restarNumeros() {
		/**
		 * Función que se encarga de restar todos los números del array 
		 */
		
		int resultado = getArrayDeEnteros().get(0); // paso el primer número del array para no incilizarlo en 0
		this.arrayDeEnteros.remove(0);              // elimino el primer número del array
		
		for(int numero : getArrayDeEnteros()) {
			resultado -= numero;
		}
		return resultado;
	}
	
	public int multiplicarNumeros() {
		/**
		 * Función que se encarga de multiplicar todos los números de array entre sí, iniciando con el primero.
		 * Si el primer número del array es 0, el resultado es 0.
		 */
		
		int resultado = getArrayDeEnteros().get(0); // se inicializa el resultado con el primer número del array
		this.arrayDeEnteros.remove(0);
		
		for(int numero : getArrayDeEnteros()) {
			resultado = resultado * numero;
		}
		return resultado;
	}
}
