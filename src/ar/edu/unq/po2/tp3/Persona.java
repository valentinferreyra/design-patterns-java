package ar.edu.unq.po2.tp3;

import java.time.LocalDate;
import java.time.Period;

public class Persona {

	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	
	public Persona() {
	}
	
	public Persona(String nombre, String apellido, LocalDate fechaNacimiento) {
		
		this.nombre          = nombre;
		this.apellido 		 = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	public int getEdad() {
		LocalDate ahora = LocalDate.now();
		
		Period periodo = Period.between(this.fechaNacimiento, ahora);
		
		return periodo.getYears();
	}
	
	public boolean menorQue(Persona persona) {
		/**
		 * @param persona es una persona, la cual será evaluada para calcular si es menor o mayor
		 */
		
		int miEdad = this.getEdad();
		int edadAComparar = persona.getEdad();
		
		return (miEdad < edadAComparar);
	}
	
}
