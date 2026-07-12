package main.xmb;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class XMB_m11a1 extends JFrame implements ActionListener{

	private static final long serialVersionUID = -2297130537928741529L;

	private JTextField first, second, result;
	
	private JButton add, sub, mult, div, rem;
	
	//NOTE: I took Rem as Remainder not remember
	
	public XMB_m11a1() {
		this.setTitle("Mini Calculator");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//Setup & Title
		JPanel panel = new JPanel();
		panel.setBackground(new Color(120, 120, 120));
		panel.setLayout(null);
		
		JLabel title = new JLabel("Mini Calculator", SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.PLAIN, 36));
		title.setBounds(0, 0, 400, 50);
		panel.add(title);
		
		//First Number
		JLabel lblFirst = new JLabel("Enter First Number:");
		lblFirst.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFirst.setBounds(10, 80, 250, 40);
		panel.add(lblFirst);
		
		first = new JTextField();
		first.setFont(new Font("Arial", Font.PLAIN, 14));
		first.setBounds(160, 80, 200, 40);
		panel.add(first);
		
		//Second Number
		JLabel lblSecond = new JLabel("Enter Second Number:");
		lblSecond.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSecond.setBounds(10, 130, 200, 40);
		panel.add(lblSecond);
		
		second = new JTextField();
		second.setFont(new Font("Arial", Font.PLAIN, 14));
		second.setBounds(160, 130, 200, 40);
		panel.add(second);
		
		//Buttons
		add = createButton("+", 20, 190);
		sub = createButton("-", 70, 190);
		mult = createButton("*", 120, 190);
		div = createButton("/", 170, 190);
		rem = createButton("Rem", 220, 190, 70);
		
		panel.add(add);
		panel.add(sub);
		panel.add(mult);
		panel.add(div);
		panel.add(rem);
		
		//Result
		JLabel lblResult = new JLabel("Result:");
		lblResult.setFont(new Font("Arial", Font.PLAIN, 14));
		lblResult.setBounds(10, 240, 100, 40);
		panel.add(lblResult);
		
		result = new JTextField();
		result.setFont(new Font("Arial", Font.PLAIN, 14));
		result.setEditable(false);
		result.setForeground(Color.blue);
		result.setBounds(160, 240, 200, 40);
		panel.add(result);
		
		this.add(panel);
	}
	
	private JButton createButton(String text, int x, int y) {
		return this.createButton(text, x, y, 45);
	}
	
	private JButton createButton(String text, int x, int y, int w) {
		JButton button = new JButton(text);
		button.setFont(new Font("Arial", Font.PLAIN, 14));
		button.setBounds(x, y, w, 30);
		button.addActionListener(this);
		return button;
	}
	
	private void errorPopup(String text) {
		JOptionPane.showMessageDialog(null, text);
	}
	
	private static boolean isNum(String s) {
		if(s == null) return false;
		try {
			Double.parseDouble(s);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String fText = first.getText();
		String sText = second.getText();
		if(fText.equals("")) {
			errorPopup("The first number cannot be blank");
			return;
		}else if(!isNum(fText)) {
			errorPopup("The first number must only have digits");
			return;
		}
		if(sText.equals("")) {
			errorPopup("The second number cannot be blank");
			return;
		}else if(!isNum(sText)) {
			errorPopup("The second number must only have digits");
			return;
		}
		double fInt = Double.parseDouble(fText);
		double sInt = Double.parseDouble(sText);
		double answer = -1;
		
		Object source = e.getSource();
		
		if(source == add) {
			answer = fInt + sInt;
		}else if(source == sub) {
			answer = fInt - sInt;
		}else if(source == mult) {
			answer = fInt * sInt;
		}else if(source == div) {
			if(sInt != 0) {
				answer = fInt / sInt;
			}else {
				errorPopup("Cannot divide by zero, change the second number");
				return;
			}
		}else if(source == rem) {
			answer = fInt % sInt;
		}
		
		result.setText(String.valueOf(answer));
	}
	public static void main(String[] args) {
		new XMB_m11a1().setVisible(true);
	}
}
