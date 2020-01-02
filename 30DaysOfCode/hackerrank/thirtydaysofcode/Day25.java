package hackerrank.thirtydaysofcode;

import java.util.Scanner;

public class Day25 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in); 
		int n = scan.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		scan.close();

		for (int i = 0; i < a.length; i++) {
			calculatePrime(a[i]);
		}
	}

	private static void calculatePrime(int n) {

		for(int i=2; i <= n/i; i++){
			if(n%i == 0) {
				n=1;
			}
		}

		if(n==1) {
			System.out.println("Not prime");
		}
		else {
			System.out.println("Prime");
		}
	}

}