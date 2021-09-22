package tp3.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.Persona;

class PersonaTestCase {
	
	Persona valentin = new Persona("valentin", "ferreyra", "08/06/1999");

	@Test
	public void testPersonaEdad() {
		
	assertEquals(valentin.getEdad(), 22);
	}
	
	@Test
	public void testPersonaEsMenor() {
		
	Persona alberto  = new Persona("alberto", "rodriguez", "02/02/1992");
	
	assertTrue(valentin.menorQue(alberto));
	}
}
