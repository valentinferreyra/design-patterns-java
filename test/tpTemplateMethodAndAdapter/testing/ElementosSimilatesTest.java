package tpTemplateMethodAndAdapter.testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpTempMethodAdapter.elementosSimilares.FiltroLinkEnComun;
import ar.edu.unq.po2.tpTempMethodAdapter.elementosSimilares.FiltroMismaLetraInicial;
import ar.edu.unq.po2.tpTempMethodAdapter.elementosSimilares.FiltroPropiedadEnComun;
import ar.edu.unq.po2.tpTempMethodAdapter.elementosSimilares.WikipediaPage;

class ElementosSimilatesTest {
	
	private FiltroMismaLetraInicial mismaLetra;
	private FiltroLinkEnComun linkEnComun;
	private FiltroPropiedadEnComun propiedadEnComun;
	private WikipediaPage page1;
	private WikipediaPage page2;
	private WikipediaPage page3;
	private WikipediaPage page4;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.mismaLetra       = new FiltroMismaLetraInicial();
		this.linkEnComun      = new FiltroLinkEnComun();
		this.propiedadEnComun = new FiltroPropiedadEnComun();
		
		this.page1 = mock(WikipediaPage.class);
		this.page2 = mock(WikipediaPage.class);
		this.page3 = mock(WikipediaPage.class);
		this.page4 = mock(WikipediaPage.class);
	}

	@Test
	void testUnFiltroWikipediaPuedeFiltrarConLaMismaLetraInicial() {
		List<WikipediaPage> pages = Arrays.asList(page2, page3, page4);
		
		when(page1.getTitle()).thenReturn("Lobos");
		when(page2.getTitle()).thenReturn("Ramos Mejia");
		when(page3.getTitle()).thenReturn("Lucas Art");
		when(page4.getTitle()).thenReturn("La Plata");
		
		List<WikipediaPage> filtroBusqueda = mismaLetra.getSimilarPages(page1, pages);
		
		assertEquals(filtroBusqueda.size(), 2, "Error en filtrar por letra inicial");
	}
	
	@Test 
	void testUnFiltroWikipediaPuedeFiltrarConLinkEnComun() {
		List<WikipediaPage> pages = Arrays.asList(page2, page3, page4);
		
		List<WikipediaPage> pagesCompartidos = Arrays.asList(page2);
		
		when(page3.getLinks()).thenReturn(pagesCompartidos);
		when(page4.getLinks()).thenReturn(pagesCompartidos);
		
		// tanto page3 como page4 tienen a page2 como page compartido		
		List<WikipediaPage> pageSimilares = linkEnComun.getSimilarPages(page2, pages);
		
		assertEquals(pageSimilares.size(), 2, "Erro en filtrar por link en común");		
	}
	
	@Test
	void testUnFiltroWikipediaPuedeFiltrarConPropiedadEnComun() {
		List<WikipediaPage> pages = Arrays.asList(page1, page2, page3);
		
		Map<String, WikipediaPage> propiedadesPag1 = new HashMap<String, WikipediaPage>();
		Map<String, WikipediaPage> propiedadesPag2 = new HashMap<String, WikipediaPage>();
		Map<String, WikipediaPage> propiedadesPag3 = new HashMap<String, WikipediaPage>();
		
		propiedadesPag1.put("birth_place", page1);
		propiedadesPag2.put("birth_place", page2);
		propiedadesPag3.put("birth", page3);
		
		when(page1.getInfobox()).thenReturn(propiedadesPag1);
		when(page2.getInfobox()).thenReturn(propiedadesPag2);
		when(page3.getInfobox()).thenReturn(propiedadesPag3);
		
		
		// page1 tiene "birth_place" como atributo, y pages tiene a page1, page2 (tambien tiene ese atributo) y page3
		List<WikipediaPage> pagesRelacionados = propiedadEnComun.getSimilarPages(page1, pages);
		
		assertEquals(pagesRelacionados.size(), 2, "Error en filtrar por propiedad en común");
	}

}
