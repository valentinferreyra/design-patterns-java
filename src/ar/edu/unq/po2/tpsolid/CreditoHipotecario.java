package ar.edu.unq.po2.tpsolid;

public class CreditoHipotecario extends SolicitudCredito {

	private PropiedadInmobiliaria propiedadInmobiliaria;
	
	public CreditoHipotecario(Cliente cliente, double monto, int meses, PropiedadInmobiliaria propiedad) {
		super.setCliente(cliente);
		super.setMontoSolicitado(monto);
		super.setPlazoEnMeses(meses);
		this.setPropiedadInmobiliaria(propiedad);
	}

	public PropiedadInmobiliaria getPropiedadInmobiliaria() {
		return propiedadInmobiliaria;
	}

	public void setPropiedadInmobiliaria(PropiedadInmobiliaria propiedadInmobiliaria) {
		this.propiedadInmobiliaria = propiedadInmobiliaria;
	}

	@Override
	public boolean esSolicitudAceptable() {
		
		int añosDePago = this.getPlazoEnMeses() / 12;
		double valorFiscalPorcentuado = this.getPropiedadInmobiliaria().getValorFiscal() * 0.70;
		double ingresosMensualesPorcentuado = this.getCliente().getSueldoNetoMensual() * 0.50;
		
		return  (this.getMontoCuotaMensual() <= ingresosMensualesPorcentuado)  
			&&	(this.getMontoSolicitado() <= valorFiscalPorcentuado)
			&&	((this.getCliente().getEdad() + añosDePago) < 65);
	}
}