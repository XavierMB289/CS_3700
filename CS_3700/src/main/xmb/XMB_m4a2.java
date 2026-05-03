package main.xmb;

import javax.swing.JOptionPane;

public class XMB_m4a2 {
	
	/**
	 * Asks the user for a Username/Password
	 * Checks them against Hero/Zero
	 * (Hercules Reference)
	 */
	public XMB_m4a2() {
		String user = JOptionPane.showInputDialog("Username: ");
		String pass = JOptionPane.showInputDialog("Password:");
		if(user == "Hero" && pass == "Zero") {
			System.out.println("Access Granted");
		}else {
			System.err.println("Incorrect Credentials");
		}
	}
	
	public static void main(String[] args) {
		new XMB_m4a2();
	}
	
}
