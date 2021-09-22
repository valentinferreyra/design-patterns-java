package tp3.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.EquipoDeTrabajo;
import ar.edu.unq.po2.tp3.Persona;


class EquipoDeTrabajoTestCase {

	ArrayList<Persona> personas = new ArrayList<>();

	
	@BeforeEach
	public void setUp() throws Exception {
		personas.add(new Persona("valentin", "ferreyra", "08/06/1999"));
		personas.add(new Persona("roberto", "rodriguez", "12/04/2000"));
		personas.add(new Persona("ricardo", "fernandez", "10/09/2001"));
		personas.add(new Persona("emanuel", "valenzuela", "28/06/1997"));
		personas.add(new Persona("carlos", "quiroga", "11/01/2002"));
	}
	
	@Test
	public void testEquipoDeTrabajoNombre() {
		personas.add(new Persona("valentin", "ferreyra", "08/06/1999"));
		personas.add(new Persona("roberto", "rodriguez", "12/04/2000"));
		personas.add(new Persona("ricardo", "fernandez", "10/09/2001"));
		personas.add(new Persona("emanuel", "valenzuela", "28/06/1997"));
		personas.add(new Persona("carlos", "quiroga", "11/01/2002"));
		
		EquipoDeTrabajo equipo = new EquipoDeTrabajo("Programadores", personas);
		
		assertEquals(equipo.getNombre(), "Programadores");
		
	}
	
	@Test
	public void testEquipoDeTrabajoPromedioEdad() {
		
		EquipoDeTrabajo equipo = new EquipoDeTrabajo("Programadores", personas);
		
		assertEquals(equipo.promedioEdad(), 21);

	}
	
}
