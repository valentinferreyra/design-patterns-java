package ar.edu.unq.po2.tpObserver.concurso;

public abstract class EstadoDeServidor {

	public abstract void unirParticipante(ServidorDeJuego servidor, IParticipante participante);
	public abstract void verificarRespuesta(String pregunta, String respuesta, IParticipante participante, ServidorDeJuego servidor) throws Exception;
	protected abstract void finalizarJuego(ServidorDeJuego servidor);
	
}
