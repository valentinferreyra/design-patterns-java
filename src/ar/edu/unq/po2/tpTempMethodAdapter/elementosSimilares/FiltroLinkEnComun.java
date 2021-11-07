package ar.edu.unq.po2.tpTempMethodAdapter.elementosSimilares;

import java.util.ArrayList;
import java.util.List;

public class FiltroLinkEnComun extends FiltroWikipedia {

	public FiltroLinkEnComun() {
		super();
	}
	
	@Override
	public List<WikipediaPage> getSimilarPages(WikipediaPage page, List<WikipediaPage> wikipedia) {
		List<WikipediaPage> list = new ArrayList<WikipediaPage>();
		
		for(WikipediaPage wiki : wikipedia) {
			if(wiki.getLinks().contains(page)) {
				list.add(wiki);
			}
		}
		
		return list;
	}

}
