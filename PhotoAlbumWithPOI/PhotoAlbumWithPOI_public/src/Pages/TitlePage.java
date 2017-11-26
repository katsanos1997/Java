package Pages;

import java.util.Scanner;

import Date.Mydate;

public class TitlePage extends PageGeneral {

	public TitlePage(Mydate date,String keywords,String title) {
		super("", date, keywords,title, "");
	}

	public void showDetails() {
		super.showDetails();
		System.out.print(" Title:" + getTitle() + "\n");
	}

	public void changeFacts() {
		HelpChangeFacts();
		Scanner s = new Scanner(System.in);
		System.out.println("Do u want to change the title ? y or n");
		String ssh1 = s.next();
		//problem
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
	}
}
