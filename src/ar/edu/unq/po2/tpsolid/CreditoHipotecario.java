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
		return  laCuotaMnesualNoSuperaALosIngresos()  
			&&	montoSolicitadoNoSuperaAlValorFiscal()
			&&	laEdadDeLaPersonaNoSupera65CuandoFinaliza();
	}

	private boolean laCuotaMnesualNoSuperaALosIngresos() {
		double ingresosMensualesPorcentuado = this.getCliente().getSueldoNetoMensual() * 0.50;
		return this.getMontoCuotaMensual() <= ingresosMensualesPorcentuado;
	}

	private boolean montoSolicitadoNoSuperaAlValorFiscal() {
		double valorFiscalPorcentuado = this.getPropiedadInmobiliaria().getValorFiscal() * 0.70;
		return this.getMontoSolicitado() <= valorFiscalPorcentuado;
	}

	private boolean laEdadDeLaPersonaNoSupera65CuandoFinaliza() {
		int añosDePago = this.getPlazoEnMeses() / 12;
		return (this.getCliente().getEdad() + añosDePago) < 65;
	}
}