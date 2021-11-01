package ar.edu.unq.po2.tpComposite.fileSystem;

import java.time.LocalDate;
import java.util.List;

public class Directory implements FileSystem {

	private String nombre;
	private LocalDate fechaCreacion;
	private List<FileSystem> children;
	
	public Directory(String nombre) {
		this.setNombre(nombre);
		this.setFechaCreacion(LocalDate.now());
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public int totalSize() {
		int sizeTotal = 0;
		
		for(FileSystem child : children) {
			sizeTotal += child.totalSize();
		}
		
		return sizeTotal;
	}

	@Override
	public void printStructure() {
//		for(FileSystem child : children) {
//			System.out.println( " " + child.printStructure() );
//		}
	}

	@Override
	public LocalDate lastModified() {
		
//		for(FileSystem child : children) {
//			/*
//			 * Debe hacer una funci�n para que devuelva el �ltimo
//			 * modificado y compararlo con el primero, siguiendo la recursi�n
//			 */
//		}
		
		return null;
	
	}

	@Override
	public File oldestElement() {
//		
//		for(FileSystem child : children) {
//		/*
//		 * Debe hacer una funci�n para que devuelva el archivo
//		 * m�s viejo y compararlo con el primero, siguiendo la recursi�n
//		 */
//	}
	
	return null;
	}

}
