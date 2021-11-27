package ar.edu.unq.po2.tpStateStrategy.reproductormp3;

public class EstadoReproduciendoCancion extends ReproductorState {
	
	public EstadoReproduciendoCancion() {
	}

	@Override
	public void play(ReproductorDeMusica reproductor) {
		throw new RuntimeException("Se está reproduciendo la canción");
	}

	@Override
	public void pause(ReproductorDeMusica reproductor) {
		reproductor.getCancionSeleccionada().pause();
		reproductor.setState(new EstadoPausaDeCancion());
	}

	@Override
	public void stop(ReproductorDeMusica reproductor) {
		reproductor.getCancionSeleccionada().stop();
		reproductor.setState(new EstadoSeleccionDeCanciones());

	}

}
