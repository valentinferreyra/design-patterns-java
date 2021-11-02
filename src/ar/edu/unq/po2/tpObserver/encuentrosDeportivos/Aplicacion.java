package ar.edu.unq.po2.tpObserver.encuentrosDeportivos;

import java.util.ArrayList;
import java.util.List;

public class Aplicacion {
	
	private List<Partido> partidos;
	private List<ISportListener> listeners;
	
	public Aplicacion() {
		this.setListeners(new ArrayList<ISportListener>());
		this.setPartidos(new ArrayList<Partido>());
	}
	
	public void agregarPartido(Partido partido) {
		this.getPartidos().add(partido);
		this.notificarNuevoPartido(partido);
	}
	
	private void notificarNuevoPartido(Partido partido) {
		for(ISportListener listener : this.getListeners()) {
			listener.registrarNuevoPartido(partido);
		}	
	}

	public void addListener(ISportListener listener) {
		this.getListeners().add(listener);
	}
	
	public List<Partido> getPartidos() {
		return partidos;
	}
	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}
	public List<ISportListener> getListeners() {
		return listeners;
	}
	public void setListeners(List<ISportListener> listeners) {
		this.listeners = listeners;
	}
	
	

}
