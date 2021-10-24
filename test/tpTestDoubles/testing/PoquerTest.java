package tpTestDoubles.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpTestDoubles.PokerStatus;

class PoquerTest {
	
	PokerStatus pokerStatus;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.pokerStatus = new PokerStatus();
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

}
