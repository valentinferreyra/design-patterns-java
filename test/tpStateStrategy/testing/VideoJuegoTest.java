package tpStateStrategy.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpStateStrategy.videojuego.MaquinaDeJuego;

class VideoJuegoTest {
	
	MaquinaDeJuego maquina;

	@BeforeEach
	public void setUp() throws Exception {
		this.maquina = new MaquinaDeJuego();
	}
	
	@Test
	void testUnaMaquinaEnEstadoEncendida_TieneCeroFichasYSusBotonesEstanDesactivados() {
		assertEquals(maquina.getFichas(), 0);
		assertFalse(maquina.tieneBotonesActivados());
	}
	
	@Test
	void testUnaMaquinaEnEstadoActivaSeIngresaUnaFicha_AumentanSusFichasYActivaSusBotones() {
		maquina.ingresarFicha();
		
		assertEquals(maquina.getFichas(), 1);
		assertTrue(maquina.tieneBotonesActivados()); 
		// con esto compruebo que el estado de la máquina cambió para que un jugador juegue
	}
	
	@Test
	void testUnaMaquinaEnEstadoUnJugadorSeFinaliza_SeReseteanLasFichasYDesactivanSusBotones() {
		maquina.ingresarFicha(); // ingresa un jugador
		maquina.finalizarJuego(); // finaliza el juego
		
		assertEquals(maquina.getFichas(), 0);
		assertFalse(maquina.tieneBotonesActivados());
	}
	
	@Test
	void testUnaMaquinaEnEstadoUnJugadorSeIngresaOtraFicha_AumentanSusFichasYLosBotonesNoSeDesactivan() {
		maquina.ingresarFicha();
		maquina.ingresarFicha();
		
		assertEquals(maquina.getFichas(), 2);
		assertTrue(maquina.tieneBotonesActivados());
		// Con esto compruebo que el estado de la máquina cambió para que dos jugadores jueguen
	}
	
	@Test
	void testUnaMaquinaEnEstadoDosJuegadoresSeFinaliza_SeReseteanLasFichasYDesactivanSusBotones() {
		maquina.ingresarFicha();
		maquina.ingresarFicha();
		maquina.finalizarJuego();

		assertEquals(maquina.getFichas(), 0);
		assertFalse(maquina.tieneBotonesActivados());		
	}

}
