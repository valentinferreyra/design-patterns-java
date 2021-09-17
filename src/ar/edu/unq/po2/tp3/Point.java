package ar.edu.unq.po2.tp3;

public class Point {
	
	private float x;
	private float y;
	
	public Point() {
		super();
		this.setXY(0, 0);
	}
	
	public Point(float x, float y) {
		this();
		this.setXY(x, y);
	}
	
	public float getX() {
		return x;
	}
	
	public void setXY(float x, float y) {
		this.setX(x);
		this.setY(y);
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void moverPunto(float x, float y) {
		this.setXY(x, y);
	}
	
	public void sumarConPunto(Point aPoint) {
	
		float newX = this.x + aPoint.getX();
		float newY = this.y + aPoint.getY();
		
		this.setXY(newX, newY);
	}
	
}