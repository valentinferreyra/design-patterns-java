package ar.edu.unq.po2.tpStateStrategy.reproductormp3;

public abstract class ReproductorState {

	public abstract void play(ReproductorDeMusica reproductor);
	public abstract void pause(ReproductorDeMusica reproductor);
	public abstract void stop(ReproductorDeMusica reproductor);
	
}
