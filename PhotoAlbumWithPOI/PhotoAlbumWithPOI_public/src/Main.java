import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		MainEngine z=new MainEngine();
		System.out.println("Welcome, this is a programm which manages albums." +  "\n" + "created by Katsanos Dimitris and Xynos Thanasis"+"\n");
		boolean flag = true;
		while (flag) {
			System.out.println("What do u want to do?" +"\n"+ "1:Create an Album 2:Edit Pages of an existing Album 3:Manage an Album(see the list of albums or their content classified) 4:Exit");
			Scanner s = new Scanner(System.in);
			String q=s.next();
			while (true) {
				if (q.equals("1" ) || q.equals("2" )|| q.equals("3" )|| q.equals("4" )){
					break;
				}else{
					System.out.println("Try again!!");
					q = s.next();
				}
			}
			//////////////////////////////////////////////////////////////////////////1 Create an Album
			if (q.equals("1")) {
				z.CreateAnAlbum();
			}
			//////////////////////////////////////////////////////////////////////////2  Edit Pages of an existing Album
			else if(q.equals("2")){
				z.editPages();
			}
			//////////////////////////////////////////////////////////////////////////////////////3	 Manage an Album
			else if(q.equals("3")){
				z.manageAnAlbum();
			}
			//////////////////////////////////////////////////////////////////////////////////////4 Exit
			else{
				break; //or flag =false
			}
		}
	}
}