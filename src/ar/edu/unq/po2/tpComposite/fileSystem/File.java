package ar.edu.unq.po2.tpComposite.fileSystem;

import java.time.LocalDate;

public class File implements FileSystem {
	
	private String nombre;
	private int espacioEnDisco;
	private LocalDate ultimaModificacion;

	public File(String nombre, int espacioEnDisco) {
		this.setNombre(nombre);
		this.setEspacioEnDisco(espacioEnDisco);
		this.setUltimaModificacion(LocalDate.now());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEspacioEnDisco() {
		return espacioEnDisco;
	}

	public void setEspacioEnDisco(int espacioEnDisco) {
		this.espacioEnDisco = espacioEnDisco;
	}

	public LocalDate getUltimaModificacion() {
		return ultimaModificacion;
	}

	public void setUltimaModificacion(LocalDate ultimaModificacion) {
		this.ultimaModificacion = ultimaModificacion;
	}

	@Override
	public int totalSize() {
		return this.getEspacioEnDisco();
	}

	@Override
	public void printStructure() {
		System.out.println(this.getNombre());
	}

	@Override
	public LocalDate lastModified() {
		return this.getUltimaModificacion();
	}

	@Override
	public FileSystem oldestElement() {
		return this;
	}
}
