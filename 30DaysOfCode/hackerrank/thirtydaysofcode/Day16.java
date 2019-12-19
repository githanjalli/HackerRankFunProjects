package hackerrank.thirtydaysofcode;
import java.util.Scanner;

public class Day16 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
       try {
            int x = Integer.parseInt(S);
            System.out.println(x);
         }  catch (NumberFormatException e) {
            System.out.println("Bad String");
        }
        
        in.close();

    }
}

