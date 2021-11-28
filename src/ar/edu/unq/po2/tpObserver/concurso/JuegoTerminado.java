package ar.edu.unq.po2.tpObserver.concurso;

public class JuegoTerminado extends EstadoDeServidor {

	@Override
	public void unirParticipante(ServidorDeJuego servidor, IParticipante participante) {
		throw new RuntimeException("El juego está finalizado");
	}

	@Override
	public void verificarRespuesta(String pregunta, String respuesta, IParticipante participante,
			ServidorDeJuego servidor) {
		throw new RuntimeException("El juego está finalizado");
	}

	@Override
	protected void finalizarJuego(ServidorDeJuego servidor) {
		throw new RuntimeException("El juego está finalizado");
	}

}
