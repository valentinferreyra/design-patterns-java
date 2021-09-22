package ar.edu.unq.po2.tp3;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Persona {

	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	
	public Persona() {
	}
	
	public Persona(String nombre, String apellido, String fechaNacimiento) {
		
		this.nombre          = nombre;
		this.apellido 		 = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	public int getEdad() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(this.fechaNacimiento, fmt);
		LocalDate ahora = LocalDate.now();
		
		Period periodo = Period.between(fechaNac, ahora);
		
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
