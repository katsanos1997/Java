//Katsanos Dimitris 2998 ,Xinos Thanasis 3052 ,team 89
package Main;
import java.util.ArrayList;
import java.util.Scanner;

import Album.AlbumGeneral;
import Date.Mydate;
import Pages.PageGeneral;

public class MainEngine {
	private static ArrayList<AlbumGeneral> Albums = new ArrayList<AlbumGeneral>();

	public static void showAlbums() {
		for (int i = 0; i < Albums.size(); i++) {
			System.out.println("Album " + i + " : " + Albums.get(i).getName());
		}
	}

	public static int findAlbumName(String name) {
		int j = 0;
		boolean flag1 = false;
		for (int i = 0; i < Albums.size(); i++) {
			if (name.equals(Albums.get(i).getName())) {
				j = i;
				flag1 = true;
				break;
			}
		}
		if (flag1 == false) {
			System.out.println("This album doesnt exist");
			j = -1;
		}
		return j;
	}

	public static void searchAndCreateAlbum(String keywords, String nameGiaNewAlbum) {
		AlbumGeneral paragogo1 = new AlbumGeneral(nameGiaNewAlbum);

		ArrayList<PageGeneral> paragogo = new ArrayList<PageGeneral>();
		boolean AnDenUparxeiToKeywordsNaMinFtiaxneiParagogo = false;
		for (int i = 0; i < Albums.size(); i++) {
			if (Albums.get(i).findKeywords(keywords) == true) {
				paragogo.addAll(Albums.get(i).returnParagogo(keywords));
				AnDenUparxeiToKeywordsNaMinFtiaxneiParagogo = true;
			}
		}
		for (int i = 0; i < paragogo.size(); i++) {
			paragogo1.addPage(paragogo.get(i));
		}
		if (AnDenUparxeiToKeywordsNaMinFtiaxneiParagogo == true) {
			Albums.add(paragogo1);
		} else {
			System.out.println("This keyword doesn't exist and an album cant be created!");
		}
	}

	public static void addEmptyAlbum() {
		System.out.println("give the name of the new basic album");
		Scanner s = new Scanner(System.in);
		String ssh = s.next();
		AlbumGeneral Album = new AlbumGeneral(ssh);// AlbumGeneral
		Albums.add(Album);
	}

	public static void CreateAnAlbum() {
		Scanner s = new Scanner(System.in);
		System.out.println("What kind of album do u want to create? b:Basic p:Produced");
		String w = s.next();
		while (true) {
			if (w.equals("b") || w.equals("p")) {
				break;
			} else {
				System.out.println("Try again!!");
				w = s.next();
			}
		}
		if (w.equals("b")) { // b:Basic
			addEmptyAlbum();
			System.out.println("The album has been created");
		} else { // p:Produced
			if (Albums.size() != 0) {
				System.out.println("Give the keywords u want");
				String k = s.next();
				System.out.println("Give the name of the new album you want to create");
				String n = s.next();
				searchAndCreateAlbum(k, n);
			} else {
				System.out.println("There is no existing album");
			}
		}
	}

