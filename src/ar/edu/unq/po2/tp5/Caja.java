package ar.edu.unq.po2.tp5;

import java.util.List;

public class Caja {
	
	public Caja() {
	}
	
	public double cobrar(Pagable pagable) {
		return pagable.realizarPago();
	}
	
	public double cobrar(List<Pagable> arrayDePagables) {
		double totalAPagar = 0;
		for(Pagable pagable : arrayDePagables) {
			double precio = pagable.realizarPago();
			totalAPagar += precio;
		}
		return totalAPagar;
		
	}
	
}
