package ar.edu.unq.po2.tpObserver.concurso;

import java.util.ArrayList;

public class Participante implements IParticipante {
	
	private String nombre;
	private ArrayList<String> preguntas;
	private int preguntaActual;
	private ArrayList<String> notificaciones;
	private ServidorDeJuego servidor;

	public Participante(String nombre) {
		this.nombre = nombre;
		this.setPreguntas(new ArrayList<String>());
		this.setNotificaciones(new ArrayList<String>());
	}
	
	@Override
	public void solicitarUnirse(ServidorDeJuego servidor) throws Exception {
		servidor.unirParticipante(this);		
	}

	@Override
	public void unirseALaPartida(ServidorDeJuego servidor) {
		this.setPreguntas(servidor.getPreguntas());
		this.setPreguntaActual(0);
		this.setServidor(servidor);
	}

	@Override
	public void agregarNotificacion(String notificacion) {
		this.getNotificaciones().add(notificacion);
	}

	@Override
	public void pasarASiguientePregunta() {
		this.preguntaActual++;
	}
	
	@Override
	public void contestarPregunta(String respuesta) throws Exception {
		if(this.getServidor() == null) {
			throw new RuntimeException("El jugador no está registrado");
		} else {
			String pregunta = this.getPreguntas().get(preguntaActual);
			this.getServidor().responderPregunta(pregunta, respuesta, this);
		}
	}
	
	public ArrayList<String> getPreguntas() {
		return preguntas;
	}

	public ServidorDeJuego getServidor() {
		return servidor;
	}

	public void setServidor(ServidorDeJuego servidor) {
		this.servidor = servidor;
	}

	public void setPreguntas(ArrayList<String> preguntas) {
		this.preguntas = preguntas;
	}

	public int getPreguntaActual() {
		return preguntaActual;
	}

	public void setPreguntaActual(int numeroDePreguntasRespondidas) {
		this.preguntaActual = numeroDePreguntasRespondidas;
	}

	public ArrayList<String> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(ArrayList<String> notificaciones) {
		this.notificaciones = notificaciones;
	}

	public String getNombre() {
		return nombre;
	}	
}
