package ar.edu.unq.po2.tpStateStrategy.reproductormp3;

public class EstadoPausaDeCancion extends ReproductorState {

	public EstadoPausaDeCancion() {
	}
	
	@Override
	public void play(ReproductorDeMusica reproductor) {
		throw new RuntimeException("Ya tenés una cancion seleccionada");
	}

	@Override
	public void pause(ReproductorDeMusica reproductor) {
		reproductor.getCancionSeleccionada().play();
		reproductor.setState(new EstadoReproduciendoCancion());
	}

	@Override
	public void stop(ReproductorDeMusica reproductor) {
		reproductor.getCancionSeleccionada().stop();
		reproductor.setState(new EstadoSeleccionDeCanciones());
	}

}
