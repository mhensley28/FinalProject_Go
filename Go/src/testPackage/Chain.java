package testPackage;

import testPackage.GameBoard.State;

import java.util.ArrayList;

/*
 * A collection of adjacent Stone(s).
 */
 
public class Chain {

	public ArrayList<Stone_Test> stones;
	public State state;
	
	public Chain(State state) {
	    stones = new ArrayList<>();
	}
	
	public int getLiberties() {
	    int total = 0;
	    for (Stone_Test stone : stones) {
	        total += stone.liberties;
	    }
	    return total;
	}
	
	public void addStone(Stone_Test stone) {
	    stone.chain = this;
	    stones.add(stone);
	}
	
	public void join(Chain chain) {
	    for (Stone_Test stone : chain.stones) {
	        addStone(stone);
	    }
	}

}
