package ar.edu.unq.po2.tpComposite.warcraft;

import java.util.List;

public interface Component {
		
	public abstract void moverHaciaElPunto(String unPunto);
		
	public abstract void add(Component child);
		
	public abstract void remove(Component child);
	
	public abstract List<Component> getChild();
	
}
