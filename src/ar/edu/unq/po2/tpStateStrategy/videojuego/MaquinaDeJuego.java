package ar.edu.unq.po2.tpStateStrategy.videojuego;

public class MaquinaDeJuego {
	
	private int fichas;
	private MaquinaState state;
	private BotonDeJuego botonDeJuego;
	
	public MaquinaDeJuego() {
		this.setState(new MaquinaEstadoEncendida()); // en estado neutro
		this.setBotonDeJuego(new BotonDeJuego()); // inicialmente desactivada
		this.setFichas(0);
	}
	
	public void ingresarFicha() {
		this.getState().ingresarFicha(this);
	}
	
	public void finalizarJuego() {
		this.getState().finalizarJuego(this);
	}

	public boolean tieneBotonesActivados() {
		return this.getBotonDeJuego().estaActivo();
	}

	public void activarBotones() {
		this.getBotonDeJuego().activar();
	}

	public void desactivarBotones() {
		this.getBotonDeJuego().desactivar();		
	}
	
	public void resetearFichas() {
		this.setFichas(0);
	}
	
	public int getFichas() {
		return fichas;
	}

	public void setFichas(int fichas) {
		this.fichas = fichas;
	}

	public MaquinaState getState() {
		return state;
	}

	public void setState(MaquinaState state) {
		this.state = state;
	}

	public BotonDeJuego getBotonDeJuego() {
		return botonDeJuego;
	}

	public void setBotonDeJuego(BotonDeJuego botonDeJuego) {
		this.botonDeJuego = botonDeJuego;
	}

	public void agregarFicha() {
		this.fichas++;		
	}
}
