package main.xmb;

import javax.swing.JOptionPane;

public class XMB_m1a2 {
	
	public XMB_m1a2(String[] args) {
		int x = Integer.parseInt(JOptionPane.showInputDialog("Input First Number: "));
		int y = Integer.parseInt(JOptionPane.showInputDialog("Input Second Number: "));
		String[] func_text = {"+", "-", "*", "/"};
		float[] func = {x+y, x-y, x*y, x/y};
		for(int i = 0; i < func.length; i++) {
			System.out.println(String.format("%s %s %s = %g", x, func_text[i], y, func[i]));
		}
	}
	
	public static void main(String[] args) {
		new XMB_m1a2(args);
	}

}
