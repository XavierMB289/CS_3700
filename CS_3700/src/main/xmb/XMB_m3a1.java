package main.xmb;

import java.util.Scanner;

public class XMB_m3a1 {
	
	Scanner scan;
	
	int x = Integer.MIN_VALUE;
	int y = x;
	
	public XMB_m3a1() {
		scan = new Scanner(System.in);
		int userInput = -1;
		while(userInput != 5) {
			System.out.println("1 - Enter two (2) numbers (x and y)\n2 - Print all numbers between x and y\n3 - Find the average of all numbers between x and y\n4 - Find all prime numbers between x and y\n5 - Exit");
			userInput = scan.nextInt();
			switch(userInput) {
				case 1:
					enterNums();
					break;
				case 2:
					System.out.println("Numbers Between X and Y: "+numsBetween());
					break;
				case 3:
					System.out.println("Average of Numbers between X and Y: "+String.valueOf(avgNums()));
					break;
				case 4:
					primeBetween();
					break;
			}
		}
	}
	/**
	 * Allows the user to enter 2 numbers.
	 * It will keep prompting for numbers if:
	 * - x == y
	 * - x+1 == y
	 * - x > y
	 * This is so that the functions below actually work.
	 */
	private void enterNums() {
		while(x == y || x + 1 == y || x > y) {
			System.out.println("X Value: ");
			x = scan.nextInt();
			System.out.println("Y Value: ");
			y = scan.nextInt();
		}
	}
	/**
	 * Gets all the numbers between X and Y
	 * @return a string with all the numbers separated by ", "
	 */
	private String numsBetween() {
		if(x == Integer.MIN_VALUE) {
			System.err.println("YOU MUST CALL #1 first");
			return "";
		}
		String output = String.valueOf(x+1);
		for(int i = x+2; i < y; i++) {
			output = output + ", " + String.valueOf(i);
		}
		return output;
	}
	/**
	 * Gets the average of all the numbers between X and Y (exclusive)
	 * @return a float
	 */
	private float avgNums() {
		if(x == Integer.MIN_VALUE) {
			System.err.println("YOU MUST CALL #1 first");
			return -1f;
		}
		String[] nums = numsBetween().split(", ");
		float avg = 0;
		for(String n : nums) {
			avg += Float.parseFloat(n);
		}
		avg = avg / nums.length;
		return avg;
	}
	/**
	 * Shamelessly stolen from https://www.geeksforgeeks.org/java/java-prime-number-program/
	 * 
	 * The optimal way to check for prime numbers
	 * @param n The value to check
	 * @return true if the number is prime
	 */
	private boolean isPrime(int n) {
		if(n <= 1) return false;
		if(n == 2 || n == 3) return true;
		if(n % 2 == 0 || n % 3 == 0) return false;
		for(int i = 5; i <= Math.sqrt(n); i+=6) {
			if(n % i == 0 || n % (i + 2) == 0) return false;
		}
		return true;
	}
	/**
	 * Prints the numbers between the given X and Y that are prime
	 */
	private void primeBetween() {
		if(x == Integer.MIN_VALUE) {
			System.err.println("YOU MUST CALL #1 first");
			return;
		}
		String[] nums = numsBetween().split(", ");
		for(String n : nums) {
			if(isPrime(Integer.parseInt(n))) System.out.println("The number "+n+" is prime");
		}
	}
	
	public static void main(String[] args) {
		new XMB_m3a1();
	}
}
