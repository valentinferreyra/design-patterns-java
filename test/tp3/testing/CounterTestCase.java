package tp3.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.Counter;

public class CounterTestCase {
	
	private Counter counter;
	
		/**
		 * Crea un escenario de test básico, que consiste en un contador
		 * con 10 enteros
		 * 
		 * @throws Exception
		 */
	
	@BeforeEach
	public void setUp() throws Exception {
		
		//Se crea el contador
		counter = new Counter();
		
		//Se agregan los numeros. Un solo par y nueve impares
		counter.addNumber(1);
		counter.addNumber(3);
		counter.addNumber(5);
		counter.addNumber(7);
		counter.addNumber(9);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(4);
	}
	
	/**
	 * Verifica la cantidad de pares
	 */
	
	@Test
	public void testEvenNumbers() {
		
		//Getting the even ocurrences
			int amount = counter.getEvenOcurrences();
		
		//I check the amount is the expected one
			assertEquals(amount, 1);
	}
	
	/**
	 * Verifica la cantidad de impares
	 */
	
	@Test
	public void testOddNumbers() {
		
		//Getting the odd ocurrences
			int amount = counter.getOddOcurrences();
		
		//I check the amount is the expected one
			assertEquals(amount, 9);
	}
	
	/**
	 * Verifica los múltiplos de un número
	 */
	@Test
	public void testMultiples() {
		
		//Getting the multiples of a number
			int amount = counter.countMultiplesOf(3);
		
		// I check the amount is the expected one
			assertEquals(amount, 2);
	}
	
	@Test
	public void testMayorNumeroMultiplo() {
		
		int amount = counter.numeroMasAltoMultiploDe(3, 9);
		
		assertEquals(amount, 999);
	}
}