	public static void editPages() {
		Scanner s = new Scanner(System.in);
		System.out.println("What kind of actions do you want to do with the pages?" + "\n"
				+ "a:add a page to an existing album c:change the facts of a certain page");
		String w = s.next();
		while (true) {
			if (w.equals("a") || w.equals("c")) {
				break;
			} else {
				System.out.println("Try again!!");
				w = s.next();
			}
		}
		// ---------------------------------------------------------------------------a
		// add a page to an existing album
		if (w.equals("a")) {
			System.out.println("This is a list of the existing albums: ");
			showAlbums();
			System.out.println("Give the name of an existing album where you want to add a page");
			String name = s.next();
			int j = 0;
			boolean flag1 = false;
			for (int i = 0; i < Albums.size(); i++) {
				if (name.equals(Albums.get(i).getName())) {
					j = i;
					flag1 = true;
					break;
				}
			}
			if (flag1 == false) {
				System.out.println("This album doesnt exist");
			} else {
				while (true) {
					System.out.println(
							"What kind of page do u want to add? 1:BlankPage 2:TitlePage 3:PicturePage 4:TextPage");
					String w2 = s.next();
					while (true) {
						if (w2.equals("1") || w2.equals("2") || w2.equals("3") || w2.equals("4")) {
							break;
						} else {
							System.out.println("Try again!!");
							w2 = s.next();
						}
					}
					if (w2.equals("1")) {
						Mydate date = new Mydate();
						System.out.println("Give keywords for the page");
						Scanner s1 = new Scanner(System.in);
						String keywords = new String();
						keywords = s1.nextLine();
						Albums.get(j).createBP(date, keywords);
					} else if (w2.equals("2")) {
						Mydate date = new Mydate();
						System.out.println("Give keywords for the page");

						Scanner s12 = new Scanner(System.in);
						String keywords = new String();
						keywords = s12.nextLine();
						System.out.println("Give the title of the page");
						Scanner s1 = new Scanner(System.in);
						String title = new String();
						title = s1.nextLine();
						Albums.get(j).createTP(date, keywords, title);
					} else if (w2.equals("3")) {
						Mydate date = new Mydate();
						System.out.println("Give keywords for the page");
						Scanner s13 = new Scanner(System.in);
						String keywords = new String();
						keywords = s13.nextLine();
						System.out.println("Give the title of the page");
						Scanner s1 = new Scanner(System.in);
						String title = new String();
						title = s1.nextLine();
						System.out.println("Give the name of the photograph you want to add." + "\n"
								+ "You have 5 photos : team89 or ergasiakxara or perfect or alpha or beta ");
						String path = s.next();
						while (true) {
							if (path.equals("team89") || path.equals("ergasiakxara") || path.equals("perfect")
									|| path.equals("alpha") || path.equals("beta")) {
								break;
							} else {
								System.out.println("Type the name of the photogragh again!!");
								path = s.next();
							}
						}
						Albums.get(j).createPP(date, keywords, title, "resources/" + path + ".jpg");
					} else {
						Mydate date = new Mydate();
						System.out.println("Give keywords for the page");
						Scanner s11 = new Scanner(System.in);
						String keywords = new String();
						keywords = s11.nextLine();

						System.out.println("Give the title of the page");
						Scanner s1 = new Scanner(System.in);
						String title = new String();
						title = s1.nextLine();

						System.out.println("Type the text");
						Scanner s2 = new Scanner(System.in);
						String text = new String();
						text = s2.nextLine();

						Albums.get(j).createCP(text, date, keywords, title);
					}
					System.out.println("Do u want to add another page? y or n");
					Scanner s5 = new Scanner(System.in);
					String ssh = s5.next();
					while (true) {
						if (ssh.equals("y") || ssh.equals("n")) {
							break;
						} else {
							ssh = s.next();
						}
					}
					if (ssh.equals("y") == false) {
						break;
					}

				}
			}
		}
		// ----------------------------------------------------------------------------c
		// change the facts of a certain page
		else {
			System.out.println("This is a list of the existing albums: ");
			showAlbums();
			System.out.println("Give the name of an existing album where you want to change the facts of a page");
			String name = s.next();
			int j = 0;
			boolean flag1 = false;
			for (int i = 0; i < Albums.size(); i++) {
				if (name.equals(Albums.get(i).getName())) {
					j = i;
					flag1 = true;
					break;
				}
			}
			if (flag1 == false) {
				System.out.println("This album doesnt exist");
			} else {
				System.out.println("Now u must find the page you're looking for");
				System.out.println("These are the pages existing in this album and their facts: ");
				for (int i = 0; i < Albums.get(j).getAlbumArray().size(); i++) {
					System.out.print("Album : " + i + " ");
					Albums.get(j).getAlbumArray().get(i).showDetails();
				}

				System.out.println("Now u must determine the page");
				System.out.println("Give page number : 0-" + (Albums.get(j).getAlbumArray().size() - 1));
				try {
					Scanner s2 = new Scanner(System.in);
					String ap;
					int k = 0;
					while (true) {
						ap = s2.nextLine();
						if (Integer.parseInt(ap) >= 0 && Integer.parseInt(ap) < Albums.get(j).getAlbumArray().size()) {
							break;
						} else {
							System.out.println("This page doesnt exist!");
							k = -1;
						}

					}
					if (k == 0) {
						Albums.get(j).getAlbumArray().get(Integer.parseInt(ap)).changeFacts();
					}
				} catch (Exception e) {
					System.out.println("Oops!");
				}
			}
		}
	}

	public static void manageAnAlbum() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("What action do u want to take with the albums?" + "\n"
				+ "1:extract the contents of an album based on the time that they were added to them"
				+ " 2:extract the contents of an album based on their real chronological time" +"\n"+ "3:Show the list of the albums");
		String w4 = s.next();
		while (true) {
			if (w4.equals("1") || w4.equals("2") || w4.equals("3")) {
				break;
			} else {
				System.out.println("Try again!!");
				w4 = s.next();
			}
		}
		if (w4.equals("1")) {// 1:see the contents of the albums based on the
						     // time that they were added to them
			System.out.println("This is a list of the existing albums: ");
			showAlbums();
			System.out.println("Give the name of an existing album");
			String name = s.next();
			int x = findAlbumName(name);
			if (x != -1) {
				Albums.get(x).extractByCreationTime();
			}
		} else if(w4.equals("2")){ // 2:see the contents of the albums based on their real
					               // chronological time
			System.out.println("This is a list of the existing albums: ");
			showAlbums();
			System.out.println("Give the name of an existing album");
			String name = s.next();
			int x = findAlbumName(name);
			if (x != -1) {
				Albums.get(x).extractByRealChronologicalTime();
			}
		}else{
			System.out.println("This is a list of the existing albums: ");
			showAlbums();
		}
	}
	
	
	
	//==========================================geia test
	
	//gia test paragogou
	public static void CreateAnAlbum(AlbumGeneral vasiko) {
		    // p:Produced
		    Albums.add(vasiko);
		    Scanner s = new Scanner(System.in);
			if (Albums.size() != 0) {
				System.out.println("Give the keywords u want");
				String k = s.next();
				System.out.println("Give the name of the new album you want to create");
				String n = s.next();
				searchAndCreateAlbum(k, n);
			} else {
				System.out.println("There is no existing album");
			}
		}
	//==========================================================
}