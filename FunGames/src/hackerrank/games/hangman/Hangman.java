package hackerrank.games.hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Hangman {

	String answer = "";
	StringBuilder currentGuess;
	ArrayList<Character> previousGuesses = new ArrayList<>();

	int maxTries = 6;
	int currentTry = 0;

	/** Take words from net and put it in the arraylist **/
	ArrayList<String> dictionary = new ArrayList<String>();

	private static FileReader fileReader; //read from file
	private static BufferedReader bufferedfileReader;  //kind of stringbuilder, allow iterate through the file and take things out of it, index it

	public Hangman() throws IOException{
		initializeStreams();
		answer = pickWord();
		currentGuess = initializeCurrentGuess();
	}

	private void initializeStreams() throws IOException {
		try {
			File inFile 		= new File("dictionary.txt");
			fileReader 			= new FileReader(inFile);
			bufferedfileReader 	= new BufferedReader(fileReader);

			String currentline = bufferedfileReader.readLine();
			while (currentline != null) {
				dictionary.add(currentline);
				currentline = bufferedfileReader.readLine();
			}
			bufferedfileReader.close();
			fileReader.close();

		} catch (IOException e) {
			System.out.println("Could not init");
		}
	}

	private String pickWord() {
		Random rand = new Random();
		int wordIndex = Math.abs(rand.nextInt()) % dictionary.size();
		return dictionary.get(wordIndex);
	}

	// __A__

	private StringBuilder initializeCurrentGuess() {
		StringBuilder current = new StringBuilder();
		for (int i = 0; i < answer.length() * 2 ; i++) {
			if(i % 2 == 0){
				current.append("_");
			}
			else
			{
				current.append(" ");
			}
		}
		return current;
	}

	
	public String getCurrentGuess(){
		System.out.println();
		return currentGuess.toString();
	}

	// " - - - - -\n"+
	// "|        |\n"+
	// "|        O\n" +
	// "|      / | \\ \n"+
	// "|        |\n" +
	// "|       / \\ \n" +
	// "|\n" +
	// "|\n";

	public String drawPicture(){
		switch(currentTry) {
		case 0: return noPersonDraw(); //no need to put break if we use with return
		case 1: return addHeadDraw();
		case 2: return addBodyDraw();
		case 3: return addOneArmDraw();
		case 4: return addSecondArmDraw();
		case 5: return addFirstLegDraw();
		default: return fullPersonDraw();
		}
	}
	private String noPersonDraw() {
		return " - - - - -\n"+
				"|        |\n"+
				"|        \n" +
				"|       \n"+
				"|        \n" +
				"|       \n" +
				"|\n" +
				"|\n";
	}

	private String addHeadDraw() {
		return " - - - - -\n"+
				"|        |\n"+
				"|        O\n" +
				"|       \n"+
				"|        \n" +
				"|       \n" +
				"|\n" +
				"|\n";
	}

	private String addBodyDraw() {
		return " - - - - -\n"+
				"|        |\n"+
				"|        O\n" +
				"|        | \n"+
				"|        |\n" +
				"|        \n" +
				"|\n" +
				"|\n";
	}

	private String addOneArmDraw() {
		return   " - - - - -\n"+
				"|        |\n"+
				"|        O\n" +
				"|      / |  \n"+
				"|        |\n" +
				"|        \n" +
				"|\n" +
				"|\n";
	}

	private String addSecondArmDraw() {
		return  " - - - - -\n"+
				"|        |\n"+
				"|        O\n" +
				"|      / | \\ \n"+
				"|        |\n" +
				"|        \n" +
				"|\n" +
				"|\n";
	}

	private String addFirstLegDraw() {
		return   " - - - - -\n"+
				"|        |\n"+
				"|        O\n" +
				"|      / | \\ \n"+
				"|        |\n" +
				"|       / \n" +
				"|\n" +
				"|\n";
	}

	private String fullPersonDraw() {
		return   " - - - - -\n"+
				"|        |\n"+
				"|        O\n" +
				"|      / | \\ \n"+
				"|        |\n" +
				"|       / \\ \n" +
				"|\n" +
				"|\n";
	}

	public boolean gameOver() {
		if(Win()) {
			System.out.println();
			System.out.println("You won!");
			return true;
		}
		else if(Lose()){
			System.out.println();
			System.out.println("You lost!");
			System.out.println("The word was:" + answer);
			return true;
		}
		return false;
	}

	private boolean Win() {
		String guess = GetTotalCurrentGuess();
		return guess.equals(answer);
	}
	

	private String GetTotalCurrentGuess() {
		String guess = currentGuess.toString();
		guess.replace(" ", "");
		return guess;
	}
	
	private boolean Lose() {
		return currentTry >= maxTries;
	}


	public boolean IsGuessedAlready(char guess) {
		return previousGuesses.contains(guess);
	}

	public boolean playGuess(char guess) {
		boolean IsItGoodGuess = false;
		for (int i = 0; i < answer.length(); i++) {
			if(answer.charAt(i) == guess){
				currentGuess.setCharAt(i * 2, guess);
				IsItGoodGuess = true;
				previousGuesses.add(guess);
			}
		}
		
		if(!IsItGoodGuess) {
			currentTry++;
		}
		
		return IsItGoodGuess;
	}

}
