package ar.edu.unq.po2.tp5;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
	
	private List<Integer> facturasPagas;
	private String nombre;
	
	public Agencia(String nombre) {
		this.setNombre(nombre);
		this.inicializarFacturas();
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	private void inicializarFacturas() {
		this.facturasPagas = new ArrayList<Integer>();
	}
	
	private void agregarPagoDe(int codigoFactura) {
		this.facturasPagas.add(codigoFactura);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public List<Integer> getFacturasPagas() {
		return this.facturasPagas;
	}
	
	public void registrarPago(Factura factura) {
		this.agregarPagoDe(factura.codigoFactura());
		// otra solución es que facturasPagas sea un List<Factura>
	}
	
	public boolean recibioElPagoDe(Factura factura) {
		int codigoFactura = factura.codigoFactura();
		
		while(facturasPagas.size() != 0 && 
			  facturasPagas.get(0) != codigoFactura) {
			facturasPagas.remove(0);
		}
		return (facturasPagas.size() > 0);
	}
 
}
