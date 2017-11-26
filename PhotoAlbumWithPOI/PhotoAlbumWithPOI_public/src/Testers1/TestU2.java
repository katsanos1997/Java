package Testers1;

import Album.AlbumGeneral;
import Date.Mydate;
import Main.MainEngine;
import Pages.TitlePage;

public class TestU2 {

	private static MainEngine z = new MainEngine();
	
	public static void manageAnAlbumTester(){ //UseCase 2
		//tha tou dosoume ena album
		z.manageAnAlbum();
	}
	
	public static void uc2Sinthetomeros(){
	    AlbumGeneral vasiko=new AlbumGeneral("mpampis");
	    //Mydate date,String keywords,String title
	    Mydate y=new Mydate();
	    TitlePage x = new TitlePage(y, "keywords", "title1");
	    vasiko.addPage(x);
	    z.CreateAnAlbum(vasiko);
	    
	    Mydate l=new Mydate();
	    TitlePage p = new TitlePage(l, "keywords1", "title2");
	    vasiko.addPage(p);
	    z.CreateAnAlbum(vasiko);
	    
	    z.manageAnAlbum();
	}
}
