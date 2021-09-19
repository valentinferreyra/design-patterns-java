package ar.edu.unq.po2.tp3;

import java.util.Calendar;
import java.util.Date;

public class Persona {

	private String nombre;
	private Date fechaNacimiento;
	
	public Persona(String nombre, Date fechaNacimiento) {
		
		this.nombre          = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	public int getEdad() {
		return fechaNacimiento.getYear() - Calendar.YEAR;
	}
	
}
