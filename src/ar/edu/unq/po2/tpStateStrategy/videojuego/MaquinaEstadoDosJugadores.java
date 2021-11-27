package ar.edu.unq.po2.tpStateStrategy.videojuego;

public class MaquinaEstadoDosJugadores extends MaquinaState {
	
	public void MaquinaEstadoDosJuegadores() {
	}

	@Override
	public void botonDeInicio(MaquinaDeJuego maquina) {
		// No hace nada

	}

	@Override
	public void ingresarFicha(MaquinaDeJuego maquina) {
		// Muestra en pantalla que se ha alcanzada el número maximo de juegadores
		// Se devuelve la ficha

	}

	@Override
	public void finalizarJuego(MaquinaDeJuego maquina) {
		// Se muestra en pantalla el resultado
		maquina.setState(new MaquinaEstadoEncendida());
		maquina.desactivarBotones();
		maquina.resetearFichas();
	}
}
