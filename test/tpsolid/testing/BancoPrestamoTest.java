package tpsolid.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpsolid.Banco;
import ar.edu.unq.po2.tpsolid.Cliente;
import ar.edu.unq.po2.tpsolid.CreditoHipotecario;
import ar.edu.unq.po2.tpsolid.CreditoPersonal;
import ar.edu.unq.po2.tpsolid.PropiedadInmobiliaria;
import ar.edu.unq.po2.tpsolid.SolicitudCredito;

class BancoPrestamoTest {
	
	private Cliente cliente1;
	private Cliente cliente2;
	private Cliente cliente3;
	private Cliente cliente4;
	private Banco banco;
	private SolicitudCredito solicitudPersonal1;
	private SolicitudCredito solicitudPersonal2;
	private SolicitudCredito solicitudHipotecario1;
	private SolicitudCredito solicitudHipotecario2;
	private SolicitudCredito solicitudHipotecario3;
	private PropiedadInmobiliaria propiedad;
	
	@BeforeEach
	public void setUp() throws Exception {
		
		this.cliente1 = new Cliente("Valentín", "Ferreyra", "Av. SV 123", 21, 1080000f);
		this.cliente2 = new Cliente("Agustin", "Alzamendi", "844 2312", 25, 200f);
		this.cliente3 = new Cliente("Roberto", "Fauto", "Florida 2352", 68, 500000f);
		this.cliente4 = new Cliente("Ricardo", "Molina", "San Martin 4563", 46, 790666f);
		
		List<Cliente> clientes = Arrays.asList(cliente1, cliente2, cliente3);
		
		this.banco = new Banco(clientes);
		
		this.solicitudPersonal1 = new CreditoPersonal(cliente1, 200000f, 12);
		this.solicitudPersonal2 = new CreditoPersonal(cliente2, 400000f, 12);
		
		this.propiedad = new PropiedadInmobiliaria("Casa 5 ambientes", "San Martin 2324", 15000000f);
		
		this.solicitudHipotecario1 = new CreditoHipotecario(cliente1, 500000f, 24, propiedad);
		this.solicitudHipotecario2 = new CreditoHipotecario(cliente2, 500000f, 24, propiedad);
		this.solicitudHipotecario3 = new CreditoHipotecario(cliente3, 500000f, 24, propiedad);

}
	
//	@Test
//	public void testEsClienteDeUnBanco() {
//		assertTrue(banco.esCliente(cliente3));
//		assertFalse(banco.esCliente(cliente4));
//	} el test funcionaba pero ya no, porque esCliente() es un método privado del Banco (lo hice public solo para el test)
	
	@Test
	public void testSolicitudCreditoSinPertenecerAlBanco() {
		//Excersise: el cliente4 intenta iniciar una solicitud de crédito a un banco que no es cliente
		//           el cliente4 tiene todos los requsitos para obtener un crédito personal
		cliente4.iniciarSolicitudDeCredito(banco, solicitudPersonal1);
		
		//no se le otorgó el crédito
		assertNotEquals(cliente4.getMontoDeCreditos(), solicitudPersonal1.getMontoSolicitado());
	}
	
	@Test
	public void testCreditoPersonal() {
		// Excercise: tanto cliente1 como cliente2 inician solicitud de crédito personal al banco al cual pertenecen
		cliente1.iniciarSolicitudDeCredito(banco, solicitudPersonal1);
		cliente2.iniciarSolicitudDeCredito(banco, solicitudPersonal2);
		
		//al cliente1 se le otorgó el crédito ya que su ingreso anual supera los 15000
		assertEquals(cliente1.getMontoDeCreditos(), solicitudPersonal1.getMontoSolicitado());
		//al cliente2 no se le otorgó el crédito ya que su ingreso anual no supera los 15000
		assertNotEquals(cliente2.getMontoDeCreditos(), solicitudPersonal2.getMontoSolicitado());
	}
	
	@Test
	public void testCreditoHipotecario() {
		//Excercise: tanto cliente1, cliente2 como cliente3 inician solicitud de crédito hipotecario al banco la cual pertencen
		cliente1.iniciarSolicitudDeCredito(banco, solicitudHipotecario1);
		cliente2.iniciarSolicitudDeCredito(banco, solicitudHipotecario2);
		cliente3.iniciarSolicitudDeCredito(banco, solicitudHipotecario3);
		
		// al cliente1 se le otorgó el crédito
		assertEquals(cliente1.getMontoDeCreditos(), solicitudHipotecario1.getMontoSolicitado());
		//mientras que al cliente2 no, ya que sus ingresos no se lo permiten
		assertNotEquals(cliente2.getMontoDeCreditos(), solicitudHipotecario2.getMontoSolicitado());
		// al cliente3 tampoco se le otorga ya que supera la edad de 68 años
		assertNotEquals(cliente3.getMontoDeCreditos(), solicitudHipotecario3.getMontoSolicitado());
		
		
	}
	

}
