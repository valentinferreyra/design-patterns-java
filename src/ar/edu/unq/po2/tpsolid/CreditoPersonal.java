package ar.edu.unq.po2.tpsolid;

public class CreditoPersonal extends SolicitudCredito {

	public CreditoPersonal(Cliente cliente, double monto, int meses) {
		super.setCliente(cliente);
		super.setMontoSolicitado(monto);
		super.setPlazoEnMeses(meses);
	}
	
	public boolean esSolicitudAceptable() {
		
		double ingresoMensualPorcentuado = this.getCliente().getSueldoNetoMensual() * 0.70;
		
		return (this.getCliente().getSueldoNetoAnual() >= 15000) &&
			   (this.getMontoCuotaMensual() <= ingresoMensualPorcentuado);
	}
}
