package ar.edu.unq.po2.tpTestDoubles;

public enum NumeroDeCarta {	
	DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE, DIEZ, J, Q, K, A;

	boolean esMayorQue(NumeroDeCarta numero) {
		return this.ordinal() > numero.ordinal();
	}
}
