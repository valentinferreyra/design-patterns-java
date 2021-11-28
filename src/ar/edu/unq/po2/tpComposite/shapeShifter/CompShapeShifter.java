package ar.edu.unq.po2.tpComposite.shapeShifter;

import java.util.ArrayList;
import java.util.List;

public class CompShapeShifter implements IShapeShifter {
	
	private ArrayList<IShapeShifter> children;
	
	public CompShapeShifter() {
		this.setChildren(new ArrayList<IShapeShifter>());
	}

	@Override
	public IShapeShifter compose(IShapeShifter shapeShifter) {
		CompShapeShifter newSS = new CompShapeShifter();
		newSS.addShapeShifter(this);
		for(IShapeShifter children : this.getChildren()) {
			newSS.addShapeShifter(children);
		}
		return newSS;
	}

	@Override
	public int deepest() {
		int currentDeepest = 1;
		for(IShapeShifter children : this.getChildren()) {
			currentDeepest += children.deepest();
		}
		return currentDeepest;
	}

	@Override
	public IShapeShifter flat() {
		CompShapeShifter newSS = new CompShapeShifter();
		List<Integer> values = this.values();
		for(Integer value : values) {
			newSS.addShapeShifter(new SingleShapeShifter(value));
		}
		return newSS;
	}

	@Override
	public List<Integer> values() {
		List<Integer> values = new ArrayList<Integer>();
		for(IShapeShifter children : this.getChildren()) {
			values.addAll(children.values());
		}
		return values;
	}

	public void addShapeShifter(IShapeShifter shapeShifter) {
		this.getChildren().add(shapeShifter);		
	}

	public ArrayList<IShapeShifter> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<IShapeShifter> children) {
		this.children = children;
	}

}
