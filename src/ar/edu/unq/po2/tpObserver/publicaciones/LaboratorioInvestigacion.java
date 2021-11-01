package ar.edu.unq.po2.tpObserver.publicaciones;

import java.util.ArrayList;
import java.util.List;

public class LaboratorioInvestigacion implements ISistemaListener {

	private List<Articulo> articulosDeInteres;
	private String interes;
	
	public LaboratorioInvestigacion(String string) {
		this.setInteres(interes);
		this.setArticulosDeInteres(new ArrayList<Articulo>());
	}
	
	@Override
	public void suscribir(Sistema sistema) {
		sistema.suscribirListener(this);
	}

	@Override
	public void nuevoArticuloPublicado(Articulo articulo) {
		if (this.esDeInteres(articulo)) {
			this.getArticulosDeInteres().add(articulo);
		}
	}

	private boolean esDeInteres(Articulo articulo) {
		return articulo.estaRelacionadoCon(this.getInteres());
	}

	public List<Articulo> getArticulosDeInteres() {
		return articulosDeInteres;
	}

	public void setArticulosDeInteres(List<Articulo> articulosDeInteres) {
		this.articulosDeInteres = articulosDeInteres;
	}

	public String getInteres() {
		return interes;
	}

	public void setInteres(String interes) {
		this.interes = interes;
	}

	
	
}
