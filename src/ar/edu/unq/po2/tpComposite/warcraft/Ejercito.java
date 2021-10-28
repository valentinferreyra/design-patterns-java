package ar.edu.unq.po2.tpComposite.warcraft;

import java.util.List;

public class Ejercito implements Component {
	
	private List<Component> children;

	public List<Component> getChildren() {
		return children;
	}

	public void setChildren(List<Component> children) {
		this.children = children;
	}

	@Override
	public void moverHaciaElPunto(String unPunto) {
		for(Component child : children) {
			child.moverHaciaElPunto(unPunto);
		}
	}

	@Override
	public void add(Component child) {
		this.getChild().add(child);
		
	}

	@Override
	public void remove(Component child) {
		this.getChild().remove(child);
		
	}

	@Override
	public List<Component> getChild() {
		return this.getChild();
	}

}
