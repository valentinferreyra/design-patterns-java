package tp5.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp5.Agencia;
import ar.edu.unq.po2.tp5.Caja;
import ar.edu.unq.po2.tp5.Impuesto;
import ar.edu.unq.po2.tp5.Pagable;
import ar.edu.unq.po2.tp5.Producto;
import ar.edu.unq.po2.tp5.ProductoCooperativa;
import ar.edu.unq.po2.tp5.Servicio;

class CajaProductoTest {
	
	private Caja caja;
	private Agencia unaAgencia;
	private Producto arroz;
	private ProductoCooperativa leche;
	private Impuesto impuesto;
	private Servicio servicio;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.caja = new Caja();
		this.unaAgencia = new Agencia("PaymentAgency");
		this.arroz = new Producto(90f, 50);
		this.leche = new ProductoCooperativa(100f, 30);
		this.impuesto = new Impuesto(unaAgencia, 200f, 0001);
		this.servicio = new Servicio(unaAgencia, 20f, 5, 0002);
	}
	
	@Test 
	public void cajaCobraProductoTest() {
		double totalAPagar = caja.cobrar(arroz);
		
		assertEquals(totalAPagar, 90f);		
	}
	
	@Test
	public void cajaCobraProductosTest() {
		List<Pagable> pagables = Arrays.asList(arroz, leche);
		double totalAPagar = caja.cobrar(pagables);
		
		assertEquals(totalAPagar, 180f);
	}
	
	@Test	
	public void cajaCobraImpuestoTest() {
		double totalAPagar = caja.cobrar(impuesto);
		
		assertEquals(200f, totalAPagar);
		assertTrue(unaAgencia.recibioElPagoDe(impuesto));
	}
	
	@Test
	public void cajaCobraServicioTest() {
		double totalAPagar = caja.cobrar(servicio);
		
		assertEquals(100f, totalAPagar);
		assertTrue(unaAgencia.recibioElPagoDe(servicio));
	}
	
	@Test
	public void cajaCobraPagables() {
		List<Pagable> pagables = Arrays.asList(arroz, leche, impuesto, servicio);
		double totalAPagar = caja.cobrar(pagables);
		
		assertEquals(480f, totalAPagar);
		assertTrue(unaAgencia.recibioElPagoDe(impuesto));
		assertTrue(unaAgencia.recibioElPagoDe(servicio));
	}
}
	
// ********************************************************
// ******* CÓDIGO SIN IMPLEMENTAR INTERFACE PAGABLE *******
// ********************************************************
//	private Producto arroz;
//	private ProductoCooperativa leche;
//	private Caja caja;
//	private List<Producto> arrayDeProductos = new ArrayList<Producto>();
//	
//	@BeforeEach
//	public void setUp() {
//		this.arroz = new Producto(100.0, 50);
//		this.leche = new ProductoCooperativa(100.0, 30);
//		this.caja  = new Caja();
//		this.arrayDeProductos.add(arroz);
//		this.arrayDeProductos.add(leche);
//	}
//	
//	@Test
//	public void testDecrementoDeStock() {
//		caja.cobrar(arroz);
//		assertEquals(arroz.getStock(), 49);
//		caja.cobrar(arrayDeProductos);
//		assertEquals(arroz.getStock(), 48);
//		assertEquals(leche.getStock(), 29);
//	}
//	
//	@Test
//	public void testPrecioProductoTradicional() {
//		double precio = caja.cobrar(arroz); //arroz es producto tradicional, por lo tanto no se le aplica descuento de 10%
//		
//		assertEquals(precio, 100.0);
//	}
//	
//	@Test
//	public void testPrecioProductoCooperativa() {
//		double precio = caja.cobrar(leche); //leche es producto cooperativa, por lo tanto se le aplica descuento de 10%
//		
//		assertEquals(precio, 90.0);
//	}
//	
//	@Test
//	public void testPrecioProductos() {
//		double precioArroz = caja.cobrar(arroz);
//		double precioArrozLeche = caja.cobrar(arrayDeProductos);
//		
//		assertEquals(precioArroz, 100.0);
//		assertEquals(precioArrozLeche, 190.0);
//	}
