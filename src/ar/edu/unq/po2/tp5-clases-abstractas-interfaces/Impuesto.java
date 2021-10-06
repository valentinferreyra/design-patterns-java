package ar.edu.unq.po2.tp5;

public class Impuesto extends Factura {
	
	private double tasaDeServicio;
	
	public Impuesto(Agencia agencia, double tasaServicio, int codFactura) {
		super.setAgencia(agencia);
		super.setCodFactura(codFactura);
		this.setTasaDeServicio(tasaServicio);
	}
	
	private void setTasaDeServicio(double tasaServicio) {
		this.tasaDeServicio = tasaServicio;
	}
	
	public double precioAPagar() {
		return this.getTasaDeServicio();
	}
	
	public double getTasaDeServicio() {
		return this.tasaDeServicio;
	}
}
