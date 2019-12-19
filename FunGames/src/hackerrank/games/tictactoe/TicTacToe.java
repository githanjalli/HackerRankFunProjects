package hackerrank.games.tictactoe;
public class TicTacToe {

	private static final char DASH = '-';
	protected char[] board;
	protected char userMark;
	protected char compMark;
	protected char winner;
	protected char currentMark;

	public TicTacToe(char userMark, char compMark){
		this.userMark = userMark;
		this.compMark = compMark;
		this.winner = '-';
		this.board = setBoard();
		this.currentMark = userMark;
	}

	private static char[] setBoard() {
		char board[] = new char[9];
		for (int i = 0; i < board.length; i++) {
			board[i] = '-';
		}
		return board;
	}

	public boolean playTurn(int spot){
		boolean isValidspot = WithinRange(spot) && !IsSpotTaken(spot);
		if(isValidspot){
			board[spot-1] = currentMark; //array starts with 0
			currentMark =  (currentMark == userMark) ? compMark : userMark;
		}
		return isValidspot;

	}

	private boolean IsSpotTaken(int spot) {
		return board[spot - 1] != '-';
	}

	private boolean WithinRange(int spot) {
		return spot > 0 && spot < board.length;
	}

	public void printBoard(){
		System.out.println("/---|---|---\\");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("/---|---|---\\");	
	}

	public void printArrayViewBoard(){
		System.out.println("/---|---|---\\");
		System.out.println("| " + 1 + " | " + 2 + " | " + 3 + " |");
		System.out.println("|-----------|");
		System.out.println("| " + 4 + " | " + 5 + " | " + 6 + " |");
		System.out.println("|-----------|");
		System.out.println("| " + 7 + " | " + 8 + " | " + 9 + " |");
		System.out.println("/---|---|---\\");	
	}

	public boolean isThereAWinner(){
		// winning conditions
		boolean diagonalsAndMiddles = (rightDi(board) || leftDi(board) || middleRow(board) || secondCol(board)) && board[4] != '-';
		boolean topAndFirst = (topRow(board) || firstCol(board)) && board[0] != '-';
		boolean bottomAndThird = (bottomRow(board) || thirdCol(board)) && board[8] != '-';
		if (diagonalsAndMiddles) {
			this.winner = board[4];
		} else if (topAndFirst){
			this.winner = board[0];
		} else if (bottomAndThird) {
			this.winner = board[8];
		}

		return diagonalsAndMiddles || topAndFirst || bottomAndThird;
	}

	public boolean topRow(char[] board) {
		return board[0] == board[1] && board[1] == board[2];
	}

	public boolean middleRow(char[] board) {
		return board[3] == board[4] && board[4] == board[5];
	}

	public boolean bottomRow(char[] board) {
		return board[6] == board[7] && board[7] == board[8];
	}

	public boolean firstCol(char[] board) {
		return board[0] == board[3] && board[3] == board[6];
	}

	public boolean secondCol(char[] board) {
		return board[1] == board[4] && board[4] == board[7];
	}

	public boolean thirdCol(char[] board) {
		return board[2] == board[5] && board[5] == board[8];
	}

	public boolean rightDi(char[] board){
		return board[0] == board[4] && board[4] == board[8];
	}

	public boolean leftDi(char[] board) {
		return board[2] == board[4] && board [4] == board[6];
	}
	
	public boolean isBoardFilled(){
		for (int i = 0; i < board.length; i++) {
			if(board[i] == DASH){
				return false;
			}
		}
		return true;
	}
	
	public String GameOver(){
		boolean didSomeoneWin = isThereAWinner();
		if(didSomeoneWin){
			return "Winner is: " + this.winner;
		}
		else if(isBoardFilled()){
			return "Its a draw!";
		}
		else
		{
			return "notOver";
		}
	}

}
