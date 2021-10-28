package ar.edu.unq.po2.tpComposite.fileSystem;

import java.time.LocalDate;

public interface FileSystem {

	public int totalSize();
	
	public void printStructure();
	
	public LocalDate lastModified();
	
	public FileSystem oldestElement();
	
}
