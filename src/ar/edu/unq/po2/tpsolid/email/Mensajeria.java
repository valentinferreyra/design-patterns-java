package ar.edu.unq.po2.tpsolid.email;

public interface Mensajeria {
	
	public void recibirNuevos();
	
	public void enviarCorreo(String asunto, String destinatario, String cuerpo);

}
