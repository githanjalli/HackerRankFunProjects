package hackerrank.games.hangman;
import java.io.IOException;
import java.util.Scanner;

public class HangmanApp {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to Hangman!");

		boolean play = true;
		while(play) {
			Hangman game = new Hangman();

			do {
				System.out.println();
				System.out.println(game.drawPicture());
				System.out.println();
				System.out.println(game.getCurrentGuess());
				System.out.println();


				System.out.println("Enter the character in the word:");
				char guess = (sc.next().toLowerCase()).charAt(0);
				System.out.println();

				while(game.IsGuessedAlready(guess)){
					System.out.println("Already guessed! Guess again!");
					guess = (sc.next().toLowerCase()).charAt(0);
				}

				if (game.playGuess(guess)){
					System.out.println("Great guess! Keep going!");
				}
				else
				{
					System.out.println("Sorry, wrong guess");
				}
			}
			while(!game.gameOver());

			System.out.println();
			System.out.println("Do you want to play another game?");
			char response = (sc.next().toUpperCase()).charAt(0);
			play = (response == 'Y');
		}
		
		sc.close();

	}
}
