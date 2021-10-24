package tpTestDoubles.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpTestDoubles.Carta;
import ar.edu.unq.po2.tpTestDoubles.ColorDeCarta;
import ar.edu.unq.po2.tpTestDoubles.NumeroDeCarta;

class CartaTest {

	Carta carta1;
	Carta carta2;
	Carta carta3;
	Carta carta4;
	Carta carta5;
	Carta carta6;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.carta1 = new Carta(NumeroDeCarta.DOS, ColorDeCarta.CORAZONES);
		this.carta2 = new Carta(NumeroDeCarta.K, ColorDeCarta.PICAS);
		this.carta3 = new Carta(NumeroDeCarta.CINCO, ColorDeCarta.TREBOLES);
		this.carta4 = new Carta(NumeroDeCarta.OCHO, ColorDeCarta.DIAMANTES);
		this.carta5 = new Carta(NumeroDeCarta.Q, ColorDeCarta.CORAZONES);
		this.carta6 = new Carta(NumeroDeCarta.UNO, ColorDeCarta.CORAZONES);
	}
	
	@Test
	public void testUnaCartaConoceSuValor() {
		assertEquals(carta1.getNumero(), NumeroDeCarta.DOS);
	}
	
	@Test
	public void testUnaCartaConoceSuPalo() {
		assertEquals(carta1.getColor(), ColorDeCarta.CORAZONES);
	}
	
	@Test
	public void testElValorDeUnaEsMayorQueLaOtra() {
		assertTrue(carta4.elValorEsMayorQue(carta1)); //carta4 es 8, carta1 es 2
	}
	
	@Test
	public void testElValorDeUnaCartaNoEsMayorQueLaOtra() {
		assertFalse(carta1.elValorEsMayorQue(carta4)); //carta4 es 8, carta1 es 2
	}
	
	@Test
	public void testDosCartasSonDelMismoPalo() {
		assertTrue(carta1.esMismoPaloQue(carta6)); //carta1 y carta6 son corazones
	}
	
	public void testDosCartasNoSonDelMismoPalo() {
		assertFalse(carta1.esMismoPaloQue(carta4)); //carta1 es corazones, carta4 es diamantes
	}
}
