package hackerrank.thirtydaysofcode;
import java.util.Scanner;

interface AdvancedArithmetic{
   int divisorSum(int n);
}
class SimpleCalculator implements AdvancedArithmetic {
    public int divisorSum(int n) {
      int sum = 0;
      for (int i = 1; i <= n; i++) {
         if(n % i == 0) 
         {
                sum = sum + i;
         }
        }
        return sum;
    }
}

class Day19 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        
      	AdvancedArithmetic myCalculator = new SimpleCalculator(); 
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}