package ar.edu.unq.po2.tp6;

public enum Deporte {
	
	RUNNING(1), FUTBOL(2), BASKET(2), TENNIS(3), JABALINA(4);
	
	int nivelComplejidad;
	
	private Deporte(int nivelComplejidad) {
		this.nivelComplejidad = nivelComplejidad;
	}
	
	public int getComplejidad() {
		return this.nivelComplejidad;
	}

}
