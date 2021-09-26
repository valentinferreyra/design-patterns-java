package tp5.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp5.Caja;
import ar.edu.unq.po2.tp5.Producto;
import ar.edu.unq.po2.tp5.ProductoCooperativa;

class CajaMercadoCentralTest {

	private Producto arroz;
	private ProductoCooperativa leche;
	private Caja caja;
	private List<Producto> arrayDeProductos = new ArrayList<Producto>();
	
	@BeforeEach
	public void setUp() {
		this.arroz = new Producto(100.0, 50);
		this.leche = new ProductoCooperativa(100.0, 30);
		this.caja  = new Caja();
		this.arrayDeProductos.add(arroz);
		this.arrayDeProductos.add(leche);
	}
	
	@Test
	public void testDecrementoDeStock() {
		caja.cobrar(arroz);
		assertEquals(arroz.getStock(), 49);
		caja.cobrar(arrayDeProductos);
		assertEquals(arroz.getStock(), 48);
		assertEquals(leche.getStock(), 29);
	}
	
	@Test
	public void testPrecioProductoTradicional() {
		double precio = caja.cobrar(arroz); //arroz es producto tradicional, por lo tanto no se le aplica descuento de 10%
		
		assertEquals(precio, 100.0);
	}
	
	@Test
	public void testPrecioProductoCooperativa() {
		double precio = caja.cobrar(leche); //leche es producto cooperativa, por lo tanto se le aplica descuento de 10%
		
		assertEquals(precio, 90.0);
	}
	
	@Test
	public void testPrecioProductos() {
		double precioArroz = caja.cobrar(arroz);
		double precioArrozLeche = caja.cobrar(arrayDeProductos);
		
		assertEquals(precioArroz, 100.0);
		assertEquals(precioArrozLeche, 190.0);
	}
}
