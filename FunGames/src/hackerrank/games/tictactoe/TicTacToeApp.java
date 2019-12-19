package hackerrank.games.tictactoe;
import java.util.Scanner;

public class TicTacToeApp {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		boolean play = true;
		while(play){
			System.out.println("Tic tac toe");
			System.out.println("Enter user character:");
			char userMark = sc.next().charAt(0);
			System.out.println("Enter computer character:");
			char compMark = sc.next().charAt(0);
			
			TicTacToe game = new TicTacToe(userMark, compMark);
			TicTacToeComp comp = new TicTacToeComp();
		
			System.out.println();
			System.out.println("Enter a number between 1-9, left to right:");
			game.printArrayViewBoard();
			System.out.println();
			
			while(game.GameOver().equals("notOver")){
				if(game.currentMark == game.userMark)
				{
					System.out.println("Users turn: ");
					int spot = sc.nextInt();
					while(!game.playTurn(spot)){
						System.out.println("Spot is already taken" + spot);
						spot = sc.nextInt();
					}
					System.out.println("User picked" + spot + "!");
				}
				else
				{
					System.out.println("Computer turn: ");
					
					int compspot = comp.pickSpot(game);
					game.playTurn(compspot);
					System.out.println("Comp picked" + compspot);
				}
				
				System.out.println();
				game.printBoard();
			}
			System.out.println(game.GameOver());
			System.out.println();
			
			System.out.println("Do you want to play again?");
			
			char response = sc.next().charAt(0);
			play = (response == 'Y');
			System.out.println();
			
			sc.close();
		}
		
	}

}
