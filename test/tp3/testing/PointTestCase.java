package tp3.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.Point;

class PointTestCase {
	@Test
	public void testPointSinParametro() {
		/**
		 * Con este test verifico que si se crea un punto sin parámetros,
		 * su ubicación es 0,0
		 */
		
		Point punto  = new Point();
		float puntoX = punto.getX();
		float puntoY = punto.getY();
		
		assertEquals(puntoX, 0);
		assertEquals(puntoY, 0);
	}
	
	@Test
	public void testPointConParametros() {
		/**
		 * Con este test verifico que si se crea un punto con parámetros,
		 * su ubicación es el lugar que se le asignó como argumentos
		 */
		
		Point punto  = new Point(5, 8);
		
		assertEquals(punto.getX(), 5);
		assertEquals(punto.getY(), 8);
	}
	
	@Test
	public void testMoverPoint() {
		/**
		 * Test para comprobar que cuando se mueve un punto hacia otra dirección,
		 * su ubicación cambia
		 */
		
		Point punto = new Point(5, 8);
		punto.moverPunto(10, 9);
		
		assertEquals(punto.getX(), 10);
		assertEquals(punto.getY(), 9);
	}
	
	@Test
	public void testSumarPuntos() {
		/**
		 * Test para comprobar que cuando se suman dos puntos, el resultado son sus ubicaciones
		 * sumadas entre si
		 */
		
		Point point1 = new Point(10, 20);
		
		Point point2 = new Point(5, 5);
		point2.sumarConPunto(point1);
		
		assertEquals(point2.getX(), 15);
		assertEquals(point2.getY(), 25);
	}
}
