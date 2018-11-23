package swing2.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JButton button_1;
	private JLabel lblNewLabel_1;
	private JLabel lblPw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextField());
		contentPane.add(getTextField_2());
		contentPane.add(getBtnNewButton());
		contentPane.add(getButton_1());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblPw());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Login");
			lblNewLabel.setFont(new Font("바탕", Font.BOLD, 28));
			lblNewLabel.setBounds(217, 43, 310, 95);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(227, 148, 116, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(227, 210, 116, 21);
		}
		return textField_2;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("로그인");
			btnNewButton.setBounds(102, 269, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("취소");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			button_1.setBounds(359, 269, 97, 23);
			
		}
		
		return button_1;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("ID");
			lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(136, 151, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("PW");
			lblPw.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			lblPw.setBounds(136, 213, 57, 15);
		}
		return lblPw;
	}
}
