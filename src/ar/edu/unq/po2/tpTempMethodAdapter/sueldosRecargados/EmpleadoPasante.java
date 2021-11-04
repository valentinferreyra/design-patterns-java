package ar.edu.unq.po2.tpTempMethodAdapter.sueldosRecargados;

public class EmpleadoPasante extends Empleado {
	
	int horasTrabajadas;
	
	public EmpleadoPasante(int horas) {
		this.setHorasTrabajadas(horas);
	}
	
	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	@Override
	public double getSueldoBasico() {
		return (40.0 * this.getHorasTrabajadas());
	}

	

}
