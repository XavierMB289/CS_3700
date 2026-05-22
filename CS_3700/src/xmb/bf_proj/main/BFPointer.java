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
	
	/**
	 * Moves the pointer left with wrapping
	 */
	public void moveLeft() {
		pointer--;
		if(pointer == -1) {
			pointer = data.length - 1;
		}
	}
	
	/**
	 * Moves the pointer right
	 * If the pointer is > the length of the data, it extends the data
	 */
	public void moveRight() {
		if(pointer + 1 >= data.length) {
			resizeData();
		}
		pointer++;
	}
	
	/**
	 * Increments the data at the pointer then % 256
	 */
	public void increment() {
		data[pointer]+=1;
		data[pointer]%=256;
	}
	
	/**
	 * Decrements the data or sets it to 255
	 */
	public void decrement() {
		int pointer_data = data[pointer];
		data[pointer] = pointer_data - 1 > -1?pointer_data-1:255;
	}
	
	/**
	 * Gets the data at the pointer
	 */
	public int getDataAtPointer() {
		return data[pointer];
	}
	
	/**
	 * Sets the data at the pointer to the given input
	 */
	public void input(int input) {
		data[pointer] = input;
		data[pointer] %= 256;
	}
	
	/**
	 * Resizes data
	 */
	private void resizeData() {
		if(hasMaxData) { return; }
		data = Arrays.copyOf(data, data.length+1);
	}
	
	/**
	 * Allows you to see the current data list
	 */
	@Override
	public String toString() {
		String ret = data[0]+"";
		for(int i = 1; i < data.length; i++) {
			ret += ", "+data[i];
		}
		return ret;
	}
	
}
