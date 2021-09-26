package tp4.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp4.ProductoPrimeraNecesidad;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoPrimeraNecesidadTest {

	private ProductoPrimeraNecesidad leche;
	private ProductoPrimeraNecesidad arroz;
	
	@BeforeEach
	public void setUp() {
		leche = new ProductoPrimeraNecesidad("Leche", 100.0, false, 11);
		arroz = new ProductoPrimeraNecesidad("Leche", 100.0, false, 9);
	}
	
	@Test
	public void testCalcularPrecio() {
		assertEquals(Double.valueOf(89.0), leche.getPrecio());
		assertEquals(Double.valueOf(91.0), arroz.getPrecio());
	}
}
