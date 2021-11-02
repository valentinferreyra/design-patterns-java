package ar.edu.unq.po2.tpObserver.encuentrosDeportivos;

import java.util.ArrayList;
import java.util.List;

public class Servidor implements ISportListener {
	
	private List<Partido> partidosDeInteres;
	private List<String> intereses;
	
	public Servidor(List<String> intereses) {
		this.setIntereses(intereses);
		this.setPartidosDeInteres(new ArrayList<Partido>());
	}

	public List<Partido> getPartidosDeInteres() {
		return partidosDeInteres;
	}

	public void setPartidosDeInteres(List<Partido> partidosDeInteres) {
		this.partidosDeInteres = partidosDeInteres;
	}

	public List<String> getIntereses() {
		return intereses;
	}

	public void setIntereses(List<String> intereses) {
		this.intereses = intereses;
	}

	@Override
	public void suscribir(Aplicacion aplicacion) {
		aplicacion.addListener(this);		
	}

	@Override
	public void registrarNuevoPartido(Partido partido) {
		if (this.esPartidoDeInteres(partido)) {
			this.getPartidosDeInteres().add(partido);
		}
	}

	private boolean esPartidoDeInteres(Partido partido) {
		for (String interes : this.getIntereses()) {
			if (partido.esDeInteres(interes)) {
				return true;
			}
		}
		
		return false;
	}
	
}
