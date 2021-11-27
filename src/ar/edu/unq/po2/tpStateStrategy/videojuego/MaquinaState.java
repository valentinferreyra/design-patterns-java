package ar.edu.unq.po2.tpStateStrategy.videojuego;

public abstract class MaquinaState {

	public abstract void botonDeInicio(MaquinaDeJuego maquina);
	public abstract void ingresarFicha(MaquinaDeJuego maquina);
	public abstract void finalizarJuego(MaquinaDeJuego maquina);
	
}
