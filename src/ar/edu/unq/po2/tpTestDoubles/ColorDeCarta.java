package ar.edu.unq.po2.tpTestDoubles;

public enum ColorDeCarta {
	
	PICAS, CORAZONES, DIAMANTES, TREBOLES;

	boolean esMismoColorQue(ColorDeCarta color) {
		return this.ordinal() == color.ordinal();
	} 

}
