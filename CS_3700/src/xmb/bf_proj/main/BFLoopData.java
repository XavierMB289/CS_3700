package xmb.bf_proj.main;

import java.util.ArrayList;
import java.util.List;

public class BFLoopData {
	
	private List<int[]> pointers; // [start, end]
	
	public BFLoopData() {
		pointers = new ArrayList<>();
	}
	
	public int getPointerLen() {
		return pointers.size();
	}
	
	public void addLoopStart(int index) {
		pointers.add(new int[] {index});
	}
	
	public void addLoopEnd(int index) {
		int pIndex = getLastUnfinishedLoopPair();
		if(pIndex != -1) {
			pointers.set(pIndex, new int[] {pointers.get(pIndex)[0],index});
		}
	}
	
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
	
	private int getLastUnfinishedLoopPair() {
		for(int i = pointers.size()-1; i>-1; i--) {
			if(pointers.get(i).length == 1) {
				return i;
			}
		}
		return -1;
	}
	
}
