package ar.edu.unq.po2.tpStateStrategy.videojuego;

public class MaquinaEstadoEncendida extends MaquinaState {
	
	public MaquinaEstadoEncendida() {
		super();
	}

	@Override
	public void botonDeInicio(MaquinaDeJuego maquina) {
		// Se muestra en pantalla que se ingresen fichas
	}

	@Override
	public void ingresarFicha(MaquinaDeJuego maquina) {
		// Se muetra en pantalla que el juego se ha iniciado
		maquina.activarBotones();
		maquina.agregarFicha();
		maquina.setState(new MaquinaEstadoUnJugador());
	}

	@Override
	public void finalizarJuego(MaquinaDeJuego maquina) {
		// Se muestra en pantalla que no se puede finalizar un juego que no ha comenzado
		
	}

}
