package hackerrank.thirtydaysofcode;
import java.util.Scanner;

public class Day6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int m_split_spaces = scanner.nextInt(); //2

		for(int i = 0; i < m_split_spaces; i++){
			String m_string = scanner.next(); // "Hacker" // "Rank"
			String m_output = GetOutputstring(m_string);
			System.out.println(m_output);
		}
		scanner.close();
	}

	private static String GetOutputstring(String m_string) {

		StringBuilder m_output = new StringBuilder();

		char split_string[] = m_string.toCharArray();

		for (int index = 0; index < m_string.length(); index +=2) {

			if(index %2 == 0){
				char even_string = split_string[index];
				m_output.append(even_string);
			}
		}
		m_output.append(" ");
		for (int index = 1; index < m_string.length(); index +=2) {

			if(index %2 == 1){
				char odd_string = split_string[index];
				m_output.append(odd_string);
			}
		}
		return m_output.toString();
	}

}

