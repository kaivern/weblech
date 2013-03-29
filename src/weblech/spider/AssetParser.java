package weblech.spider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import weblech.ui.LechLogger;

public class AssetParser implements WebParser {

	private Pattern imgPattern;

	public AssetParser() {
		imgPattern = Pattern.compile("(\\(|'|\")[-/\\w\\\\\\.]+\\.(png|jpg|gif|bmp|woff|ttf|eot)(\\)|'|\")",
				Pattern.CASE_INSENSITIVE);
	}

	@Override
	public List parseLinksInDocument(URL sourceURL, String textContent) {
		LechLogger.debug("parseAsCSS()");
		Set newURLs = new HashSet();
		Set newImgs = new HashSet();
		Matcher m = imgPattern.matcher(textContent);
		while (m.find()) {
			String img = m.group();
			System.out.println(img);
			img = img.substring(1, img.length() - 1);
			if (!newImgs.contains(img)) {
				newImgs.add(img);
				try {
					URL u = new URL(sourceURL, img);
					newURLs.add(u);
				} catch (MalformedURLException e) {
					LechLogger.warn(e.getMessage());
				}
			}
		}
		return new ArrayList(newURLs);
	}
	
	public static void main(String[] args){
		String c  = "{image : \"img\\kazvan-1.jpg\", title : 'Image Credit: Maria Kazvan'}, " +
					"{image : 'img/kazvan-2.jpg', title : 'Image Credit: Maria Kazvan'}, " +
					"{image : 'img/kazvan-3.jpg', title : 'Image Credit: Maria Kazvan'}, " +
					"{image : 'img/wojno1.jpg', title : 'Image Credit: Colin Wojno'}, " +
					"{image : 'img/wojno-3.jpg', title : 'Image Credit: Colin Wojno'}, " + 
					"url(../img/progress.gif)";
		AssetParser parser = new AssetParser();
		List list = null;
		try {
			list = parser.parseLinksInDocument(new URL("http://localhost/weblech/main.css"), c);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println(list);
	}
}
