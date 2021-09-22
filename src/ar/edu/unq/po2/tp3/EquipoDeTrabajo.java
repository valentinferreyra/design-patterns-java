package ar.edu.unq.po2.tp3;

import java.util.ArrayList;
import java.util.List;

public class EquipoDeTrabajo {

	private String nombreEquipo;
	private List<Persona> personas = new ArrayList<>();
	
	public EquipoDeTrabajo() {
	}
	
	public EquipoDeTrabajo(String nombre, List<Persona> listaDePersonas) {
		
		this.nombreEquipo = nombre;
		this.personas     = listaDePersonas;
		
	}
	
	public String getNombre() {
		return this.nombreEquipo;
	}
	
	public float promedioEdad() {
		
		int totalEdades = 0;
		float promedioTotal;
		int cantDePersonas = this.personas.size();
		
		for(Persona persona : this.personas) {
			totalEdades += persona.getEdad();
		}
		
		promedioTotal = (totalEdades / cantDePersonas);
		return promedioTotal;
	}
}
