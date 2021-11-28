package ar.edu.unq.po2.tpObserver.concurso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServidorDeJuego {
	private ArrayList<String> preguntas;
	private Map<String, String> respuestas;
	private ArrayList<IParticipante> participantes;
	private Map<IParticipante, Integer> puntajes;
	private EstadoDeServidor estado;
	
	public ServidorDeJuego(Map<String, String> respuestas) {
		this.setRespuestas(respuestas);
		this.setParticipantes(new ArrayList<IParticipante>());
		this.setPreguntas(new ArrayList<String>(respuestas.keySet()));
		this.setEstado(new EsperandoParaIniciar());
		this.setPuntajes(new HashMap<IParticipante, Integer>());
	}
	
	public void unirParticipante(Participante participante) throws Exception {
		this.getEstado().unirParticipante(this, participante);		
	}
	
	public void agregarParticipante(IParticipante participante) {
		this.getParticipantes().add(participante);
		this.getPuntajes().put(participante, 0);
	}
	
	public void notificar(IParticipante participante, String string) {
		participante.agregarNotificacion(string);	
	}

	public boolean esRespuestaCorrecta(String pregunta, String respuesta) {
		return this.getRespuestas().get(pregunta).equals(respuesta);
	}
	
	public void sumarPuntajeAParticipante(IParticipante participante) throws Exception {
		int puntajeActual = this.getPuntajes().get(participante);
		this.getPuntajes().put(participante, puntajeActual+1);
		
		if(this.esGanador(participante)) {
			this.finalizarJuego();
			this.notificarATodosElGanador(participante);
		}
	}
	
	private void notificarATodosElGanador(IParticipante participante) {
		for(IParticipante p : this.getParticipantes()) {
			p.agregarNotificacion("El ganador es " + participante.getNombre() + ". Juego finalizado");
		}
	}
	
	public void notificarRespuestaCorrectaDe(IParticipante participante, String pregunta) {
		for(IParticipante p : this.getParticipantes()) {
			p.agregarNotificacion("El participante " + participante.getNombre() + " respondió bien la pregunta " + pregunta);
		}
	}

	private void finalizarJuego() throws Exception {
		this.getEstado().finalizarJuego(this);		
	}

	private boolean esGanador(IParticipante participante) {
		return this.getPuntajes().get(participante) == 5;
	}
	
	public void responderPregunta(String pregunta, String respuesta, IParticipante participante) throws Exception {
		this.getEstado().verificarRespuesta(pregunta, respuesta, participante, this);		
	}

	public Map<IParticipante, Integer> getPuntajes() {
		return puntajes;
	}

	public void setPuntajes(Map<IParticipante, Integer> puntajes) {
		this.puntajes = puntajes;
	}

	public EstadoDeServidor getEstado() {
		return estado;
	}

	public void setEstado(EstadoDeServidor estado) {
		this.estado = estado;
	}

	public ArrayList<String> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(ArrayList<String> preguntas) {
		this.preguntas = preguntas;
	}

	public Map<String, String> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Map<String, String> respuestas) {
		this.respuestas = respuestas;
	}

	public ArrayList<IParticipante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<IParticipante> arrayList) {
		this.participantes = arrayList;
	}

	public void otorgarPreguntasAParticipantes() {
		for(IParticipante p : this.getParticipantes()) {
			p.unirseALaPartida(this);
		}
	}
}
