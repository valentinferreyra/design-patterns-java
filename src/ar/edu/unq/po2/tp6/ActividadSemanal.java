package ar.edu.unq.po2.tp6;

public class ActividadSemanal {
	
	DiaDeLaSemana dia;
	int horaInicio;
	int duracion;
	Deporte deporte;
	
	public ActividadSemanal(DiaDeLaSemana dia, int horaInicio, int duracion, Deporte deporte) {
		super();
		this.setDia(dia);
		this.setHoraInicio(horaInicio);
		this.setDuracion(duracion);
		this.setDeporte(deporte);
	}
	
	public DiaDeLaSemana getDia() {
		return dia;
	}

	public void setDia(DiaDeLaSemana dia) {
		this.dia = dia;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}
	
	public double costoActividad() {
		return this.costoPorDia() + this.costoPorComplejidad();
	}
	
	public double costoPorDia() {
		if ((this.dia == DiaDeLaSemana.LUNES)  || 
		   (this.dia == DiaDeLaSemana.MARTES)  ||
		   (this.dia == DiaDeLaSemana.MIERCOLES)) {
			return 500f;
		} else {
			return 1000f;
		}
	}
	
	public double costoPorComplejidad() {
		return 200f * this.getDeporte().getComplejidad();
	}

	public boolean esActividadDeFubtol() {
		return this.deporte == Deporte.FUTBOL;
	}

	public int getNivelDeComplejidad() {
		return getDeporte().getComplejidad();
	}
	
//	@Override
//	public String toString() {
//		return "Deporte:" thsis.deporte + ' ' + "DIA:" + dia + "A LAS:" + horaInicio + "Duración:" + duracion / 60 + "hora(s)"
//	}
}
