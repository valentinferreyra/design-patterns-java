package ar.edu.unq.po2.tpTempMethodAdapter.sueldosRecargados;

public abstract class Empleado {
	
	/**
	 * Monto del sueldo básico de cada empleado, cada uno deberá redefinirlo
	 * @return el sueldo básico del empleado
	 */
	public abstract double getSueldoBasico();
	
	public double sueldo() {
		double aumento = this.montoDeAumento();
		
		double sueldoTotal = this.getSueldoBasico() + aumento - this.getDescuento();
		
		return sueldoTotal;
	}
	
	/**
	 * Hook method de empleado: el monto de aumento por defecto será 0, 
	 * salvo que el empleado reescriba el método
	 * @return el monto de aumento
	 */
	public double montoDeAumento() {
		return 0;
	}
	
	/**
	 * Monto que se le descuenta a cualquier empleado, independientemente
	 * de su tipo
	 * @return el monto de descuento de la empresa
	 */
	private double getDescuento() {
		return (this.getSueldoBasico() * 13 / 100);
	}

}
