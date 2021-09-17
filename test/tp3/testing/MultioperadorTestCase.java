package tp3.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.Multioperador;

class MultioperadorTestCase {
	
	ArrayList<Integer> arrayDeEnteros = new ArrayList<>();
	
	@BeforeEach
	public void setUp() throws Exception {	
	arrayDeEnteros.add(20);
	arrayDeEnteros.add(2);
	arrayDeEnteros.add(3);
	arrayDeEnteros.add(10);
	}

	@Test
	public void testMultioperadorSuma() {
		Multioperador mul = new Multioperador(arrayDeEnteros);
		int amount = mul.sumarNumeros();
	    assertEquals(amount, 35);
	}
	
	@Test
	public void testMultioperadorResta() {
		Multioperador mul = new Multioperador(arrayDeEnteros);
		int amount = mul.restarNumeros();
		assertEquals(amount, 5);
	}
	
	@Test
	public void testMultioperadorMultiplicacion() {
		Multioperador mul = new Multioperador(arrayDeEnteros);
		int amount = mul.multiplicarNumeros();
		assertEquals(amount, 1200);
	}
}
