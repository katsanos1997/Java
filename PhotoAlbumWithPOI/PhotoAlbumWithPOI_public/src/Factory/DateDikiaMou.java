package Factory;

import java.util.Scanner;

public class DateDikiaMou {//interface h kapos allios
		private int day = 1;
		private int month = 1;
		private int year = 2010;
		private String date;
		
		public DateDikiaMou(){//na kitaksoume gia sfalmata
			while(true){
				try{
				System.out.println("give day-month-year");
				System.out.println("day : 01,02,03,04,05,06,07,08,09,10,11......31");
				System.out.println("month: 01,02,03,04,05,06,07,08,9,10,11,12");
				System.out.println("year: 1...10...2010...2016...9999");
				Scanner s = new Scanner(System.in);
				date = s.next();
				//for(int i=0;i<date.length();i++){
					//if(date.c == "-"){
					
					//}
				//}	
				String split[] = date.split("-");
				day = Integer.parseInt(split[0]);
				month = Integer.parseInt(split[1]);
				year = Integer.parseInt(split[2]);
				if((day>=01 || day<=31) && (month>=01 || month<=12 ) && (year>=1 || year<=9999 )){
					break;
				}
				System.out.println("Type the date again!");
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
		
		/*public DateDikiaMou(String date) { // Date
			if (date.contains("-")) {
				String split[] = date.split("-");
				day = Integer.parseInt(split[0]);
				month = Integer.parseInt(split[1]);
				year = Integer.parseInt(split[1]);
			}else if (date.contains("/")) {
				String split[] = date.split("/");
				day = Integer.parseInt(split[0]);
				month = Integer.parseInt(split[1]);
				year = Integer.parseInt(split[2]);
			}	
		}*/
		
	}