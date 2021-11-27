package ar.edu.unq.po2.tpStateStrategy.encriptacion;

public enum Vocal {

	a, e, i, o, u;
	
	
	public Vocal siguiente() {
		int indice;
		
		//Se utiliza el if para el caso borde que la vocal sea la última
		if(this.ordinal()==Vocal.values().length-1) 
			indice = 1;
		else
			indice = this.ordinal()+1;
		
		return Vocal.values()[indice];
	}

	public Vocal anterior() {
		
		int indice;
		
		if(this.ordinal()==1) 
			indice = Vocal.values().length-1;
		else
			indice = this.ordinal()-1;
		
		return Vocal.values()[indice];
	}
}
