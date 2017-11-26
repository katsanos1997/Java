package Pages;

import java.util.Scanner;

import Date.Mydate;

public class ContentPage extends PageGeneral { // selida keimenou
	public ContentPage(String s1, Mydate s2, String s3, String s4) {
		super(s1, s2, s3, s4, "");
	}

	public void showDetails() {
		super.showDetails();
		System.out.print(" Title:" + getTitle() +  " Text:" + getText()+ "\n");
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
		if (ssh1.equals("y")){
			System.out.println("type the new title");
			Scanner s2 = new Scanner(System.in);
			String title = new String();
			title=s2.nextLine();
			setTitle(title);
		}
		System.out.println("Do u want to change the text ? y or n");
		String ssh3 = s.next();
		while (true) {
			if (ssh3.equals("y" ) || ssh3.equals("n" )){
				break;
			}else{
				ssh3 = s.next();
			}
		}
		if (ssh3.equals("y")){
			System.out.println("type the new text");
			Scanner s2 = new Scanner(System.in);
			String text = new String();
			text=s2.nextLine();
			setText(text);
		}
	}
}
