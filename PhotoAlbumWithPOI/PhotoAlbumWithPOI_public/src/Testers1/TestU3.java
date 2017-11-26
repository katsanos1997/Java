package Testers1;

import Album.AlbumGeneral;
import Main.MainEngine;

public class TestU3 {

	private static MainEngine z = new MainEngine();
	
	public static void editPagesTester(){ //UseCase 3
		//tha tou dosoume ena album
		z.editPages();
	}
	
	public static void uc3Sinthetomeros(){
		AlbumGeneral vasiko=new AlbumGeneral("mpampis");
		z.CreateAnAlbum(vasiko);
		z.editPages();
	}
}
