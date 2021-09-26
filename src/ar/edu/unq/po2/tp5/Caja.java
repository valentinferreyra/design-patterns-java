package ar.edu.unq.po2.tp5;

import java.util.List;

public class Caja {
	
	public Caja() {
	}
	
	public double cobrar(Producto producto) {
		producto.decrementarStockEn(1);
		return producto.getPrecio();
	}
	
	public double cobrar(List<Producto> arrayDeProductos) {
		double totalAPagar = 0;
		for(Producto producto : arrayDeProductos) {
			producto.decrementarStockEn(1);
			totalAPagar += producto.getPrecio();
		}
		return totalAPagar;
	}
	
	
}
