package xmb.bf_proj.main;

import java.util.ArrayList;
import java.util.List;

public class BFLoopData {
	
	private List<int[]> pointers; // [start, end]
	
	public BFLoopData() {
		pointers = new ArrayList<>();
	}
	
	/**
	 * Gets the Pointer Length
	 */
	public int getPointerLen() {
		return pointers.size();
	}
	
	/**
	 * Adds the start index of a loop to the list of pointers
	 * @param index Index of a '['
	 */
	public void addLoopStart(int index) {
		pointers.add(new int[] {index});
	}
	
	/**
	 * Pairs the given index with the last '[' added
	 * @param index Index of a ']'
	 */
	public void addLoopEnd(int index) {
		int pIndex = getLastUnfinishedLoopPair();
		if(pIndex != -1) {
			pointers.set(pIndex, new int[] {pointers.get(pIndex)[0], index});
		}
	}
	
	/**
	 * Gets the loop start by searching the pointer pairs and comparing
	 * @param endLoopIndex The end loop index to search for
	 * @return the paired start loop index (or -1 if not found)
	 */
	public int getLoopStart(int endLoopIndex) {
		for(int[] p : pointers) {
			int start = p[0];
			int end = p[1];
			if(end == endLoopIndex) {
				return start;
			}
		}
		System.err.println("Could not find loop start!");
		return -1;
	}
	
	/**
	 * Gets the loop end by searching the pointer pairs and comparing
	 * @param startLoopIndex The start loop index to search for
	 * @return the paired end loop index (or -1 if not found)
	 */
	public int getLoopEnd(int startLoopIndex) {
		for(int[] p : pointers) {
			int start = p[0];
			int end = p[1];
			if(start == startLoopIndex) {
				return end;
			}
		}
		System.err.println("Could not find loop end!");
		return -1;
	}
	
	/**
	 * Gets the last unfinished pointer pair
	 * @return index of the last pointer pair with only a '[' index
	 */
	private int getLastUnfinishedLoopPair() {
		for(int i = pointers.size()-1; i>-1; i--) {
			if(pointers.get(i).length == 1) {
				return i;
			}
		}
		return -1;
	}
	
}
