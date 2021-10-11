package ar.edu.unq.po2.tpsolid;

public abstract class SolicitudCredito {
	
	private Cliente cliente;
	private double montoSolicitado;
	private int plazoEnMeses;
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public double getMontoSolicitado() {
		return montoSolicitado;
	}
	public void setMontoSolicitado(double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}
	public int getPlazoEnMeses() {
		return plazoEnMeses;
	}
	public void setPlazoEnMeses(int plazoEnMeses) {
		this.plazoEnMeses = plazoEnMeses;
	}
	
	public double getMontoCuotaMensual() {
		return this.getMontoSolicitado() / this.getPlazoEnMeses();
	}

	public abstract boolean esSolicitudAceptable();

}
