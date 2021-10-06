package ar.edu.unq.po2.tp4;

import java.util.ArrayList;

import java.util.List;

public class Supermercado {

	private String nombre;
	private String direccion;
	private List<Producto> listaDeProductos = new ArrayList<Producto>();
	
	public Supermercado() {
	}
	
	public Supermercado(String nombre, String direccion) {
		/**
		 * @param nombre: string que representa el nombre de una Supermercado
		 * @param direccion: la dirección del Supermercado
		 */
		this.setNombre(nombre);
		this.setDireccion(direccion);
	}
	
	public Supermercado(String nombre, String direccion, List<Producto> productos) {
		/**
		 * @param nombre: string que representa el nombre de una Supermercado
		 * @param direccion: la dirección del Supermercado
		 * @param productos: ArrayList de productos con el que se inicializa el Supermercado
		 */
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setListaDeProductos(productos);
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	private void setListaDeProductos(List<Producto> productos) {
		this.listaDeProductos = productos;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	public int getCantidadDeProductos() {
		return listaDeProductos.size();
	}
	
	public void agregarProducto(Producto producto) {
		this.listaDeProductos.add(producto);
	}
	
	public double getPrecioTotal() {
		/**
		 * Obtiene el precio total que resulta de sumar todos los precios
		 * de los productos de la lista
		 */
		double precioTotal = 0;
		
		for(Producto p : this.listaDeProductos) {
			precioTotal += p.getPrecio();
		}
		
		return precioTotal;
	}	
	
}
