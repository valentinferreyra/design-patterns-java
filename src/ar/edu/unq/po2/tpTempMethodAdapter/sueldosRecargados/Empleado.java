package ar.edu.unq.po2.tpTempMethodAdapter.sueldosRecargados;

public abstract class Empleado {
	
	/**
	 * Monto del sueldo b�sico de cada empleado, cada uno deber� redefinirlo
	 * @return el sueldo b�sico del empleado
	 */
	public abstract double getSueldoBasico();
	
	public double sueldo() {
		double aumento = this.montoDeAumento();
		
		double sueldoTotal = this.getSueldoBasico() + aumento - this.getDescuento();
		
		return sueldoTotal;
	}
	
	/**
	 * Hook method de empleado: el monto de aumento por defecto ser� 0, 
	 * salvo que el empleado reescriba el m�todo
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
