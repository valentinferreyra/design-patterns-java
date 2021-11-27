package ar.edu.unq.po2.tpStateStrategy.videojuego;

public class MaquinaEstadoUnJugador extends MaquinaState {
	
	public MaquinaEstadoUnJugador() {
	}

	@Override
	public void botonDeInicio(MaquinaDeJuego maquina) {
		// No hace nada
	}

	@Override
	public void ingresarFicha(MaquinaDeJuego maquina) {
		// Se ingresa nueva ficha, el juego ahora es de dos jugadores
		maquina.setState(new MaquinaEstadoDosJugadores());
		maquina.agregarFicha();
	}

	@Override
	public void finalizarJuego(MaquinaDeJuego maquina) {
		// Se finaliza el juego para un juegador
		maquina.desactivarBotones();
		// Se muestra en pantalla el resultado
		maquina.setState(new MaquinaEstadoEncendida());
		maquina.resetearFichas();
	}

}
