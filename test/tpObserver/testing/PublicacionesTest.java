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
		 * En mi setUp creo un nuevo Sistema llamado Clarín con un artículo de Smalltalk publicado, 
		 * y como ahora labProgram se suscribirá y está interesado en eso, compruebo que el artículo se agregó a su lista
		 * de artículos de interés
		*/

		this.labProgram.suscribir(clarin);
		this.clarin.addArticle(articulo1);
		
		assertEquals(clarin.getArticulos().size(), 1);
		assertTrue(labProgram.getArticulosDeInteres().contains(articulo1));
	}

}
