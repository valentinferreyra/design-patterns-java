package ar.edu.unq.po2.tpComposite.warcraft;

import java.util.List;

public abstract class Personaje implements Component {
	
	private String punto;

	public String getPunto() {
		return punto;
	}

	public void setPunto(String punto) {
		this.punto = punto;
	}

	@Override
	public void moverHaciaElPunto(String unPunto) {
		// las Subclases se deben redefinir
	}

	@Override
	public void add(Component child) {
		// es un Personaje, no hace nada
		
	}

	@Override
	public void remove(Component child) {
		// es un Personaje, no hace nada
		
	}

	@Override
	public List<Component> getChild() {
		// es un Personaje, no hace nada
		return null;
	}

}
