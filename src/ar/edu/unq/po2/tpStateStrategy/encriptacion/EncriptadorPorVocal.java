package ar.edu.unq.po2.tpStateStrategy.encriptacion;

public class EncriptadorPorVocal extends EncriptadorNaive {
		
	@Override
	public String encriptar(String texto) {
	
		texto = texto.replace("u", "a").replace("o", "u")
				.replace("i", "o")
				.replace("e", "i").replace("a", "e");
		return texto;
	}
	
	@Override
	public String desencriptar(String texto) {
		
		texto = texto.replace("e", "a").replace("i", "e")
				.replace("o", "i")
				.replace("u", "o").replace("u", "a");
		return texto;
	}
	
	// No logré hacerlo con ENUM

}
