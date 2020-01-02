package hackerrank.thirtydaysofcode;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Day28 {


	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();

		List<String> list = new ArrayList<String>();

		for (int NItr = 0; NItr < N; NItr++) {
			String[] firstNameEmailID = scanner.nextLine().split(" ");

			String firstName = firstNameEmailID[0];

			String emailID = firstNameEmailID[1];

			String  email_regex = "[a-z].@gmail.com{0,50}";
			Pattern email_pattern = Pattern.compile(email_regex);
			Matcher email_matcher = email_pattern.matcher(emailID);

			if(email_matcher.find()) {
				list.add(firstName);
			}

		}

		Collections.sort(list);

		for (String name : list) {
			System.out.println(name);
		}

		scanner.close();

	}

}
