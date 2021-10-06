package ar.edu.unq.po2.tp5;

public class Servicio extends Factura {

	private double costoPorUnidad;
	private int unidadesConsumidas;
	
	public Servicio(Agencia agencia, double costoUnidad, int unidadesConsumidas, int codFactura) {
		super.setAgencia(agencia);
		super.setCodFactura(codFactura);
		this.setCostoPorUnidad(costoUnidad);
		this.setUnidadesConsumidas(unidadesConsumidas);
	}
	
	private void setCostoPorUnidad(double costoUnidad) {
		this.costoPorUnidad = costoUnidad;
	}
	
	private void setUnidadesConsumidas(int unidades) {
		this.unidadesConsumidas = unidades;
	}
	
	public double precioAPagar() {
		return (this.costoPorUnidad * this.unidadesConsumidas);
	}
}
