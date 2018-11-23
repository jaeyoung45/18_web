package swing.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Test extends JFrame {

	private JPanel contentPane;
	private JButton b1;
	private JTextField tf;
	private JComboBox comboBox;
	private JComboBox comboBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 803);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getB1());
		contentPane.add(getTf());
		contentPane.add(getComboBox());
		contentPane.add(getComboBox_1());
	}
	private JButton getB1() {
		if (b1 == null) {
			b1 = new JButton("버튼");
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tf.setText("버튼클릭");
				}
			});
			b1.setBounds(29, 53, 97, 23);
		}
		return b1;
	}
	private JTextField getTf() {
		if (tf == null) {
			tf = new JTextField();
			tf.setText("t");
			tf.setBounds(138, 54, 116, 21);
			tf.setColumns(10);
		}
		return tf;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(80, 116, 30, 21);
			comboBox.addItem("딸기");
			comboBox.addItem("바나나");
			comboBox.addItem("사과");
		}
		return comboBox;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"하나", "둘", "셋"}));
			comboBox_1.setBounds(171, 116, 30, 21);
		}
		return comboBox_1;
	}
}
