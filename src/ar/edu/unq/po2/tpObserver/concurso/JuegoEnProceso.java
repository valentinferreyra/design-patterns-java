package ar.edu.unq.po2.tpObserver.concurso;

public class JuegoEnProceso extends EstadoDeServidor {
	
	public JuegoEnProceso() {}

	@Override
	public void unirParticipante(ServidorDeJuego servidor, IParticipante participante) {
		throw new RuntimeException("El juego está en proceso, espere a la siguiente partida");
	}

	@Override
	public void verificarRespuesta(String pregunta, String respuesta, IParticipante participante,
			ServidorDeJuego servidor) throws Exception {
		if(servidor.esRespuestaCorrecta(pregunta, respuesta)) {
			participante.pasarASiguientePregunta();
			servidor.sumarPuntajeAParticipante(participante);
			servidor.notificarRespuestaCorrectaDe(participante, pregunta);
		} else {
			servidor.notificar(participante, "Respuesta incorrecta, vuelve a intentarlo");				
		}
	}

	@Override
	protected void finalizarJuego(ServidorDeJuego servidor) {
		servidor.setEstado(new JuegoTerminado());
	}

}
