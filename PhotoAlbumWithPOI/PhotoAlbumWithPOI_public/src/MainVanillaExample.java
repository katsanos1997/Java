
//The following 3 imports are only for the commented-out code
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xslf.usermodel.XMLSlideShow;

import src.poiExtractor.*;

/*
 * This is just a "silly" example to show you how to use the src.poiExtractor package.
 * Your code in this package should act as the front-end of the application. 
 * You main() method must be drastically different than this one. 
 */
public class MainVanillaExample {

	public static void main(String[] args) {
		TitlePageExtractor tp = new TitlePageExtractor("This is a title");
		ContentPageExtractor cp = new ContentPageExtractor("a title", "a text");
		PicturePageExtractor pp = new PicturePageExtractor("image", "resources/amolad.jpg");
		BlankPageExtractor bp = new BlankPageExtractor();

/*
 * If you comment this out, you can try an even simpler example
 * without AlbumExtractor.
 * Remember to uncomment the method underneath main() too.
 *
		XMLSlideShow pptVanilla = new XMLSlideShow(); 
		tp.extractPageToPoi(pptVanilla);		
		cp.extractPageToPoi(pptVanilla);
		pp.extractPageToPoi(pptVanilla);
		bp.extractPageToPoi(pptVanilla);
		saveToFile(pptVanilla, "tryVanilla");
		System.out.println("Done with vanilla example!");
*/		
		AlbumExtractor albumExtractor = new AlbumExtractor("tryAExtr");
		albumExtractor.addSlideExtractor(tp);
		albumExtractor.addSlideExtractor(cp);
		albumExtractor.addSlideExtractor(pp);
		albumExtractor.addSlideExtractor(bp);
		albumExtractor.exportPOISlideShow();
		System.out.println("Done with AE example!");
		
		
}


/*
 * Useful only if you uncomment the extremely simple example without the AlbumExtractor
 * 
	private static void saveToFile(XMLSlideShow ppt, String filename) {
	    try {
	    	if(filename.endsWith(".pptx") == false) {
	    		filename += ".pptx";
	    	}
	    	System.out.println("Outputing " + ppt.getSlides().size() + " slides");
	    	FileOutputStream out = new FileOutputStream(filename);
	        ppt.write(out);
			out.close();
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}
*/
}
