package main.xmb;

import java.util.Arrays;

public class XMB_m5a1 {
	
	/**
	 * Uses a single enhanced for-loop the only way I could think of
	 * to multiply the values of 2 arrays
	 */
	public XMB_m5a1(int[] one, int[] two) {
		if(one.length != two.length) {
			System.err.println("The arrays are not the same length");
		}
		int[] answer = new int[one.length];
		int index = 0;
		for(int o : one) {
			answer[index] = two[index] * o;
			index += 1;
		}
		System.out.println(Arrays.toString(answer));
	}

	public static void main(String[] args) {
		new XMB_m5a1(
			new int[] {0, 1, 2, 3, 4},
			new int[] {5, 6, 7, 8, 9}
		);
	}

}
