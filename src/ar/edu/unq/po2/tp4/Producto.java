package ar.edu.unq.po2.tp4;

public class Producto {
	
	private String nombre;
	private double precio;
	private boolean esPrecioCuidado = false;
	
	public Producto(String nombre, double precio) {
		/**
		 * Constructor de producto
		 * @param nombre: indica el nombre del producto
		 * @param precio: indica el precio del producto
		 */
		
		this.setNombre(nombre);
		this.setPrecio(precio);
	}	
	
	public Producto(String nombre, double precio, boolean esPC) {
		/**
		 * Constructor de producto
		 * @param nombre: indica el nombre del producto
		 * @param precio: indica el precio del producto
		 * @param esPC: indica si el producto es parte del programa Precios Cuidados
		 */
		
		this.setNombre(nombre);
		this.setPrecio(precio);
		this.setEsPC(esPC);
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	private void setPrecio(double precio) {
		this.precio = precio;
	}
	
	private void setEsPC(boolean esPC) {
		this.esPrecioCuidado = esPC;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public boolean esPrecioCuidado() {
		return this.esPrecioCuidado;
	}

	public void aumentarPrecio(double precioAumento) {
		double nuevoPrecio = this.precio + precioAumento;
		this.setPrecio(nuevoPrecio);
	}
}
