package ar.edu.unq.po2.tpStateStrategy.encriptacion;

public class EncriptadorUser {
	
	EncriptadorNaive estrategia;

	public EncriptadorUser(EncriptadorNaive estrategia) {
		super();
		this.estrategia = estrategia;
	}
	
	public String encriptar(String texto) {
		return estrategia.encriptar(texto);
	}
	
	public String desencriptar(String texto) {
		return estrategia.desencriptar(texto);
	}

}
