package ar.edu.unq.po2.tp4;

public class ProductoPrimeraNecesidad extends Producto {

	public ProductoPrimeraNecesidad(String nombre, Double precio) {
		super(nombre, precio);
	}
	
	public ProductoPrimeraNecesidad(String nombre, Double precio, boolean esPrecioCuidado) {
		super(nombre, precio, esPrecioCuidado);
	}
	
	@Override
	public double getPrecio() {
		return this.aplicarDescuento(super.getPrecio());
	}
	
	private double aplicarDescuento(double precio) {
		return precio * 0.9;
	}

}
