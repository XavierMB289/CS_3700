package xmb.bf_proj.main;

import java.util.Arrays;

public class BFPointer {
	
	private int pointer = 0;
	private int[] data;
	private boolean hasMaxData = false;
	
	public BFPointer(int max_data) {
		hasMaxData = max_data > 0;
		data = new int[hasMaxData?max_data:1];
		Arrays.fill(data, 0);
	}
	
	public BFPointer() {
		this(-1);
	}
	
	public void moveLeft() {
		pointer--;
		if(pointer == -1) {
			pointer = data.length - 1;
		}
	}
	
	public void moveRight() {
		if(pointer + 1 >= data.length) {
			resizeData();
		}
		pointer++;
	}
	
	public void increment() {
		data[pointer]+=1;
		data[pointer]%=256;
	}
	
	public void decrement() {
		int pointer_data = data[pointer];
		data[pointer] = pointer_data - 1 > -1?pointer_data-1:255;
	}
	
	public int getDataAtPointer() {
		return data[pointer];
	}
	
	public void input(int input) {
		data[pointer] = input;
	}
	
	private void resizeData() {
		if(hasMaxData) { return; }
		data = Arrays.copyOf(data, data.length+1);
	}
	
	@Override
	public String toString() {
		String ret = data[0]+"";
		for(int i = 1; i < data.length; i++) {
			ret += ", "+data[i];
		}
		return ret;
	}
	
}
