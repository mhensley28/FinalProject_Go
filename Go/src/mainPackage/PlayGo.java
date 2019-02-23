package mainPackage;

public class PlayGo {

	public static void main(String[] args) {
		Go go = new Go();
		GoBoard goBoard = new GoBoard();
		go.initialize();
		//go.printBoard();
		goBoard.paint();
		goBoard.view();
		while(true) {
			int[] nextMove = go.getNextMove();
			//System.out.println(x[0] + " " + x[1]);
			if(go.isMoveLegal(nextMove)) {
				go.acceptMove(nextMove);				
				go.changePlayer();
				go.printBoard();	
			};
			

		}
	}
}
