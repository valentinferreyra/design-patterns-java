package tp6.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp6.ActividadSemanal;
import ar.edu.unq.po2.tp6.Deporte;
import ar.edu.unq.po2.tp6.DiaDeLaSemana;
import ar.edu.unq.po2.tp6.SecretariaDeDeportes;

class SecretariaDeDeportesTest {

	SecretariaDeDeportes secretaria;
	ActividadSemanal actividad1;
	ActividadSemanal actividad2;
	ActividadSemanal actividad3;
	ActividadSemanal actividad4;
	ActividadSemanal actividad5;
	
	@BeforeEach
	public void setUp() throws Exception {
		
		this.actividad1 = new ActividadSemanal(DiaDeLaSemana.LUNES, 17, 90, Deporte.FUTBOL);
		this.actividad2 = new ActividadSemanal(DiaDeLaSemana.JUEVES, 16, 120, Deporte.TENNIS);
		this.actividad3 = new ActividadSemanal(DiaDeLaSemana.SABADO, 14, 90, Deporte.FUTBOL);
		this.actividad4 = new ActividadSemanal(DiaDeLaSemana.DOMINGO, 11, 120, Deporte.TENNIS);
		this.actividad5 = new ActividadSemanal(DiaDeLaSemana.DOMINGO, 19, 120, Deporte.TENNIS);
		
		List<ActividadSemanal> actividades = Arrays.asList(actividad1, actividad2, actividad3, actividad4, actividad5); 
		
		this.secretaria = new SecretariaDeDeportes(actividades);
		
	}

	@Test
	public void testActividadesDeFutbol() {
		assertEquals(secretaria.getActividadesDeFutbol().size(), 2);
	}
	
	@Test
	public void testActividadesDeUnaComplejidad() {
		assertEquals(secretaria.getActividadesDeComplejidad(2).size(), 2); //fubtol es complejidad 2
		assertEquals(secretaria.getActividadesDeComplejidad(3).size(), 3); // tennis es complejidad 3
	}
	
	@Test 
	public void testCantidadHorasTotales() {
		assertEquals(secretaria.cantidadHorasTotales(), 9);
	}
	
	@Test
	public void testActSemanalDeMenorCosto() {
		assertEquals(secretaria.actividadMenorCostoPara(Deporte.FUTBOL), actividad1); // actividad1 es lunes, actividad4 es domingo
		assertEquals(secretaria.actividadMenorCostoPara(Deporte.TENNIS), actividad2); // todas las actividades de tennis valen lo mismo, por lo tanto toma el primero
 	}
	
	

}
