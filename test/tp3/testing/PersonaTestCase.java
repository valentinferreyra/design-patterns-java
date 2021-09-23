package tp3.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.Persona;

class PersonaTestCase {
	
	Persona valentin = new Persona("valentin", "ferreyra", LocalDate.of(1999, 8, 6));

	@Test
	public void testPersonaEdad() {
		
	assertEquals(valentin.getEdad(), 22);
	}
	
	@Test
	public void testPersonaEsMenor() {
		
	Persona alberto  = new Persona("alberto", "rodriguez", LocalDate.of(1992, 2, 2));
	
	assertTrue(valentin.menorQue(alberto));
	}
}
