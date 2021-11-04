package tpTemplateMethodAndAdapter.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpTempMethodAdapter.sueldosRecargados.EmpleadoDePlanta;
import ar.edu.unq.po2.tpTempMethodAdapter.sueldosRecargados.EmpleadoPasante;
import ar.edu.unq.po2.tpTempMethodAdapter.sueldosRecargados.EmpleadoTemporario;

class SueldosRecargadosTest {

	private EmpleadoTemporario temporario;
	private EmpleadoPasante pasante;
	private EmpleadoDePlanta dePlanta;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.temporario = new EmpleadoTemporario(1000.0, 5, true, false);
		this.pasante    = new EmpleadoPasante(10);
		this.dePlanta   = new EmpleadoDePlanta(3000.0, 3);
	}
	
	@Test
	void testCobroEmpleadoTemporario() {				
		// 1000 - descuento + 100 por tener hijos y 25 de horas extras = 995
		assertEquals(995.0, temporario.sueldo(), "Error en el cobro a Temporario");
	}
	
	@Test
	void testCobroEmpleadoPasante() {
		// El sueldo básico del pasante es 10 * 45, pero se le resta el descuento
		assertEquals(348.0, pasante.sueldo(), "Error en el cobro a Pasante");
	}
	
	@Test
	void testCobroEmpleadoDePlanta() {
		// El sueldo básico de Empleado de Planta es 3000, más 450 por los hijos,
		// menos el descuento de la empresa
		assertEquals(3060.0, dePlanta.sueldo());
	}

}
