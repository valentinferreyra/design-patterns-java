package ar.edu.unq.po2.tpsolid.email;

public interface ManipulacionCorreo {
	
	public void borrarCorreo(Correo correo);
	
	public int contarBorrados();
	
	public int contarInbox();
	
	public void eliminarBorrado(Correo correo);
	

}
