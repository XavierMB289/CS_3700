package main.xmb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class XMB_m6a2 {
	
	public XMB_m6a2() {
		Car car1 = new Car("Pontaic", "Torrent", 2008, 1500);
		CustomCar car2 = new CustomCar("Hyundai", "Elantra", 3002, 443320);
	}
	
	class Car{
		private String make, model;
		private int year;
		private double cost;
		public Car(String make, String model, int year, double cost) {
			this.make = make;
			this.model = model;
			this.year = year;
			this.cost = cost;
		}
		public String getMake() {
			return make;
		}
		public String getModel() {
			return model;
		}
		public int getYear() {
			return year;
		}
		public double getCost() {
			return cost;
		}
		public void setCost(double cost) {
			this.cost = cost;
		}
	}
	
	class CustomCar extends Car{
		private int rpm, topSpeed, torque;
		private String alterationDesc;
		public CustomCar(String make, String model, int year, double cost) {
			super(make, model, year, cost);
			try {
				testCar();
			} catch (ParseException | InterruptedException e) {
				e.printStackTrace();
			}
		}
		public int getRPM() {
			return rpm;
		}
		public int getTopSpeed() {
			return topSpeed;
		}
		public int getTorque() {
			return torque;
		}
		public String getAltDesc() {
			return alterationDesc;
		}
		@SuppressWarnings("deprecation")
		public void testCar() throws ParseException, InterruptedException {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the date of the last performance test (yyyy-mm-dd):");
			String userInput = scan.nextLine();
			Date userDate = sdf.parse(userInput);
			Date monthAgo = sdf.parse(LocalDate.now().toString());
			monthAgo.setMonth(monthAgo.getMonth() == 0 ? 11 : monthAgo.getMonth() - 1);
			if(userDate.before(monthAgo)) {
				System.err.print("Your car is out of tune! Performing testing.");
				Thread.sleep(500);
				System.out.print(".");
				rpm = 900+(int)(Math.random() * 601);
				Thread.sleep(500);
				System.out.print(".");
				topSpeed = 100+(int)(Math.random() * 141);
				Thread.sleep(500);
				System.out.print(".");
				torque = 250+(int)(Math.random() * 151);
				Thread.sleep(500);
				System.out.println("\nDONE.");
			}else {
				System.out.println("Your car is still in tune.\nPlease enter the idle RPM for the car:");
				rpm = scan.nextInt();
				System.out.println("Please enter in the Top Speed:");
				topSpeed = scan.nextInt();
				System.out.println("Please enter your average torque value:");
				torque = scan.nextInt();
				System.out.println("Please describe the alterations made:");
				alterationDesc = scan.nextLine();
			}
			scan.close();
		}
	}
	
	public static void main(String[] args) {
		new XMB_m6a2();
	}

}
