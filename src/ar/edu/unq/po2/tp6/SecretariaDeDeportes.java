package ar.edu.unq.po2.tp6;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SecretariaDeDeportes {
	
	List<ActividadSemanal> actividades;
	
	public SecretariaDeDeportes(List<ActividadSemanal> actividades) {
		this.setActividades(actividades);
	}

	public List<ActividadSemanal> getActividades() {
		return actividades;
	}

	public void setActividades(List<ActividadSemanal> actividades) {
		this.actividades = actividades;
	}
	
	public List<ActividadSemanal> getActividadesDeFutbol() {
		return this.getActividades().stream().
			   filter(act -> act.esActividadDeFubtol()).
			   collect(Collectors.toList());
	}
	
	public List<ActividadSemanal> getActividadesDeComplejidad(int complejidad) {
		return this.getActividades().stream().
			   filter(act -> act.esDeComplejidad(complejidad)).
			   collect(Collectors.toList());
	}
	
	public int cantidadHorasTotales() {
		int minutos = this.getActividades().stream(). 
				      mapToInt(act -> act.getDuracion()).sum();
		
		return minutos / 60;
	}
	
	public ActividadSemanal actividadMenorCostoPara(Deporte deporte) {
		List<ActividadSemanal> filtroActividades =  this.getActividades().stream().
				                                    filter(act -> act.getDeporte().equals(deporte)).
				                                    collect(Collectors.toList());
		
		return filtroActividades.stream().min(Comparator.comparing(ActividadSemanal::costoActividad)).get();
	}
	
	public Map<Deporte, ActividadSemanal> actividadesMasEconomicas() {
		Map<Deporte, List<ActividadSemanal>> mapConLista = this.getActividades().stream().
				   										   collect(Collectors.groupingBy(
				   												   ActividadSemanal::getDeporte)); // Creo un map con lista de ActividadSemanal para agruparlos
		
		Map<Deporte, ActividadSemanal> map = new HashMap<Deporte, ActividadSemanal>();
		
		for(Deporte deporte : mapConLista.keySet()) {
			ActividadSemanal masEconomica = mapConLista.get(deporte).stream().
											min(Comparator.comparing(ActividadSemanal::costoActividad)).get();
			
			map.put(deporte, masEconomica);
		}
		
		return map;
	}

	
	public void imprimirTodasLasActividades() {
		for(ActividadSemanal actividad : this.getActividades()) {
			System.out.println(actividad.toString());
		}
	}
}
