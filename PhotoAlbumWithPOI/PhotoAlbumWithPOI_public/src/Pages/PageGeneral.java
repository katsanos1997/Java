package Pages;

import java.util.Scanner;

import Date.Mydate;

public abstract class PageGeneral {

	private String text;
	private Mydate date;
	private String keywords;
	private String title;
	private String path;
	private int auksontasArithmos;
	
	public PageGeneral(String text, Mydate date, String keywords, String title,String path) {
		this.path=path;
		this.text = text;
		this.date = date;
		this.keywords = keywords;
		this.title = title;
	}
	
	public void setAuksontasArithmos(int x){
		auksontasArithmos=x;
	}
	
	public int getAuksontasArithmos(){
		return auksontasArithmos;
	}
	
	public abstract void changeFacts();
	
	public  void HelpChangeFacts(){
		System.out.println("Do u want to change the Date? y or n");
		Scanner s = new Scanner(System.in);
		String ssh = s.next();
		while (true) {
			if (ssh.equals("y" ) || ssh.equals("n" )){
				break;
			}else{
				ssh = s.next();
			}
		}
		if (ssh.equals("y")) {
			System.out.println("type the new date");
			Mydate d = new Mydate();
			setDate(d);
		}
		System.out.println("Do u want to change the keywords? y or n");
		String ssh0 = s.next();
		while (true) {
			if (ssh0.equals("y" ) || ssh0.equals("n" )){
				break;
			}else{
				ssh0 = s.next();
			}
		}
		if (ssh0.equals("y")) {
			System.out.println("type the new keywords");
			Scanner s2 = new Scanner(System.in);
			String title = new String();
			title=s2.nextLine();
			setKeywords(title);
			
		}
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void showDetails(){
		System.out.print("Date:" +date.returnDate() + " " + "Keywords:" + keywords );
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Mydate getDate() {
		return date;
	}

	public void setDate(Mydate date) {
		this.date = date;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}	
}