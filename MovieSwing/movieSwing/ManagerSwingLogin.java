package movieSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerSwingLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tfLogin;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPasswordField tfPwd;
	ManagerSwing msm = new ManagerSwing();

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerSwingLogin frame = new ManagerSwingLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	public ManagerSwingLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTfLogin());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getTfPwd());
	}

	private JTextField getTfLogin() {
		if (tfLogin == null) {
			tfLogin = new JTextField();
			tfLogin.setBounds(136, 57, 116, 21);
			tfLogin.setColumns(10);
		}
		return tfLogin;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("관리자 ID");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setBounds(12, 60, 97, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("관리자 PW");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setBounds(12, 117, 97, 15);
		}
		return lblNewLabel_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("로그인");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(tfLogin.getText().equals("rhksflwk")) {
						if(String.valueOf(tfPwd.getPassword()).equals("rhksflwk")) {
							msm.setVisible(true);
							setVisible(false);
						}else {
							JOptionPane.showMessageDialog(null, "비밀번호가 맞지 않습니다.");
						}
					}else {
						JOptionPane.showMessageDialog(null, "아이디가 맞지 않습니다.");
					}
				}
			});
			btnNewButton.setBounds(278, 56, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("돌아가기");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new MovieSwingLogin().setVisible(true);
					setVisible(false);
				}
			});
			btnNewButton_1.setBounds(278, 113, 97, 23);
		}
		return btnNewButton_1;
	}
	private JPasswordField getTfPwd() {
		if (tfPwd == null) {
			tfPwd = new JPasswordField();
			tfPwd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButton.doClick();
				}
			});
			tfPwd.setBounds(136, 114, 116, 21);
		}
		return tfPwd;
	}
}
