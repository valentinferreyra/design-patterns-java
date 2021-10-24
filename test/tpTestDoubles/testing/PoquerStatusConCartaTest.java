package tpTestDoubles.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpTestDoubles.Carta;
import ar.edu.unq.po2.tpTestDoubles.ColorDeCarta;
import ar.edu.unq.po2.tpTestDoubles.NumeroDeCarta;
import ar.edu.unq.po2.tpTestDoubles.PokerStatusConCarta;

class PoquerStatusConCartaTest {

	PokerStatusConCarta pokerStatus;
	Carta carta1;
	Carta carta2;
	Carta carta3;
	Carta carta4;
	Carta carta5;
	Carta carta6;
	Carta carta7;
	Carta carta8;
	Carta carta9;
	Carta carta10;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.pokerStatus = new PokerStatusConCarta();
		
		this.carta1 = new Carta(NumeroDeCarta.DOS, ColorDeCarta.CORAZONES);
		this.carta2 = new Carta(NumeroDeCarta.DOS, ColorDeCarta.PICAS);
		this.carta3 = new Carta(NumeroDeCarta.DOS, ColorDeCarta.TREBOLES);
		this.carta4 = new Carta(NumeroDeCarta.DOS, ColorDeCarta.DIAMANTES);
		this.carta5 = new Carta(NumeroDeCarta.Q, ColorDeCarta.CORAZONES);
		this.carta6 = new Carta(NumeroDeCarta.UNO, ColorDeCarta.CORAZONES);
		this.carta7 = new Carta(NumeroDeCarta.OCHO, ColorDeCarta.CORAZONES);
		this.carta8 = new Carta(NumeroDeCarta.NUEVE, ColorDeCarta.CORAZONES);
		this.carta9 = new Carta(NumeroDeCarta.SEIS, ColorDeCarta.PICAS);
		this.carta10 = new Carta(NumeroDeCarta.J, ColorDeCarta.TREBOLES);
	}
	
	@Test
	public void testUnPokerStatusConCartaTienePoquer() {
		/**
		 * Se testea que en una mano de Poquer, si al menos 4 cartas tienen el mismo
		 * número, debe devolver el String "Poquer"
		 */
		assertEquals(pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5), "Poquer");
	}
	
	@Test
	public void testUnPokerStatusConCartaTieneTrio() {
		/**
		 * Se testea que en una mano de Poquer, si al menos 3 cartas tienen el mismo
		 * número, debe devolver el String "Trio"
		 */
		assertEquals(pokerStatus.verificar(carta1, carta2, carta3, carta5, carta6), "Trio");
	}
	
	@Test
	public void testUnPokerStatusConCartaTieneColor() {
		/**
		 * Se testea que en una mano de Poquer, si las 5 cartas tienen el mismo
		 * color, debe devolver el String "Color"
		 */
		assertEquals(pokerStatus.verificar(carta1, carta5, carta6, carta7, carta8), "Color");
	}
	
	@Test
	public void testUnPokerStatusConCartaNoTieneNada() {
		/**
		 *Se testea que si en una mano de Poquer, las cartas no tienen ni Poquer,
		 *ni Trio ni Color, se devuelve el String "Nada"
		 */
		assertEquals(pokerStatus.verificar(carta1, carta2, carta5, carta9, carta10), "Nada");
	}

}
