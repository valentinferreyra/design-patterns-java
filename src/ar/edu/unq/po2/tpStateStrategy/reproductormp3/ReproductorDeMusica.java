package ar.edu.unq.po2.tpStateStrategy.reproductormp3;

public class ReproductorDeMusica {
	
	private Song cancionSeleccionada;
	private ReproductorState state;
	
	public ReproductorDeMusica() {
		this.setState(new EstadoSeleccionDeCanciones());
	}
	
	public void playMusic() {
		this.getState().play(this);
	}
	
	public void pauseMusic() {
		this.getState().pause(this);
	}
	
	public void stopMusic() {
		this.getState().stop(this);
	}
	
	public void seleccionarCancion(Song cancion) {
		this.setCancionSeleccionada(cancion);
	}

	public Song getCancionSeleccionada() {
		return cancionSeleccionada;
	}

	public void setCancionSeleccionada(Song cancionSeleccionada) {
		this.cancionSeleccionada = cancionSeleccionada;
	}

	public ReproductorState getState() {
		return state;
	}

	public void setState(ReproductorState state) {
		this.state = state;
	}

}
