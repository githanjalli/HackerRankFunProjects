package general;
import java.util.Scanner;

public class DiceRoll {

	public static void main(String[] args){

		int min = 1;
		int max = 6;

		System.out.println("Roll the dice");

		int n = (int) (Math.random() * ((max - min) + 1) + min);
		Scanner input = new Scanner(System.in);
		System.out.println( "Your number:"  + n);

		String name = input.nextLine(); 
   		System.out.println("Do you want to continue? Y or N");
		if(name.equalsIgnoreCase("Y")){		
			System.out.println( "Your number:"  + n);	
		}
		input.close();
		
	}
}