package ar.edu.unq.po2.tpComposite.shapeShifter;

import java.util.Arrays;
import java.util.List;

public class SingleShapeShifter implements IShapeShifter {
	
	private int value;
	
	public SingleShapeShifter(int value) {
		this.setValue(value);
	}
	
	@Override
	public IShapeShifter compose(IShapeShifter shapeShifter) {
		CompShapeShifter newSS = new CompShapeShifter();
		newSS.addShapeShifter(this);
		newSS.addShapeShifter(shapeShifter);
		return newSS;
	}

	@Override
	public int deepest() {
		return 0;
	}

	@Override
	public IShapeShifter flat() {
		return this;
	}

	@Override
	public List<Integer> values() {
		return Arrays.asList(this.getValue());
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}


}
