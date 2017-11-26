package Pages;

import Date.Mydate;

public class BlankPage extends PageGeneral {

	public BlankPage(Mydate date,String keywords) {
		super("", date, keywords, "", "");
	}

	public void showDetails() {
		super.showDetails();
		System.out.println();
	}
	
	public  void changeFacts(){
		HelpChangeFacts();
	}
}
