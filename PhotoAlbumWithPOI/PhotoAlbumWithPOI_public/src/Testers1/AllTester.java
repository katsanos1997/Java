package Testers1;

import java.util.Scanner;

import Album.AlbumGeneral;
import Date.Mydate;
import Main.MainEngine;
import Pages.TitlePage;

public class AllTester { //MainEngineTest

private static MainEngine z = new MainEngine();
	//=====================================================vasiko komati tou test

	public static void CreateAnAlbumTester(){ //UseCase 1
		z.CreateAnAlbum();
	}
	
	public static void manageAnAlbumTester(){ //UseCase 2
		//tha tou dosoume ena album
		z.manageAnAlbum();
	}
	
	public static void editPagesTester(){ //UseCase 3
		//tha tou dosoume ena album
		z.editPages();
	}
	                               //UseCase 4
	//to exit den thelei tester
	
	
	//=====================================================sintheto komati tou test
	
	public static void uc1Sinthetomeros(){
	    AlbumGeneral vasiko=new AlbumGeneral("mpampis");
	    //Mydate date,String keywords,String title
	    Mydate y=new Mydate();
	    TitlePage x = new TitlePage(y, "keywords", "title");
	    vasiko.addPage(x);
	    z.CreateAnAlbum(vasiko);
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
	
	public static void uc3Sinthetomeros(){
		AlbumGeneral vasiko=new AlbumGeneral("mpampis");
		z.CreateAnAlbum(vasiko);
		z.editPages();
	}
	
	//to exit den thelei tester
	
	//======================================================h main pou kanei ta test
	public static void main(String[] args) {
		//=====================================================vasiko komati tou test
		
			System.out.println( "kalitera na kaneis kathe test ksexorista");
		
			System.out.println( "\n" +"CreateAnAlbumTester()");
		    CreateAnAlbumTester(); //uc1
		    
		    System.out.println( "\n" +"manageAnAlbumTester()");
			manageAnAlbumTester(); //uc2
			
			System.out.println( "\n" +"editPagesTester(");
			editPagesTester();     //uc3
		//=====================================================sintheto komati tou test
			
			System.out.println("\n" + "uc1Sinthetomeros()");
			uc1Sinthetomeros();  // uc1
			
			System.out.println( "\n" +"uc2Sinthetomeros()");
			uc2Sinthetomeros();  //uc2
			
			System.out.println( "\n" +"uc3Sinthetomeros()");
			uc3Sinthetomeros();	 //uc3
	}
}