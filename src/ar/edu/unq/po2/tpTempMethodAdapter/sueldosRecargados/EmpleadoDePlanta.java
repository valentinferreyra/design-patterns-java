package ar.edu.unq.po2.tpTempMethodAdapter.sueldosRecargados;

public class EmpleadoDePlanta extends Empleado {
	
	double sueldoBasico;
	int cantHijos;
	
	public EmpleadoDePlanta(double sueldoBasico, int hijos) {
		this.setSueldoBasico(sueldoBasico);
		this.setCantHijos(hijos);
	}

	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	public int getCantHijos() {
		return cantHijos;
	}

	public void setCantHijos(int cantHijos) {
		this.cantHijos = cantHijos;
	}

	@Override
	public double getSueldoBasico() {
		return sueldoBasico;
	}
	
	@Override
	public double montoDeAumento() {
		return (150.0 * this.getCantHijos());
	}

}
