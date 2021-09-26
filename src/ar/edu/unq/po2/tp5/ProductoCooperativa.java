package ar.edu.unq.po2.tp5;

public class ProductoCooperativa extends Producto {

	public ProductoCooperativa(double precio, int stock) {
		super(precio, stock);
	}
	
	@Override
	public double getPrecio() {
		return super.getPrecio() * 0.9;
	}
}
