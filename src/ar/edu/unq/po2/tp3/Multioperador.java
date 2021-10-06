package ar.edu.unq.po2.tp3;

import java.util.List;

public class Multioperador {
	
	private List<Integer> arrayDeEnteros;
	
	public Multioperador(List<Integer> array) {
		/**
		 * @param array = una lista de enteros 
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
		 * param n = n�mero que ser� agregado al array
		 */
		
		getArrayDeEnteros().add(n);
	}
	
	public int sumarNumeros() {
		/**
		 * Funci�n que se encarga de sumar todos los n�meros del array
		 */
		
		int resultado = 0;
		
		for(int i = 0; i < getArrayDeEnteros().size(); i++) {
			resultado += arrayDeEnteros.get(i);
		}
		return resultado;
	}
	
	public int restarNumeros() {
		/**
		 * Funci�n que se encarga de restar todos los n�meros del array 
		 */
		
		int resultado = getArrayDeEnteros().get(0); // paso el primer n�mero del array para no incilizarlo en 0
		this.arrayDeEnteros.remove(0);              // elimino el primer n�mero del array
		
		for(int i = 0; i < getArrayDeEnteros().size(); i++) {
			resultado -= arrayDeEnteros.get(i);
		}
		return resultado;
}
	
	public int multiplicarNumeros() {
		/**
		 * Funci�n que se encarga de multiplicar todos los n�meros de array entre s�, iniciando con el primero.
		 * Si el primer n�mero del array es 0, el resultado es 0.
		 */
		
		int resultado = getArrayDeEnteros().get(0); // se inicializa el resultado con el primer n�mero del array
		this.arrayDeEnteros.remove(0);
		
		for(int i = 0; i < getArrayDeEnteros().size(); i++) { // o for(numero : getArrayDeEnteros())?
			resultado = resultado * arrayDeEnteros.get(i);
		}
		return resultado;
	}
}
