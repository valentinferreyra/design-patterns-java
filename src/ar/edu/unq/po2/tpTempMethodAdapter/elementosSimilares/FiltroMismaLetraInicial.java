package ar.edu.unq.po2.tpTempMethodAdapter.elementosSimilares;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroMismaLetraInicial extends FiltroWikipedia {
	
	public FiltroMismaLetraInicial() {
		super();
	}

	@Override
	public List<WikipediaPage> getSimilarPages(WikipediaPage page, List<WikipediaPage> wikipedia) {
		Character firstLetter = page.getTitle().charAt(0);
		
		List<WikipediaPage> list = wikipedia.stream(). 
				                   filter(p -> p.getTitle().charAt(0) == firstLetter). 
				                   collect(Collectors.toList());
		
		return list;
	}

	
}
