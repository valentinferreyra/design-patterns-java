package tp6.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp6.LesionDermatologica;

class LesionDermatologicaTest {

	private LesionDermatologica lesion1;
	private LesionDermatologica lesion2;
	
	@BeforeEach
	public void setUp() throws Exception {
		lesion1 = LesionDermatologica.ROJO;
		lesion2 = LesionDermatologica.MIEL;
	}
	
	@Test
	public void descripcionesDeLesionesTest() {
		assertEquals("Severo", lesion1.getDescripcion());
		assertEquals("Alto", lesion2.getDescripcion());
	}
	
	@Test 
	public void nivelDeRiesgoDeLesionesTest() {
		assertEquals(9, lesion1.getNivelDeRiesgo());
		assertEquals(4, lesion2.getNivelDeRiesgo());
	}
	
	@Test
	public void proximoColorDeLesionTest() {
		assertEquals(lesion2, LesionDermatologica.AMARILLO.getProximoColor());
		assertEquals(lesion1, lesion2.getProximoColor());
	}
}
