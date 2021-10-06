package tp5.testing;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp5.Agencia;
import ar.edu.unq.po2.tp5.Impuesto;
import ar.edu.unq.po2.tp5.Servicio;

class FacturaTest {
	
	private Servicio servicio1;
	private Servicio servicio2;
	private Impuesto impuesto1;
	private Impuesto impuesto2;
	private Agencia unaAgencia;
	
	@BeforeEach
	public void setUp() throws Exception {
		unaAgencia = new Agencia("Edesur");
		servicio1 = new Servicio(unaAgencia, 15f, 3, 0001);
		servicio2 = new Servicio(unaAgencia, 10f, 20, 0002);
		impuesto1 = new Impuesto(unaAgencia, 70f, 0003);
		impuesto2 = new Impuesto(unaAgencia, 80f, 0004);
	}

	@Test
	public void pagoDeServicioTest() {
		assertEquals(45f, servicio1.realizarPago());
		assertTrue(unaAgencia.recibioElPagoDe(servicio1));
		assertFalse(unaAgencia.recibioElPagoDe(servicio2));
	}
	
	@Test
	public void pagoDeImpuestoTest() {
		assertEquals(70f, impuesto1.realizarPago());
		assertTrue(unaAgencia.recibioElPagoDe(impuesto1));
		assertFalse(unaAgencia.recibioElPagoDe(impuesto2));
	}
	
	@Test
	public void pagoDeImpuestoYServicioTest() {
		assertEquals(70f, impuesto1.realizarPago());
		assertEquals(45f, servicio1.realizarPago());
		assertTrue(unaAgencia.recibioElPagoDe(impuesto1));
		assertTrue(unaAgencia.recibioElPagoDe(servicio1));
	}

}
