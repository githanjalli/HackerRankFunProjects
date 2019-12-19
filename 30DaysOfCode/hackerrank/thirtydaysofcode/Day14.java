package hackerrank.thirtydaysofcode;
import java.util.Arrays;
import java.util.Scanner;


class Difference {
  	private int[] elements;
  	public int maximumDifference;

    Difference(int[] a){
          this.elements = a;
      }

    public void computeDifference() {
    
        for (int i = 0; i < elements.length; i++) {
            if(elements[i] <= 0 || elements[i] >= 100){
                this.maximumDifference = 0;    
            }
            else
            {
                Arrays.sort(elements);
                int last_index = elements.length - 1;
                int min_element = elements[0];
                int max_element = elements[last_index];
                this.maximumDifference = max_element - min_element;
            }
        }
    }
} // End of Difference class

public class Day14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}