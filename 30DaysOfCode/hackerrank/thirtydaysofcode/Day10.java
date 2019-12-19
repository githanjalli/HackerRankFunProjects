package hackerrank.thirtydaysofcode;
import java.util.Scanner;

public class Day10 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");


        int count = 0;
        int max_count = 0;

        // Get binary of n
        String binary = Integer.toBinaryString(n);

        String bin_arr[] = binary.split("");

        // Check for maximum no of consecutive '1's
        for (int i = 0; i < bin_arr.length ; i++) {
            if(bin_arr[i].equals("0")){
                count = 0;
            }
            else
            {
                count++;
                max_count = (max_count >= count) ? max_count : count; 
                //max_count = Math.max(max_count, count);
            }
        }
        // print count
        System.out.println(max_count);

        scanner.close();
    }
}
