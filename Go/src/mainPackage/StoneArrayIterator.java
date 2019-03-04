package mainPackage;

import java.util.Iterator;

public class StoneArrayIterator implements Iterator<Stone> {
	Stone[] stoneArr;
	int position = 0;
 
	public StoneArrayIterator(Stone[] stoneArr) {
		this.stoneArr = stoneArr;
	}
 
	public Stone next() {
		Stone stone = stoneArr[position];
		position = position + 1;
		return stone;
	}
 
	public boolean hasNext() {
		if (position >= stoneArr.length || stoneArr[position] == null) {
			return false;
		} else {
			return true;
		}
	}
 
	public void remove() {
		if (position <= 0) {
			throw new IllegalStateException
				("You can't remove an item until you've done at least one next()");
		}
		if (stoneArr[position-1] != null) {
			for (int i = position-1; i < (stoneArr.length-1); i++) {
				stoneArr[i] = stoneArr[i+1];
			}
			stoneArr[stoneArr.length-1] = null;
		}
	}
}
