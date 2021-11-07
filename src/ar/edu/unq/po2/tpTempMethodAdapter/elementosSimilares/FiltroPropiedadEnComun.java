package ar.edu.unq.po2.tpTempMethodAdapter.elementosSimilares;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FiltroPropiedadEnComun extends FiltroWikipedia {

	public FiltroPropiedadEnComun() {
		super();
	}
	
	@Override
	public List<WikipediaPage> getSimilarPages(WikipediaPage page, List<WikipediaPage> wikipedia) {
		List<WikipediaPage> list = new ArrayList<WikipediaPage>();
		
		for(WikipediaPage wiki : wikipedia) {
			if(this.contieneAlguno(wiki.getInfobox().keySet(), page.getInfobox().keySet())){
				list.add(wiki);
			}
		}
		return list;
	}

	private boolean contieneAlguno(Set<String> keySet1, Set<String> keySet2) {
		for(Object key : keySet1.toArray()) {
			if(keySet2.contains(key)) {
				return true;
			}
		}
		return false;
	}
}
