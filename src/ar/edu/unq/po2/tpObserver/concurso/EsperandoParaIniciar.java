package ar.edu.unq.po2.tpObserver.concurso;

public class EsperandoParaIniciar extends EstadoDeServidor {
	
	public EsperandoParaIniciar() {}

	@Override
	public void unirParticipante(ServidorDeJuego servidor, IParticipante participante) {
		if(servidor.getParticipantes().size() == 4) {
			servidor.agregarParticipante(participante);
			servidor.otorgarPreguntasAParticipantes();
			servidor.setEstado(new JuegoEnProceso());
		} else {
			servidor.agregarParticipante(participante);
		}
	}

	@Override
	public void verificarRespuesta(String pregunta, String respuesta, IParticipante participante,
			ServidorDeJuego servidor) {
		throw new RuntimeException("El juego no está iniciado");		
	}

	@Override
	protected void finalizarJuego(ServidorDeJuego servidor) {
		throw new RuntimeException("El juego no está iniciado");	
	}
	
	
}
