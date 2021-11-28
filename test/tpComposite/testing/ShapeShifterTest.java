package tpComposite.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpComposite.shapeShifter.IShapeShifter;
import ar.edu.unq.po2.tpComposite.shapeShifter.SingleShapeShifter;

class ShapeShifterTest {
	
	IShapeShifter single1;
	IShapeShifter single2;
	IShapeShifter single3;
	IShapeShifter single4;
	IShapeShifter single5;
	IShapeShifter composite1;
	IShapeShifter composite2;

	@BeforeEach
	public void setUp() throws Exception {
		this.single1 = new SingleShapeShifter(1);
		this.single2 = new SingleShapeShifter(2);
		this.single3 = new SingleShapeShifter(3);
		this.single4 = new SingleShapeShifter(4);
		this.single5 = new SingleShapeShifter(5);
	}
	
	@Test
	void testUnSingleShapeShifter_ConoceSuValue() {
		List<Integer> value = single1.values();
		
		assertEquals(value.get(0), 1);
		assertEquals(value.size(), 1);
	}
	
	@Test
	void testUnSingleShapeShifter_PuedeComponerseConOtroYConocerSuValue() {
		composite1 = single1.compose(single2);
		
		assertTrue(composite1.values().contains(1));
		assertTrue(composite1.values().contains(2));
		assertEquals(composite1.values().size(), 2);
	}
	
	@Test
	void testLaProfundidadDeUnSingleShapeShifterEs0() {
		assertEquals(single1.deepest(), 0);
	}
	
	@Test
	void testUnCompShapeShifter_ConoceElTotalDeSuProfundidad() {
		composite1 = single1.compose(single2);
		assertEquals(composite1.deepest(), 1);
		
		composite2 = composite1.compose(single3);
		assertEquals(composite2.deepest(), 2);		
	}
	
	@Test
	void testElFlatDeUnSingleShapeShifter_EsElMismo() {
		assertEquals(single1.flat(), single1);
	}
}
