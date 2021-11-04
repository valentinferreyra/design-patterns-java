package ar.edu.unq.po2.tpTempMethodAdapter.sueldosRecargados;

public class EmpleadoTemporario extends Empleado {
	
	double sueldoBasico;
	int horasTrabajadas;
	boolean poseeHijos;
	boolean estaCasado;
	
	public EmpleadoTemporario(double sueldoBasico, int horasTrabajadas, boolean poseeHijos, boolean estaCasado) {
		this.setSueldoBasico(sueldoBasico);
		this.setHorasTrabajadas(horasTrabajadas);
		this.setPoseeHijos(poseeHijos);
		this.setEstaCasado(estaCasado);
	}

	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
	
	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public boolean isPoseeHijos() {
		return poseeHijos;
	}

	public void setPoseeHijos(boolean poseeHijos) {
		this.poseeHijos = poseeHijos;
	}

	public boolean isEstaCasado() {
		return estaCasado;
	}

	public void setEstaCasado(boolean estaCasado) {
		this.estaCasado = estaCasado;
	}
	
	@Override
	public double getSueldoBasico() {
		return sueldoBasico;
	}

	@Override
	public double montoDeAumento() {
		double montoPorHijosOCasado = 0;
		
		if(this.isEstaCasado() || this.isPoseeHijos()) {
			montoPorHijosOCasado += 100;
		}
		
		return (this.getHorasTrabajadas() * 5) + montoPorHijosOCasado;
	}
	
}
