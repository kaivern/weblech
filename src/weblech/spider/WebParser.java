package weblech.spider;

import java.net.URL;
import java.util.List;

public interface WebParser {
	
	public List parseLinksInDocument(URL sourceURL, String textContent);
	
}
