package chap09;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboActionEx extends JFrame{
	private String [] fruits = {"apple", "banana", "kiwi", "mango"};
	
	private ImageIcon [] images = {
			new ImageIcon("C:\\±èÀç¿µ\\java\\FirstJava\\src\\chap09\\images/apple.png"),
			new ImageIcon("C:\\±èÀç¿µ\\java\\FirstJava\\src\\chap09\\images/banana.png"),
			new ImageIcon("C:\\±èÀç¿µ\\java\\FirstJava\\src\\chap09\\images/kiwi.jpg"),
			new ImageIcon("C:\\±èÀç¿µ\\java\\FirstJava\\src\\chap09\\images/mango.jpg")};
	private JLabel imgLabel = new JLabel(images[0]);
	private JComboBox<String> strCombo = new JComboBox<String>(fruits);
	
	public ComboActionEx() {
		setTitle("ÄÞº¸¹Ú½º È°¿ë ¿¹Á¦");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(strCombo);
		c.add(imgLabel);
		
		strCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JComboBox<String> cb = (JComboBox <String>)e.getSource();
				
				int index = strCombo.getSelectedIndex();
				
				imgLabel.setIcon(images[index]);
				
				}
		});
		
		setSize(300, 250);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new ComboActionEx();
	}

}
