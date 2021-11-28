package ar.edu.unq.po2.tpObserver.concurso;

public interface IParticipante {
	
	public void solicitarUnirse(ServidorDeJuego servidor) throws Exception;
	public void unirseALaPartida(ServidorDeJuego servidor);
	public void agregarNotificacion(String notificacion);
	public void pasarASiguientePregunta();
	public void contestarPregunta(String respuesta) throws Exception;
	public String getNombre();

}
