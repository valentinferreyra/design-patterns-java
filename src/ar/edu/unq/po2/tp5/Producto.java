package ar.edu.unq.po2.tp5;

public class Producto implements Pagable {

	private double precio;
	private int stock;
	
	public Producto(double precio, int stock) {
		super();
		this.setPrecio(precio);
		this.setStock(stock);
	}

	private void setPrecio(double precio) {
		this.precio = precio;
	}

	private void setStock(int stock) {
		this.stock = stock;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public void decrementarStockEn(int unaCantidad) {
		int nuevaCantidad = this.stock - unaCantidad;
		this.setStock(nuevaCantidad);
	}

	public double realizarPago() {
		this.decrementarStockEn(1);
		
		return this.getPrecio();
	}
}
