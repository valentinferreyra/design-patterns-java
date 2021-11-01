package ar.edu.unq.po2.tpObserver.publicaciones;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	
	private List<Articulo> articulos;
	private List<ISistemaListener> listeners;
	
	public Sistema(List<Articulo> articulos) {
		this.setArticulos(articulos);
		
		for (Articulo art : articulos) {
			this.notificarNuevoArticulo(art);
		}
	}

	public Sistema() {
		this.setArticulos(new ArrayList<Articulo>());
		this.setListeners(new ArrayList<ISistemaListener>());
	}

	private void notificarNuevoArticulo(Articulo articulo) {
		for (ISistemaListener listener : this.getListeners()) {
			listener.nuevoArticuloPublicado(articulo);
		}
	}
	
	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
	
	public List<ISistemaListener> getListeners() {
		return listeners;
	}

	public void setListeners(List<ISistemaListener> listeners) {
		this.listeners = listeners;
	}
	
	public void addArticle(Articulo articulo) {
		this.getArticulos().add(articulo);
		this.notificarNuevoArticulo(articulo);
	}
	
	public void suscribirListener(ISistemaListener newListener) {
		this.getListeners().add(newListener);
	}

}
