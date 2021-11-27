package ar.edu.unq.po2.tpStateStrategy.encriptacion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncriptadorPorNumero extends EncriptadorNaive {

	private Map<String, String> encriptacionNumericaAAlbafetica;
	private Map<String, String> encriptacionAlfabeticaANumerica;
	
	public EncriptadorPorNumero() {
		this.encriptacionNumericaAAlbafetica = new HashMap<String, String>();
		this.encriptacionAlfabeticaANumerica = new HashMap<String, String>();
		
		encriptacionNumericaAAlbafetica.put("0", " ");
		encriptacionNumericaAAlbafetica.put("1", "a");
		encriptacionNumericaAAlbafetica.put("2", "b");
		encriptacionNumericaAAlbafetica.put("3", "c");
		encriptacionNumericaAAlbafetica.put("4", "d");
		encriptacionNumericaAAlbafetica.put("5", "e");
		encriptacionNumericaAAlbafetica.put("6", "f");
		encriptacionNumericaAAlbafetica.put("7", "g");
		encriptacionNumericaAAlbafetica.put("8", "h");
		encriptacionNumericaAAlbafetica.put("9", "i");
		encriptacionNumericaAAlbafetica.put("10", "j");
		encriptacionNumericaAAlbafetica.put("11", "k");
		encriptacionNumericaAAlbafetica.put("12", "l");
		encriptacionNumericaAAlbafetica.put("13", "m");
		encriptacionNumericaAAlbafetica.put("14", "n");
		encriptacionNumericaAAlbafetica.put("15", "o");
		encriptacionNumericaAAlbafetica.put("16", "p");
		encriptacionNumericaAAlbafetica.put("17", "q");
		encriptacionNumericaAAlbafetica.put("18", "r");
		encriptacionNumericaAAlbafetica.put("19", "s");
		encriptacionNumericaAAlbafetica.put("20", "t");
		encriptacionNumericaAAlbafetica.put("21", "u");
		encriptacionNumericaAAlbafetica.put("22", "v");
		encriptacionNumericaAAlbafetica.put("23", "w");
		encriptacionNumericaAAlbafetica.put("24", "x");
		encriptacionNumericaAAlbafetica.put("25", "y");
		encriptacionNumericaAAlbafetica.put("26", "z");	
		
		encriptacionAlfabeticaANumerica.put(" ", "0");
		encriptacionAlfabeticaANumerica.put("a", "1");
		encriptacionAlfabeticaANumerica.put("b", "2");
		encriptacionAlfabeticaANumerica.put("c", "3");
		encriptacionAlfabeticaANumerica.put("d", "4");
		encriptacionAlfabeticaANumerica.put("e", "5");
		encriptacionAlfabeticaANumerica.put("f", "6");
		encriptacionAlfabeticaANumerica.put("g", "7");
		encriptacionAlfabeticaANumerica.put("h", "8");
		encriptacionAlfabeticaANumerica.put("i", "9");
		encriptacionAlfabeticaANumerica.put("j", "10");
		encriptacionAlfabeticaANumerica.put("k", "11");
		encriptacionAlfabeticaANumerica.put("l", "12");
		encriptacionAlfabeticaANumerica.put("m", "13");
		encriptacionAlfabeticaANumerica.put("n", "14");
		encriptacionAlfabeticaANumerica.put("o", "15");
		encriptacionAlfabeticaANumerica.put("p", "16");
		encriptacionAlfabeticaANumerica.put("q", "17");
		encriptacionAlfabeticaANumerica.put("r", "18");
		encriptacionAlfabeticaANumerica.put("s", "19");
		encriptacionAlfabeticaANumerica.put("t", "20");
		encriptacionAlfabeticaANumerica.put("u", "21");
		encriptacionAlfabeticaANumerica.put("v", "22");
		encriptacionAlfabeticaANumerica.put("w", "23");
		encriptacionAlfabeticaANumerica.put("x", "24");
		encriptacionAlfabeticaANumerica.put("y", "25");
		encriptacionAlfabeticaANumerica.put("z", "26");
		
		// tampoco pude utilizar enum
	}
	
	
	@Override
	public String encriptar(String texto) {
		char[] characters = texto.toCharArray();
		
		String newText = "";
		
		for(char character : characters) {
			newText += this.encriptacionAlfabeticaANumerica.get(Character.toString(character)) 	+ ",";
		}
		
		return newText.substring(0, newText.length()-1); // para eliminar la ultima coma
	}
	

	@Override
	public String desencriptar(String texto) {
		List<String> palabras = Arrays.asList(texto.split(","));
		
		String newText = "";
		
		for(String palabra : palabras) {
			newText += this.encriptacionNumericaAAlbafetica.get(palabra);
		}
		
		return newText;
	}

}
