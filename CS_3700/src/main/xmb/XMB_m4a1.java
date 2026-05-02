package main.xmb;

public class XMB_m4a1 {
	
	public XMB_m4a1() {
		multiUse(0);
		multiUse(10);
		multiUse(4, 4);
		multiUse(8675309, 42);
		multiUse(5, 5, 5);
		multiUse(2, 28, 99);
	}
	
	/**
	 * Prints from 1 to one, separating by ", "
	 * Will not work if one == 1
	 * @param one int > 1
	 */
	public void multiUse(int one) {
		if(one <= 1) {
			System.err.println("Your number must be bigger than 1!");
			return;
		}
		String output = "1";
		for(int i = 1; i < one; i++) {
			output = output + ", " + String.valueOf(i);
		}
		System.out.println(output);
	}
	
	/**
	 * Averages 2 numbers
	 */
	public void multiUse(int one, int two) {
		if(one == two) {
			System.out.println("Your average is "+String.valueOf(one));
		}else {
			System.out.println("Your average is "+String.valueOf(((float)one+(float)two)/2));
		}
	}
	
	/**
	 * Gets the maximum of the three numbers
	 */
	public void multiUse(int one, int two, int three) {
		if(one == two && two == three) {
			System.out.println("Your max is "+String.valueOf(one));
		}else {
			System.out.println("Your max is "+String.valueOf(Math.max(Math.max(one, two), three)));
		}
	}
	
	public static void main(String[] args) {
		new XMB_m4a1();		
	}
	
}