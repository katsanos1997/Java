package Testers1;

import Album.AlbumGeneral;
import Date.Mydate;
import Main.MainEngine;
import Pages.TitlePage;

public class TestU1 {
	
	private static MainEngine z = new MainEngine();
	
	public static void CreateAnAlbumTester(){ //UseCase 1
		z.CreateAnAlbum();
	}
	
	public static void uc1Sinthetomeros(){
	    AlbumGeneral vasiko=new AlbumGeneral("mpampis");
	    //Mydate date,String keywords,String title
	    Mydate y=new Mydate();
	    TitlePage x = new TitlePage(y, "keywords", "title");
	    vasiko.addPage(x);
	    z.CreateAnAlbum(vasiko);
	}
}
