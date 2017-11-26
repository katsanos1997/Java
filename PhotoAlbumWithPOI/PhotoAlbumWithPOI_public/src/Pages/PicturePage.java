package Pages;

import java.util.Scanner;

import Date.Mydate;

public class PicturePage extends PageGeneral {

	public PicturePage(Mydate date, String keywords, String title, String path) {
		super("", date, keywords, title, path);
	}
	
	public void showDetails() {
		super.showDetails();
		System.out.print(" Title:" + getTitle() + " " + "Picture: " + getPath()+ "\n");
	}
	
	public void changeFacts() {
		super.HelpChangeFacts();
		Scanner s = new Scanner(System.in);
		System.out.println("Do u want to change the title ? y or n");
		String ssh1 = s.next();
		while (true) {
			if (ssh1.equals("y" ) || ssh1.equals("n" )){
				break;
			}else{
				ssh1 = s.next();
			}
		}
		if (ssh1.equals("y")) {
			System.out.println("type the new title");
			Scanner s2 = new Scanner(System.in);
			String title = new String();
			title=s2.nextLine();
			setTitle(title);
		}
		System.out.println("Do u want to change the picture ? y or n");
		String ssh2 = s.next();
		while (true) {
			if (ssh2.equals("y" ) || ssh2.equals("n" )){
				break;
			}else{
				ssh2 = s.next();
			}
		}
		if (ssh2.equals("y")) {
			System.out.println("Give the name of the new photograph." + "\n" + "You have 5 photos : team89 or ergasiakxara or perfect or alpha or beta ");
			String p=s.next();
			setPath(p);
		}
	}
}
