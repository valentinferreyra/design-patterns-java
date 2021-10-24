package tpTestDoubles.testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpTestDoubles.Carta;
import ar.edu.unq.po2.tpTestDoubles.ColorDeCarta;
import ar.edu.unq.po2.tpTestDoubles.NumeroDeCarta;
import ar.edu.unq.po2.tpTestDoubles.PokerStatus;
import ar.edu.unq.po2.tpTestDoubles.PokerStatusConCarta;
import ar.edu.unq.po2.tpsolid.Banco;
import ar.edu.unq.po2.tpsolid.Cliente;
import ar.edu.unq.po2.tpsolid.CreditoHipotecario;
import ar.edu.unq.po2.tpsolid.CreditoPersonal;
import ar.edu.unq.po2.tpsolid.PropiedadInmobiliaria;
import ar.edu.unq.po2.tpsolid.SolicitudCredito;

class pokerMockito {
	
	PokerStatusConCarta pokerStatus;
	Carta carta1;
	Carta carta2;
	Carta carta3;
	Carta carta4;
	Carta carta5;
	Carta carta6;
	
	@BeforeEach
	public void setUp() throws Exception {
		
		this.pokerStatus = mock(PokerStatusConCarta.class);
		
		this.carta1 = new Carta(NumeroDeCarta.DOS, ColorDeCarta.CORAZONES);
		this.carta2 = new Carta(NumeroDeCarta.K, ColorDeCarta.PICAS);
		this.carta3 = new Carta(NumeroDeCarta.CINCO, ColorDeCarta.TREBOLES);
		this.carta4 = new Carta(NumeroDeCarta.OCHO, ColorDeCarta.DIAMANTES);
		this.carta5 = new Carta(NumeroDeCarta.Q, ColorDeCarta.CORAZONES);
		this.carta6 = new Carta(NumeroDeCarta.UNO, ColorDeCarta.CORAZONES);
	}
	
	@Test
	public void testUnPokerStatusTienePoquer() {
		when(pokerStatus.hayPoker()).thenReturn(true);
	}
	
	

}
