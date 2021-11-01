package ar.edu.unq.po2.tpObserver.publicaciones;

public interface ISistemaListener {

	public void suscribir(Sistema sistema);
	public void nuevoArticuloPublicado(Articulo articulo);
	
}
