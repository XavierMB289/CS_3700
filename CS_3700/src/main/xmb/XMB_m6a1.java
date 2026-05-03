package main.xmb;

public class XMB_m6a1 {
	
	/**
	 * Averages an array of numbers
	 */
	public static float Calc(int[] nums) {
		float avg = 0;
		for(int n : nums) avg += n;
		return avg/nums.length;
	}
	
}
