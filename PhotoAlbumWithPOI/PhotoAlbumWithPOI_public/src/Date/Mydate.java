package Date;

import java.util.Scanner;

public class Mydate {
		private int day = 1;
		private int month = 1;
		private int year = 2010;
		private String date;
		
		public Mydate(){
			boolean flag=true;
			while(flag){
				try{
				System.out.println("give day-month-year");
				System.out.print("day : 1,2...11...31 ");
				System.out.print("month: 1,2...12 ");
				System.out.print("year: 1...10...2010...2016...9999" +"\n");
				Scanner s = new Scanner(System.in);
				date = s.next();
				String split[] = date.split("-");
				day = Integer.parseInt(split[0]);
				month = Integer.parseInt(split[1]);
				year = Integer.parseInt(split[2]);
				if((day>=1 && day<=31) && (month>=1 && month<=12 ) && (year>=1 && year<=9999 )){
					flag=false;
				}
				}catch(Exception e){
					System.out.println("Type the date again!");
				}
			}	
		}
		
		public String returnDate() {
			return  date ;
		}

		public int getDay() {
			return day;
		}

		public int getMonth() {
			return month;
		}

		public int getYear() {
			return year;
		}
	}