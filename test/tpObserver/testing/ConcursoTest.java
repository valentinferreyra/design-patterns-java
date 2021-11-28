package tpObserver.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.tpObserver.concurso.EsperandoParaIniciar;
import ar.edu.unq.po2.tpObserver.concurso.JuegoEnProceso;
import ar.edu.unq.po2.tpObserver.concurso.JuegoTerminado;
import ar.edu.unq.po2.tpObserver.concurso.Participante;
import ar.edu.unq.po2.tpObserver.concurso.ServidorDeJuego;

class ConcursoTest {
	
	private ServidorDeJuego servidor;
	private Participante participante1;
	private Participante participante2;
	private Participante participante3;
	private Participante participante4;
	private Participante participante5;
	private Participante participante6;
	private Map<String, String> qa;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.qa = new HashMap<String, String>();
		qa.put("1", "Z");
		qa.put("2", "Y");
		qa.put("3", "X");
		qa.put("4", "W");
		qa.put("5", "V");
		
		this.servidor = new ServidorDeJuego(qa);
		
		this.participante1 = Mockito.mock(Participante.class);
		this.participante2 = Mockito.mock(Participante.class);
		this.participante3 = Mockito.mock(Participante.class);
		this.participante4 = Mockito.mock(Participante.class);
		this.participante5 = Mockito.mock(Participante.class);
		this.participante6 = Mockito.mock(Participante.class);
				
	}

	@Test
	void testUnServidorDeJuegoSinIniciar_PuedeAgregarUnParticipante() throws Exception {
		servidor.unirParticipante(participante1);

		assertEquals(servidor.getEstado().getClass(), EsperandoParaIniciar.class);
		
		//Acá compruebo que si bien el participante se unió, no se le otorgaron preguntas porque 
		//la partida no está llena
		assertEquals(servidor.getParticipantes().size(), 1);
		Mockito.verify(participante1, Mockito.never()).unirseALaPartida(servidor);
		// Compruebo que si bien el participante está en la partida, la partida nunca comenzó y no se le otorgaron las preguntas
	}
	
	@Test
	void testUnServidorDeJuegoCon5Jugadores_CambiaSuEstadoAJuegoEnProceso() throws Exception {
		servidor.unirParticipante(participante1);
		servidor.unirParticipante(participante2);
		servidor.unirParticipante(participante3);
		servidor.unirParticipante(participante4);
		servidor.unirParticipante(participante5);
	
		assertEquals(servidor.getParticipantes().size(), 5);
		
		assertEquals(servidor.getEstado().getClass(), JuegoEnProceso.class);
		
		Mockito.verify(participante1, Mockito.times(1)).unirseALaPartida(servidor);
		// Compruebo que cuando están los 5 participantes, todos reciben la notificación de que se unieron a la partida
		// y reciben las preguntas
	}

	@Test
	void testUnServidorDeJuegoCon5Jugadores_LevantaUnaExcepcionCuandoSolicitaUnirseOtro() throws Exception {
		servidor.unirParticipante(participante1);
		servidor.unirParticipante(participante2);
		servidor.unirParticipante(participante3);
		servidor.unirParticipante(participante4);
		servidor.unirParticipante(participante5);
		
		assertThrows(RuntimeException.class, () -> servidor.unirParticipante(participante6));	
		Mockito.verify(participante6, Mockito.never()).unirseALaPartida(servidor);
	}
	
	@Test
	void testCuandoUnJugadorAdivinaUnaPregunta_PasaALaSiguienteYLosJugadoresSonNotificados() throws Exception {
		servidor.unirParticipante(participante1);
		servidor.unirParticipante(participante2);
		servidor.unirParticipante(participante3);
		servidor.unirParticipante(participante4);
		servidor.unirParticipante(participante5);
		
		servidor.responderPregunta("1", "Z", participante1); // Responde la primer pregunta
		
		Mockito.verify(participante1, Mockito.times(1)).pasarASiguientePregunta();
		assertEquals(servidor.getPuntajes().get(participante1), 1);
	}
	
	@Test
	void testCuandoUnJugadorRespondeIncorrectamenteUnaPregunta_EsNotificadoYLosOtrosJugadoresNo() throws Exception {
		servidor.unirParticipante(participante1);
		servidor.unirParticipante(participante2);
		servidor.unirParticipante(participante3);
		servidor.unirParticipante(participante4);
		servidor.unirParticipante(participante5);
		
		servidor.responderPregunta("1", "J", participante1); 
		
		Mockito.verify(participante1, Mockito.never()).pasarASiguientePregunta();
		assertEquals(servidor.getPuntajes().get(participante1), 0);
	}
	
	@Test
	void testCuandoUnJugadorRespondeCorrectamenteLas5Preguntas_EsElGanadorYFinalizaElJuego() throws Exception {
		servidor.unirParticipante(participante1);
		servidor.unirParticipante(participante2);
		servidor.unirParticipante(participante3);
		servidor.unirParticipante(participante4);
		servidor.unirParticipante(participante5);
		
		servidor.responderPregunta("1", "Z", participante1); 
		servidor.responderPregunta("2", "Y", participante1); 
		servidor.responderPregunta("3", "X", participante1);
		servidor.responderPregunta("4", "W", participante1); 
		servidor.responderPregunta("5", "V", participante1);  
		
		Mockito.verify(participante1, Mockito.times(5)).pasarASiguientePregunta();
		assertEquals(servidor.getPuntajes().get(participante1), 5);
		assertEquals(servidor.getEstado().getClass(), JuegoTerminado.class);		
	}
	
	@Test
	void testCuandoUnJuegoEstaTerminadoYSeUneUnParticipante_LanzaUnaExcepcion() throws Exception {
		servidor.unirParticipante(participante1);
		servidor.unirParticipante(participante2);
		servidor.unirParticipante(participante3);
		servidor.unirParticipante(participante4);
		servidor.unirParticipante(participante5);
		
		servidor.responderPregunta("1", "Z", participante1); 
		servidor.responderPregunta("2", "Y", participante1); 
		servidor.responderPregunta("3", "X", participante1);
		servidor.responderPregunta("4", "W", participante1); 
		servidor.responderPregunta("5", "V", participante1); 
		
		assertThrows(RuntimeException.class, () -> servidor.unirParticipante(participante6));	
	}
	
	@Test
	void testCuandoUnJuegoEstaTerminadoYUnParticipanteResponde_LanzaUnaExcepcion() throws Exception {
		servidor.unirParticipante(participante1);
		servidor.unirParticipante(participante2);
		servidor.unirParticipante(participante3);
		servidor.unirParticipante(participante4);
		servidor.unirParticipante(participante5);
		
		servidor.responderPregunta("1", "Z", participante1); 
		servidor.responderPregunta("2", "Y", participante1); 
		servidor.responderPregunta("3", "X", participante1);
		servidor.responderPregunta("4", "W", participante1); 
		servidor.responderPregunta("5", "V", participante1); 
		
		assertThrows(RuntimeException.class, () -> servidor.responderPregunta("5", "V", participante3));	
	}
}
