package tp3.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.EquipoDeTrabajo;
import ar.edu.unq.po2.tp3.Persona;


class EquipoDeTrabajoTestCase {

	ArrayList<Persona> personas = new ArrayList<>();

	
//	@BeforeEach
//	public void setUp() throws Exception {
//		personas.add(new Persona("valentin", "ferreyra", LocalDate.of(1999, 8, 6)));
//		personas.add(new Persona("roberto", "rodriguez", LocalDate.of(2000, 12, 4)));
//		personas.add(new Persona("ricardo", "fernandez", LocalDate.of(2001, 9, 10)));
//		personas.add(new Persona("emanuel", "valenzuela", LocalDate.of(1997, 6, 28)));
//		personas.add(new Persona("carlos", "quiroga", LocalDate.of(2002, 1, 11)));
//	}
//	
	@Test
	public void testEquipoDeTrabajoNombre() {
		personas.add(new Persona("valentin", "ferreyra", LocalDate.of(1999, 8, 6)));
		personas.add(new Persona("roberto", "rodriguez", LocalDate.of(2000, 12, 4)));
		personas.add(new Persona("ricardo", "fernandez", LocalDate.of(2001, 9, 10)));
		personas.add(new Persona("emanuel", "valenzuela", LocalDate.of(1997, 6, 28)));
		personas.add(new Persona("carlos", "quiroga", LocalDate.of(2002, 1, 11)));
		
		EquipoDeTrabajo equipo = new EquipoDeTrabajo("Programadores", personas);
		
		assertEquals(equipo.getNombre(), "Programadores");
		
	}
	
	@Test
	public void testEquipoDeTrabajoPromedioEdad() {
		personas.add(new Persona("valentin", "ferreyra", LocalDate.of(1999, 8, 6)));
		personas.add(new Persona("roberto", "rodriguez", LocalDate.of(2000, 12, 4)));
		personas.add(new Persona("ricardo", "fernandez", LocalDate.of(2001, 9, 10)));
		personas.add(new Persona("emanuel", "valenzuela", LocalDate.of(1997, 6, 28)));
		personas.add(new Persona("carlos", "quiroga", LocalDate.of(2002, 1, 11)));
		
		EquipoDeTrabajo equipo = new EquipoDeTrabajo("Programadores", personas);
		
		assertEquals(equipo.promedioEdad(), 21);

	}
	
}
