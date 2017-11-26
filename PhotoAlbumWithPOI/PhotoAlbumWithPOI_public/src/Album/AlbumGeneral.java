package Album;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xslf.usermodel.XMLSlideShow;

import Date.Mydate;
import src.poiExtractor.*;

import Pages.BlankPage;
import Pages.ContentPage;
import Pages.PageGeneral;
import Pages.PicturePage;
import Pages.TitlePage;

public class AlbumGeneral {
	private ArrayList<PageGeneral> AlbumArray;
	private String name;
	private int auksontasArithmos=0;

	public String getName() {
		return name;
	}
	
	public ArrayList<PageGeneral> getAlbumArray() {
		return AlbumArray;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public AlbumGeneral() {
		AlbumArray = new ArrayList<PageGeneral>();
	}
	public AlbumGeneral(String n) {
		AlbumArray = new ArrayList<PageGeneral>();
		name = n;
	}

	public void addPage(PageGeneral x) {
		AlbumArray.add(x);
		AlbumArray.get(AlbumArray.size()-1).setAuksontasArithmos(auksontasArithmos);
		auksontasArithmos++;
	}	
	
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
	
	public void extractByCreationTime() { //extract to ppt
		XMLSlideShow pptAlbum = new XMLSlideShow(); 
		int x=0;
		while(x<AlbumArray.size()){
		for (int i = 0; i < AlbumArray.size(); i++) {
			if(x==AlbumArray.get(i).getAuksontasArithmos()){
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				if (AlbumArray.get(i).getClass().equals(BlankPage.class)) {
					BlankPageExtractor bp = new BlankPageExtractor();
					bp.extractPageToPoi(pptAlbum);
				}else if (AlbumArray.get(i).getClass().equals(ContentPage.class)) {
					ContentPageExtractor cp = new ContentPageExtractor(AlbumArray.get(i).getTitle(),AlbumArray.get(i).getText() );
					cp.extractPageToPoi(pptAlbum);
				}else if (AlbumArray.get(i).getClass().equals(PicturePage.class)) {
					PicturePageWResizablePicExtractor pp = new PicturePageWResizablePicExtractor(AlbumArray.get(i).getTitle(), AlbumArray.get(i).getPath());
					pp.extractPageToPoi(pptAlbum);
				}else{
					 TitlePageExtractor tp = new TitlePageExtractor(AlbumArray.get(i).getTitle());
					 tp.extractPageToPoi(pptAlbum);
				}
				saveToFile(pptAlbum,name );
				System.out.println("Done with pptAlbum !");	
              ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			}
		}
		x++;
		}
	}

	public void extractByRealChronologicalTime() { //extract to ppt
		XMLSlideShow pptAlbum = new XMLSlideShow(); 
		sortAl();
		for(int i=0; i <AlbumArray.size() ; i++){
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			if (AlbumArray.get(i).getClass().equals(BlankPage.class)) {
				BlankPageExtractor bp = new BlankPageExtractor();
				bp.extractPageToPoi(pptAlbum);
			}else if (AlbumArray.get(i).getClass().equals(ContentPage.class)) {
				ContentPageExtractor cp = new ContentPageExtractor(AlbumArray.get(i).getTitle(),AlbumArray.get(i).getText() );
				cp.extractPageToPoi(pptAlbum);
			}else if (AlbumArray.get(i).getClass().equals(PicturePage.class)) {
				PicturePageWResizablePicExtractor pp = new PicturePageWResizablePicExtractor(AlbumArray.get(i).getTitle(), AlbumArray.get(i).getPath());
				pp.extractPageToPoi(pptAlbum);
			}else{
				 TitlePageExtractor tp = new TitlePageExtractor(AlbumArray.get(i).getTitle());
				 tp.extractPageToPoi(pptAlbum);
			}
			saveToFile(pptAlbum,name );
			System.out.println("Done with pptAlbum !");	
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		}
	}

	public void sortAl() {
		PageGeneral tmp;
		for (int i = 0; i < AlbumArray.size(); i++) {
			for (int j = 1; j < (AlbumArray.size() - i); j++) {
				if (AlbumArray.get(j-1).getDate().getYear() > AlbumArray.get(j).getDate().getYear()) {
					
					tmp = AlbumArray.get(j-1);
					AlbumArray.set(j-1, AlbumArray.get(j));
					AlbumArray.get(j-1).setAuksontasArithmos(AlbumArray.get(j).getAuksontasArithmos());
					AlbumArray.set(j, tmp);
				}
			}
		}
		for (int i = 0; i < AlbumArray.size(); i++) {
			for (int j = 1; j < (AlbumArray.size() - i); j++) {
				if (AlbumArray.get(j-1).getDate().getYear() == AlbumArray.get(j).getDate().getYear() 
						&& AlbumArray.get(j-1).getDate().getMonth() > AlbumArray.get(j).getDate().getMonth()) {
					
					tmp = AlbumArray.get(j-1);
					AlbumArray.set(j-1, AlbumArray.get(j));
					AlbumArray.get(j-1).setAuksontasArithmos(AlbumArray.get(j).getAuksontasArithmos());
					AlbumArray.set(j, tmp);
				}
			}
		}
		for (int i = 0; i < AlbumArray.size(); i++) {
			for (int j = 1; j < (AlbumArray.size() - i); j++) {
				if (AlbumArray.get(j-1).getDate().getYear() == AlbumArray.get(j).getDate().getYear() 
						&& AlbumArray.get(j-1).getDate().getMonth() == AlbumArray.get(j).getDate().getMonth()
						&& AlbumArray.get(j-1).getDate().getDay() > AlbumArray.get(j).getDate().getDay() ) {
					
					tmp = AlbumArray.get(j-1);
					AlbumArray.set(j-1, AlbumArray.get(j));
					AlbumArray.get(j-1).setAuksontasArithmos(AlbumArray.get(j).getAuksontasArithmos());
					AlbumArray.set(j, tmp);
				}
			}
		}
	}

	public void showPages() {
		for(int i=0 ; i<AlbumArray.size();i++){
			System.out.print("page " + i + " : " );
			AlbumArray.get(i).showDetails();
		}
	}
	
	public boolean findKeywords(String k) {//exei vrei to keyword sto album auto
		for (int i = 0; i < AlbumArray.size(); i++){
				String[] x=AlbumArray.get(i).getKeywords().split(" ");
				for(int q=0 ; q<x.length;q++){
					if(x[q].equals(k)){
						return true;
					}
				}
		}
		return false;
	}
	
	//epistrefi to paragogo album pou prokipti apo to AlbumArray 
	public ArrayList<PageGeneral> returnParagogo(String k) {
		ArrayList<PageGeneral> paragogo=new ArrayList<PageGeneral>();
		for (int i = 0; i < AlbumArray.size(); i++){
			String[] x=AlbumArray.get(i).getKeywords().split(" ");
			for(int q=0 ; q<x.length;q++){
				if(x[q].equals(k)){
					paragogo.add(AlbumArray.get(i));
				}
			}
		}
		return paragogo;
	}	

	public void createBP(Mydate date,String keywords) {
		BlankPage newBlankPage = new BlankPage(date,keywords);
		addPage(newBlankPage);
	}

	public void createCP(String text, Mydate date, String keywords, String title) {
		ContentPage newContentPage = new ContentPage(text, date, keywords, title);
		addPage(newContentPage);
	}

	public void createPP(Mydate date, String keywords, String title, String path) {
		PicturePage newPicturePage = new PicturePage(date, keywords, title, path);
		addPage(newPicturePage);
	}

	public void createTP(Mydate date,String keywords,String title) {
		TitlePage newTitlePage = new TitlePage(date,keywords,title);
		addPage(newTitlePage);
	}
}
