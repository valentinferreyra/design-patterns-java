package ar.edu.unq.po2.tpTestDoubles;

public class Carta {

	NumeroDeCarta numero;
	ColorDeCarta color;

	public Carta(NumeroDeCarta numero, ColorDeCarta color) {
		this.setNumero(numero);
		this.setColor(color);
	}

	public NumeroDeCarta getNumero() {
		return numero;
	}

	public void setNumero(NumeroDeCarta numero) {
		this.numero = numero;
	}

	public ColorDeCarta getColor() {
		return color;
	}

	public void setColor(ColorDeCarta color) {
		this.color = color;
	}

	/**
	 * @param carta: una Carta que representa una carta de poquer
	 * @return booleano que indica si el numero de la carta es mayor que la pasada por parámetro
	 */
	public boolean elValorEsMayorQue(Carta carta) {
		return this.getNumero().esMayorQue(carta.getNumero());
	}

	/**
	 * @param carta: una Carta que representa una carta de poquer
	 * @return booleano que indica si la carta actual y el pasado por parámetro son del mismo palo
	 */
	public boolean esMismoPaloQue(Carta carta) {
		return this.getColor().esMismoColorQue(carta.getColor());
	}
}
