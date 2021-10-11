package ar.edu.unq.po2.tpsolid;

public class PropiedadInmobiliaria {
	
	private String descripcion;
	private String direccion;
	private double valorFiscal;
	
	public PropiedadInmobiliaria(String descripcion, String direccion, double valorFiscal) {
		this.setDescripcion(descripcion);
		this.setDireccion(direccion);
		this.setValorFiscal(valorFiscal);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getValorFiscal() {
		return valorFiscal;
	}

	public void setValorFiscal(double valorFiscal) {
		this.valorFiscal = valorFiscal;
	}

}