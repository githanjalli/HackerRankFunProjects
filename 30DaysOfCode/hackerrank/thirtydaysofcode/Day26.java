package hackerrank.thirtydaysofcode;

import java.util.Scanner;

public class Day26 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int actualDay = scan.nextInt();
		int actualMonth = scan.nextInt();
		int actualYear = scan.nextInt();
		int expectedDay = scan.nextInt();
		int expectedMonth = scan.nextInt();
		int expectedYear = scan.nextInt();
		scan.close();

		int diffDays = actualDay - expectedDay;
		int diffMonths = actualMonth - expectedMonth;
		int diffYear = actualYear - expectedYear;
		
		int fine = 0;
		
		if(actualYear - expectedYear > 0 )
		{
			fine = 10000;
		}	
		if(actualMonth - expectedMonth > 0 && diffYear == 0)
		{
			fine = diffMonths * 500;
		}
		if(actualDay - expectedDay > 0 && diffYear == 0  && diffMonths == 0)
		{
			fine = diffDays * 15;
		}
		
		System.out.println(fine);
	}
}
