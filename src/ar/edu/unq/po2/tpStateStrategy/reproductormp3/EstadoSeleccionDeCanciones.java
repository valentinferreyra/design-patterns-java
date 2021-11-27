package ar.edu.unq.po2.tpStateStrategy.reproductormp3;

public class EstadoSeleccionDeCanciones extends ReproductorState {
	
	public EstadoSeleccionDeCanciones() {
		
	}

	@Override
	public void play(ReproductorDeMusica reproductor) {
		reproductor.getCancionSeleccionada().play();
		reproductor.setState(new EstadoReproduciendoCancion());
	}

	@Override
	public void pause(ReproductorDeMusica reproductor) {
		throw new RuntimeException("No se está reproduciendo nada");
	}

	@Override
	public void stop(ReproductorDeMusica reproductor) {
		// No hace nada
	}

}
