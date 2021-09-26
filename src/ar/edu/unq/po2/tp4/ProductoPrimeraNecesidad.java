package ar.edu.unq.po2.tp4;

public class ProductoPrimeraNecesidad extends Producto {
	
	private int descuento;

	public ProductoPrimeraNecesidad(String nombre, Double precio, int descuento) {
		super(nombre, precio);
		this.setDescuento(descuento);
	}
	
	public ProductoPrimeraNecesidad(String nombre, Double precio, boolean esPrecioCuidado, int descuento) {
		super(nombre, precio, esPrecioCuidado);
		this.setDescuento(descuento);
	}
	
	private void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	@Override
	public double getPrecio() {
		double descuentoTotal = (super.getPrecio() * this.descuento) / 100;
		
		return (super.getPrecio() - descuentoTotal);
	}

}
