package ar.edu.unq.po2.tpObserver.encuentrosDeportivos;

import java.util.ArrayList;
import java.util.List;

public class AplicacionMovil implements ISportListener {

	private List<String> resultadosDeInteres;
	private List<String> interes;
	
	public AplicacionMovil(List<String> intereses) {
		this.setInteres(intereses);
		this.setResultadosDeInteres(new ArrayList<String>());
	}

	public List<String> getResultadosDeInteres() {
		return resultadosDeInteres;
	}

	public void setResultadosDeInteres(List<String> resultadosDeInteres) {
		this.resultadosDeInteres = resultadosDeInteres;
	}

	public List<String> getInteres() {
		return interes;
	}

	public void setInteres(List<String> interes) {
		this.interes = interes;
	}

	@Override
	public void suscribir(Aplicacion aplicacion) {
		aplicacion.addListener(this);	
	}

	@Override
	public void registrarNuevoPartido(Partido partido) {
		if (this.esPartidoDeInteres(partido)) {
			this.getResultadosDeInteres().add(partido.getResultado());
		}
	}

	private boolean esPartidoDeInteres(Partido partido) {
		for(String interes : this.getInteres()) {
			if (partido.esDeInteres(interes)) {
				return true;
			}
		}
		return false;
	}
}
