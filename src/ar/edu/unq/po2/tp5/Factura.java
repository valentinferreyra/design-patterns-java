package ar.edu.unq.po2.tp5;

public abstract class Factura implements Pagable {
	
	private Agencia agencia;
	private int codigoFactura;
	
	public abstract double precioAPagar();
	
	public Agencia getAgencia() {
		return this.agencia;
	}
	
	public int codigoFactura() {
		return this.codigoFactura;
	}
	
	protected void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	
	protected void setCodFactura(int codFactura) {
		this.codigoFactura = codFactura;
	}	

	public double realizarPago() {
		this.getAgencia().registrarPago(this);
		return this.precioAPagar();
	}
}
