package ar.edu.unq.po2.tpRefactoring.registro;

import java.time.LocalDate;

public class RegistroAutomotor {

	private LocalDate fecha;
	private Vehiculo vehiculo;
	
	public Boolean debeRealizarVtv(Vehiculo vehiculo, LocalDate fecha) {
		
		this.setVehiculo(vehiculo);
		this.setFecha(fecha);
	
		return (!this.esVehiculoPolicial() && 
				this.tieneAntiguedadMayorA(1)
				&& this.estaRadicadoEn("Buenos Aires"));

	}

	private void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	private void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		
	}

	private boolean estaRadicadoEn(String ciudad) {
		return vehiculo.ciudadRadicacion().equalsIgnoreCase("Buenos Aires");
	}

	private boolean tieneAntiguedadMayorA(int antiguedad) {
		return fecha.minusYears(antiguedad).isAfter(vehiculo.getFechaFabricacion());

	}

	private boolean esVehiculoPolicial() {
		return vehiculo.esVehiculoPolicial();
	}
	
}
