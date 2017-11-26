package src.poiExtractor;


import org.apache.poi.xslf.usermodel.XMLSlideShow;

public class BlankPageExtractor implements IPageExtractorToPoi {
	
	public BlankPageExtractor() {
		;
	}
	
	public void extractPageToPoi(XMLSlideShow ppt) {
		ppt.createSlide();
	}

}