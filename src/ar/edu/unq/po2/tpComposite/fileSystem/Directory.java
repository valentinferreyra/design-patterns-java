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
		
//		FileSystem fistFile = children.get(0);
//		
//		if(firstFile.lastModified().)
		
		return null;
	
	}

	@Override
	public File oldestElement() {
//		// TODO Auto-generated method stub
	return null;
	}

}
