package tpTestDoubles.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpTestDoubles.Carta;
import ar.edu.unq.po2.tpTestDoubles.ColorDeCarta;
import ar.edu.unq.po2.tpTestDoubles.NumeroDeCarta;
import ar.edu.unq.po2.tpTestDoubles.PokerStatus;
import ar.edu.unq.po2.tpTestDoubles.PokerStatusConCarta;


class PoquerTest {
	
	PokerStatus pokerStatus;
	PokerStatusConCarta pokerStatus2;
	Carta carta1;
	Carta carta2;
	Carta carta3;
	Carta carta4;
	Carta carta5;
	Carta carta6;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.pokerStatus = new PokerStatus();
		this.pokerStatus2 = new PokerStatusConCarta();
		
		this.carta1 = new Carta(NumeroDeCarta.DOS, ColorDeCarta.CORAZONES);
		this.carta2 = new Carta(NumeroDeCarta.K, ColorDeCarta.PICAS);
		this.carta3 = new Carta(NumeroDeCarta.CINCO, ColorDeCarta.TREBOLES);
		this.carta4 = new Carta(NumeroDeCarta.OCHO, ColorDeCarta.DIAMANTES);
		this.carta5 = new Carta(NumeroDeCarta.Q, ColorDeCarta.CORAZONES);
		this.carta6 = new Carta(NumeroDeCarta.UNO, ColorDeCarta.CORAZONES);
	}
	
//	@Test
//	public void testUnPokerStatusNoTienePoquer() {
//		assertFalse(pokerStatus.verificar("2D","4T","9C","QD","2T"));
//	}
//	
//	@Test
//	public void testUnPokerStatusTienePoquer() {
//		assertTrue(pokerStatus.verificar("2D", "2T", "3D", "2C", "2P"));
//	}
//	TEST DEPRECADOS 
	
	@Test
	public void testUnPokerStatusTienePoquer() {
		/**
		 * Se testea que en una mano de Poquer, si al menos 4 cartas tienen el mismo
		 * número, debe devolver el String "Poquer"
		 */
		assertEquals(pokerStatus.verificar("2D", "2T", "3D", "2C", "2P"), "Poquer");
	}
	
	@Test
	public void testUnPokerStatusTieneTrio() {
		/**
		 * Se testea que en una mano de Poquer, si al menos 3 cartas tienen el mismo
		 * número, debe devolver el String "Trio"
		 */
		assertEquals(pokerStatus.verificar("2D", "2T", "3D", "KC", "2P"), "Trio");
	}
	
	@Test
	public void testUnPokerStatusTieneColor() {
		/**
		 * Se testea que en una mano de Poquer, si las 5 cartas tienen el mismo
		 * color, debe devolver el String "Color"
		 */
		assertEquals(pokerStatus.verificar("2D", "5D", "3D", "KD", "10D"), "Color");
	}
	
	@Test
	public void testUnPokerStatusNoTieneNada() {
		/**
		 *Se testea que si en una mano de Poquer, las cartas no tienen ni Poquer,
		 *ni Trio ni Color, se devuelve el String "Nada"
		 */
		assertEquals(pokerStatus.verificar("2T", "5C", "3D", "KD", "10C"), "Nada");
	}

// --------------------------------------------//
	//---- TESTING VALORES DE LA CARTA ----//
	
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
