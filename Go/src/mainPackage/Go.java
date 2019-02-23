package mainPackage;
import java.util.Scanner;

public class Go {
	
	String player;
	int moveCount = 1;
	int boardSize = 9;
	String[][] board = new String[boardSize][boardSize];

	
	public void initialize() {
		player = "Black";
		for(int i=0; i<boardSize; i++) {
			for(int j=0; j<boardSize; j++) {
				board[i][j] = "empty";
				//System.out.println(i + "  " + j);
				//System.out.println(board[i][j]);
			}
		}
	}
	
	public int[] getNextMove() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int[] move = {0,0};
		System.out.println(player + ", enter row: ");
		move[0] = input.nextInt();
		System.out.println(player + ", enter column: ");
		move[1] = input.nextInt();
		//input.close();

		return move;
	}
	
	public boolean isMoveLegal(int[] move) {
		if(move[0] >= boardSize || move[1] >= boardSize
				|| board[move[0]][move[1]] != "empty") {
			System.out.println("Illegal move!");
			return false;
		}else {
			System.out.println("Legal move.");
			return true;
		}
	}
	
	public void acceptMove(int[] move) {
		if(player.equals("Black")) {
			board[move[0]][move[1]] = "BLACK";
		}else {
			board[move[0]][move[1]] = "WHITE";
		}
	}
	
	public void changePlayer() {
		if(player.equals("White")) {
			player = "Black";
		}else {
			player = "White";
		}
	}
	
	public void printBoard() {
		for(int j=0; j<boardSize; j++) {
			for(int i=0; i<boardSize; i++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}
	
}
