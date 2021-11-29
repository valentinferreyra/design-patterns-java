package tpTestDoubles.testing;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import ar.edu.unq.po2.tpTestDoubles.Carta;
import ar.edu.unq.po2.tpTestDoubles.ColorDeCarta;
import ar.edu.unq.po2.tpTestDoubles.Jugada;
import ar.edu.unq.po2.tpTestDoubles.NumeroDeCarta;

class JugadasDePoquerTest {
	Jugada miJugada;
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

		this.carta1 = new Carta(NumeroDeCarta.DOS, ColorDeCarta.CORAZONES);
		this.carta2 = new Carta(NumeroDeCarta.DOS, ColorDeCarta.PICAS);
		this.carta3 = new Carta(NumeroDeCarta.DOS, ColorDeCarta.TREBOLES);
		this.carta4 = new Carta(NumeroDeCarta.DOS, ColorDeCarta.DIAMANTES);
		this.carta5 = new Carta(NumeroDeCarta.Q, ColorDeCarta.CORAZONES);
		this.carta6 = new Carta(NumeroDeCarta.A, ColorDeCarta.CORAZONES);
		this.carta7 = new Carta(NumeroDeCarta.OCHO, ColorDeCarta.CORAZONES);
		this.carta8 = new Carta(NumeroDeCarta.NUEVE, ColorDeCarta.CORAZONES);
		this.carta9 = new Carta(NumeroDeCarta.SEIS, ColorDeCarta.PICAS);
		this.carta10 = new Carta(NumeroDeCarta.J, ColorDeCarta.TREBOLES);
	}
	
	@Test
	public void testUnaJugadaDePoquePuedeDetectarAlGanador() {
		/**
		 * La mano de cartas1 tiene poquer, mientras que cartas2 solo tiene trio,
		 * por lo tanto, el ganador debe ser cartas1
		 */
		List<Carta> cartas1 = Arrays.asList(carta1, carta2, carta3, carta4, carta5);
		List<Carta> cartas2 = Arrays.asList(carta6, carta1, carta2, carta3, carta1);
		
		miJugada = new Jugada(cartas1, cartas2);
		
		assertEquals(miJugada.ganadorDeLaMano(), cartas1);		
	}
}
