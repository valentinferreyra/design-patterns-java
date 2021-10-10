package ar.edu.unq.po2.tp6;

public enum LesionDermatologica {
	ROJO("Severo", 9), GRIS("Grave", 7), AMARILLO("Muy alto", 6), MIEL("Alto", 4);
	
	String descripcion;
	int nivelDeRiesgo;
	
	private LesionDermatologica(String descripcion, int nivelDeRiesgo) {
		this.descripcion = descripcion;
		this.nivelDeRiesgo = nivelDeRiesgo;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public int getNivelDeRiesgo() {
		return this.nivelDeRiesgo;
	}
	
	public LesionDermatologica getProximoColor() {
		
		LesionDermatologica[] lesiones = LesionDermatologica.values();
		int proximoIndice = this.ordinal() + 1;
		
		if (proximoIndice > (lesiones.length - 1)) { // resto 1 porque inicia en 0
			proximoIndice = 0;
		} 
		
		return lesiones[proximoIndice];
	}
}
