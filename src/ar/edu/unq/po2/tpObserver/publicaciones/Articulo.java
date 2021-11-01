package ar.edu.unq.po2.tpObserver.publicaciones;

import java.util.List;

public class Articulo {

	private String titulo;
	private List<String> autores;
	private List<String> filiaciones;
	private String tipoArticulo;
	private String lugar;
	private List<String> palabrasClave;
	
	public Articulo(String title, List<String> auth, List<String> fil, String typArt, String from, List<String> keywords) {
		
		this.setTitulo(title);
		this.setAutores(auth);
		this.setFiliaciones(fil);
		this.setTipoArticulo(typArt);
		this.setLugar(from);
		this.setPalabrasClave(keywords);
		
	}
	
	public boolean estaRelacionadoCon(String interes) {
		boolean stringSimples = (this.getTitulo() == interes)        ||
				                (this.getTipoArticulo() == interes)  ||
				                (this.getLugar() == interes);
	   boolean stringListas = (this.getAutores().contains(interes))     || 
	                          (this.getFiliaciones().contains(interes)) ||
	                          (this.getPalabrasClave().contains(interes));
	   
	   return stringSimples || stringListas;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<String> getAutores() {
		return autores;
	}
	public void setAutores(List<String> autores) {
		this.autores = autores;
	}
	public List<String> getFiliaciones() {
		return filiaciones;
	}
	public void setFiliaciones(List<String> filiaciones) {
		this.filiaciones = filiaciones;
	}
	public String getTipoArticulo() {
		return tipoArticulo;
	}
	public void setTipoArticulo(String tipoArticulo) {
		this.tipoArticulo = tipoArticulo;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public List<String> getPalabrasClave() {
		return palabrasClave;
	}
	public void setPalabrasClave(List<String> palabrasClave) {
		this.palabrasClave = palabrasClave;
	}
	
}
