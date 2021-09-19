package tp3.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.Persona;

class PersonaTestCase {

	@Test
	public void testPersonaEdad() {
	
	Date fechaNacimiento = new Date(99, 5, 8);
	
	Persona valentin = new Persona("valentin", fechaNacimiento);
	
	int amount = valentin.getEdad();
	
	assertEquals(amount, 22);
	
	}
}
