package ar.edu.unq.po2.tpTestDoubles;

public enum NumeroDeCarta {	
	UNO, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE, DIEZ, K, Q, J;

	boolean esMayorQue(NumeroDeCarta numero) {
		return this.ordinal() > numero.ordinal();
	}
}
