package Testers1;

public class ALL_UCtest {

	public static void main(String[] args) {
		//=====================================================vasiko komati tou test
		
			System.out.println( "kalitera na kaneis kathe test ksexorista");
		
			TestU1 z=new TestU1();
			System.out.println( "\n" +"CreateAnAlbumTester()");
		    z.CreateAnAlbumTester(); //uc1
		    
		    TestU2 q=new TestU2();
		    System.out.println( "\n" +"manageAnAlbumTester()");
			q.manageAnAlbumTester(); //uc2
			
			TestU3 t=new TestU3();
			System.out.println( "\n" +"editPagesTester()");
			t.editPagesTester();     //uc3
		//=====================================================sintheto komati tou test
			
			System.out.println("\n" + "uc1Sinthetomeros()");
			z.uc1Sinthetomeros();  // uc1
			
			System.out.println( "\n" +"uc2Sinthetomeros()");
			q.uc2Sinthetomeros();  //uc2
			
			System.out.println( "\n" +"uc3Sinthetomeros()");
			t.uc3Sinthetomeros();	 //uc3
	}
}
