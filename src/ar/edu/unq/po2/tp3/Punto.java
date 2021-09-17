package ar.edu.unq.po2.tp3;

public class Punto {
	
	private float x;
	private float y;
	
	public Punto() {
		super();
		this.setXY(0, 0);
	}
	
	public Punto(float x, float y) {
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
	
	public void moverPunto(Punto punto, float x, float y) {
		punto.setXY(x, y);
	}
	
	public Punto sumarPuntos(Punto punto1, Punto punto2) {
		Punto nuevoPunto = new Punto();
		float nuevoX     = punto1.getX() + punto2.getX();
		float nuevoY     = punto1.getY() + punto2.getY();
		
		nuevoPunto.setXY(nuevoX, nuevoY);
		
		return nuevoPunto;
	}
	
}