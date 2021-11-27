package tpStateStrategy.testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpStateStrategy.reproductormp3.ReproductorDeMusica;
import ar.edu.unq.po2.tpStateStrategy.reproductormp3.Song;

class ReproductorTest {
	
	ReproductorDeMusica reproductor;
	Song song;
	
	@BeforeEach
	void setUp() throws Exception {
		this.reproductor = new ReproductorDeMusica();
		this.song = mock(Song.class);
	}
	
	@Test
	void testCuandoUnReproductorEstaSeleccionandoCancionesYSePonePausa_LanzaUnaException() {
		reproductor.seleccionarCancion(song);

		assertThrows(RuntimeException.class, () -> reproductor.pauseMusic());
		verify(song, never()).pause();		
		// Verifico que la canción nunca llegó a pausarse
	}

	@Test
	void testUnReproductorDeMusicaSeleccionaUnaCancionYLaReproduce() {
		reproductor.seleccionarCancion(song);
		reproductor.playMusic();
		
		verify(song).play();
	}
	
	@Test
	void testCuandoUnReproductorPonePlayCuandoEstaReproduciendo_LanzaUnaExcepcion() {
		reproductor.seleccionarCancion(song);
		reproductor.playMusic();
		
		assertThrows(RuntimeException.class, () -> reproductor.playMusic());
		// Compruebo que lanza una excepción de la clase RuntimeException
	}
	
	@Test
	void testCuandoSeReproduceUnaCancionYSePoneStop_LaCancionSePara() {
		reproductor.seleccionarCancion(song);
		reproductor.playMusic();
		reproductor.stopMusic();
		
		verify(song).stop();
	}
	
	@Test
	void testCuandoUnaCancionEstaEnPausaYSePonePlay_LanzaUnaExcepcion() {
		reproductor.seleccionarCancion(song);
		reproductor.playMusic();
		reproductor.pauseMusic();

		assertThrows(RuntimeException.class, () -> reproductor.playMusic());		
	}
	
	@Test
	void testCuandoUnaCancionEstaPausadaYSePoneStop_LaCancionSePara() {
		reproductor.seleccionarCancion(song);
		reproductor.playMusic();
		reproductor.pauseMusic();
		reproductor.stopMusic();
		
		verify(song).stop();
	}

}
