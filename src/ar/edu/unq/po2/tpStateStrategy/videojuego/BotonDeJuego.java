package ar.edu.unq.po2.tpStateStrategy.videojuego;

public class BotonDeJuego {
	
	private boolean estaActivo;
	
	public BotonDeJuego() {
		this.estaActivo = false;
	}

	public void activar() {
		this.estaActivo = true;
	}

	public void desactivar() {
		this.estaActivo = false;	
	}

	public boolean estaActivo() {
		return estaActivo;
	}

}
