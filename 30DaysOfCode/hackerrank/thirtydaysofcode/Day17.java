package hackerrank.thirtydaysofcode;
import java.util.Scanner;

class NegativeInputException extends Exception {

	private static final long serialVersionUID = 1L;
	String m_failure_text = "";

	public NegativeInputException(String failure_text) {
		super(failure_text);
		this.m_failure_text = failure_text;
	}
}

class Calculator {

	public int power(int n, int p) throws NegativeInputException {

		int result = 0;

		if( n<0 || p<0){
			throw new NegativeInputException("n and p should be non-negative");
		}
		else
		{
			result = (int) Math.pow(n, p);
		}

		return result;
	}

}

class Day17 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {

			int n = in.nextInt();
			int p = in.nextInt();
			Calculator myCalculator = new Calculator();
			try {
				int ans = myCalculator.power(n, p);
				System.out.println(ans);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		in.close();
	}
}
