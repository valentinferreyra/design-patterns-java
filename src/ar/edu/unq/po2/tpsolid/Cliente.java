package ar.edu.unq.po2.tpsolid;

public class Cliente {
	
	private String nombre;
	private String apellido;
	private String direccion;
	private int edad;
	private double sueldoNetoMensual;
	private double montoDeCreditos = 0; // atributo creado para realizar test
	
	public Cliente(String nombre, String apellido, String direccion, int edad, double sueldoNetoMensual) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDireccion(direccion);
		this.setEdad(edad);
		this.setSueldoNetoMensual(sueldoNetoMensual);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEdad() {
		return edad;
	}

	public double getMontoDeCreditos() {
		return this.montoDeCreditos;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getSueldoNetoMensual() {
		return sueldoNetoMensual;
	}

	public void setSueldoNetoMensual(double sueldoNetoMensual) {
		this.sueldoNetoMensual = sueldoNetoMensual;
	}

	public double getSueldoNetoAnual() {
		return this.getSueldoNetoMensual() * 12;
	}
	
	public void iniciarSolicitudDeCredito(Banco banco, SolicitudCredito solicitud) {
		banco.consultarPorCredito(solicitud);
	}
	
	public void recibirCreditoDe(double monto) {
		this.montoDeCreditos = monto;
	}
}