package tpTestDoubles.testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpTestDoubles.Carta;
import ar.edu.unq.po2.tpTestDoubles.ColorDeCarta;
import ar.edu.unq.po2.tpTestDoubles.NumeroDeCarta;
import ar.edu.unq.po2.tpTestDoubles.PokerStatusConCarta;

class PoquerMockitoTest {
	
	PokerStatusConCarta pokerStatus;
	Carta carta1;
	Carta carta2;
	Carta carta3;
	Carta carta4;
	Carta carta5;
	
	@BeforeEach
	public void setUp() throws Exception {
		
		this.pokerStatus = new PokerStatusConCarta();
		
		this.carta1 = mock(Carta.class);
		this.carta2 = mock(Carta.class);
		this.carta3 = mock(Carta.class);
		this.carta4 = mock(Carta.class);
		this.carta5 = mock(Carta.class);
	}
	
	@Test
	public void testUnPokerStatusTienePoquer() {
		when(carta1.getNumero()).thenReturn(NumeroDeCarta.TRES);
		when(carta2.getNumero()).thenReturn(NumeroDeCarta.TRES);
		when(carta3.getNumero()).thenReturn(NumeroDeCarta.DOS);
		when(carta4.getNumero()).thenReturn(NumeroDeCarta.TRES);
		when(carta5.getNumero()).thenReturn(NumeroDeCarta.TRES);
		
		assertEquals(pokerStatus.verificar(Arrays.asList(carta1, carta2, carta3, carta4, carta5)), "Poquer");		
	}
	
	@Test
	public void testUnPokerStatusTieneTrio() {
		when(carta1.getNumero()).thenReturn(NumeroDeCarta.TRES);
		when(carta2.getNumero()).thenReturn(NumeroDeCarta.TRES);
		when(carta3.getNumero()).thenReturn(NumeroDeCarta.DOS);
		when(carta4.getNumero()).thenReturn(NumeroDeCarta.SIETE);
		when(carta5.getNumero()).thenReturn(NumeroDeCarta.TRES);
		
		assertEquals(pokerStatus.verificar(Arrays.asList(carta1, carta2, carta3, carta4, carta5)), "Trio");		
	}
	
	@Test
	public void testUnPokerStatusTieneColor() {
		when(carta1.getColor()).thenReturn(ColorDeCarta.PICAS);
		when(carta2.getColor()).thenReturn(ColorDeCarta.PICAS);
		when(carta3.getColor()).thenReturn(ColorDeCarta.PICAS);
		when(carta4.getColor()).thenReturn(ColorDeCarta.PICAS);
		when(carta5.getColor()).thenReturn(ColorDeCarta.PICAS);
		
		assertEquals(pokerStatus.verificar(Arrays.asList(carta1, carta2, carta3, carta4, carta5)), "Color");				
	}
	
	@Test
	public void testUnPokerStatusNoTieneNada() {
		when(carta1.getColor()).thenReturn(ColorDeCarta.PICAS);
		when(carta2.getColor()).thenReturn(ColorDeCarta.PICAS);
		when(carta3.getColor()).thenReturn(ColorDeCarta.DIAMANTES);
		when(carta4.getColor()).thenReturn(ColorDeCarta.TREBOLES);
		when(carta5.getColor()).thenReturn(ColorDeCarta.PICAS);
		
		assertEquals(pokerStatus.verificar(Arrays.asList(carta1, carta2, carta3, carta4, carta5)), "Nada");				
	}
}
