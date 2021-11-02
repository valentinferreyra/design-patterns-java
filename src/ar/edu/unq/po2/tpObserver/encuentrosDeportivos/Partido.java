package ar.edu.unq.po2.tpObserver.encuentrosDeportivos;

import java.util.List;

public class Partido {

	private String resultado;
	private List<String> contrincantes;
	private String deporte;
	
	public Partido(String result, List<String> contrincantes, String deporte) {
		this.setResultado(result);
		this.setContrincantes(contrincantes);
		this.setDeporte(deporte);
	}
	
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public List<String> getContrincantes() {
		return contrincantes;
	}
	public void setContrincantes(List<String> contrincantes) {
		this.contrincantes = contrincantes;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public boolean esDeInteres(String interes) {
		return this.getContrincantes().contains(interes) || 
			   this.getDeporte() == interes || 
			   this.getContrincantes().contains(interes);  
	}
	
	
}
