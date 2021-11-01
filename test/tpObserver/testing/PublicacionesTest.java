package tpObserver.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpObserver.publicaciones.Articulo;
import ar.edu.unq.po2.tpObserver.publicaciones.LaboratorioInvestigacion;
import ar.edu.unq.po2.tpObserver.publicaciones.Sistema;

class PublicacionesTest {
	
	Articulo articulo1;
	Articulo articulo2;
	Sistema clarin;
	LaboratorioInvestigacion labProgram;
	LaboratorioInvestigacion deportes;
	
	@BeforeEach
	public void setUp() throws Exception {
		
		this.articulo2 = new Articulo("Boca campeon", Arrays.asList("Leandro Aguilera"), Arrays.asList("Ole"), "Deportes", "Argentina", Arrays.asList("Boca", "Libertadores", "Campeon"));
		this.articulo1 = new Articulo("Programacion con Objetos", Arrays.asList("Maximo Prieto"), Arrays.asList("UNQ"), "Programacion", "Argentina", Arrays.asList("Programacion", "Objetos", "Smalltalk"));
		
		this.clarin = new Sistema();
		this.labProgram = new LaboratorioInvestigacion("Smalltalk");
		this.deportes = new LaboratorioInvestigacion("Boca");

	}

	@Test
	void testCuandoElSistemaAgregaUnArticuloDeSmalltalk_LabProgramLoAgregaASuInteres() {
		/**
		 * En mi setUp creo un nuevo Sistema llamado Clar�n con un art�culo de Smalltalk publicado, 
		 * y como ahora labProgram se suscribir� y est� interesado en eso, compruebo que el art�culo se agreg� a su lista
		 * de art�culos de inter�s
		*/

		this.labProgram.suscribir(clarin);
		this.clarin.addArticle(articulo1);
		
		assertEquals(clarin.getArticulos().size(), 1);
		assertTrue(labProgram.getArticulosDeInteres().contains(articulo1));
	}

}
