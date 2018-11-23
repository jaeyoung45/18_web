package swing3.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import swing3.model.TrainMember;
import swing3.model.TrainMemberDBA;

import javax.swing.JPasswordField;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel Nl1;
	private JLabel Nl2;
	private JLabel Nl3;
	private JLabel Nl4;
	private JTextField tfId;
	private JTextField tF3;
	private JTextField tF4;
	private JButton btn1;
	private JButton btn3;
	private JPasswordField tfPass;
	Login dba = new Login();
	TrainMemberDBA tdba= new TrainMemberDBA();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getNl1());
			panel.add(getNl2());
			panel.add(getNl3());
			panel.add(getNl4());
			panel.add(getTfId());
			panel.add(getTF3());
			panel.add(getTF4());
			panel.add(getBtn1());
			panel.add(getBtn3());
			panel.add(getTfPass());
		}
		return panel;
	}

	private JLabel getNl1() {
		if (Nl1 == null) {
			Nl1 = new JLabel("ID");
			Nl1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			Nl1.setBounds(113, 42, 57, 15);
		}
		return Nl1;
	}

	private JLabel getNl2() {
		if (Nl2 == null) {
			Nl2 = new JLabel("PW");
			Nl2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			Nl2.setBounds(113, 94, 57, 15);
		}
		return Nl2;
	}

	private JLabel getNl3() {
		if (Nl3 == null) {
			Nl3 = new JLabel("이름");
			Nl3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			Nl3.setBounds(113, 152, 57, 15);
		}
		return Nl3;
	}

	private JLabel getNl4() {
		if (Nl4 == null) {
			Nl4 = new JLabel("연락처");
			Nl4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			Nl4.setBounds(113, 203, 57, 15);
		}
		return Nl4;
	}

	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(167, 39, 215, 21);
			tfId.setColumns(10);
		}
		return tfId;
	}

	private JTextField getTF3() {
		if (tF3 == null) {
			tF3 = new JTextField();
			tF3.setColumns(10);
			tF3.setBounds(167, 149, 215, 21);
		}
		return tF3;
	}

	private JTextField getTF4() {
		if (tF4 == null) {
			tF4 = new JTextField();
			tF4.setColumns(10);
			tF4.setBounds(167, 200, 215, 21);
		}
		return tF4;
	}

	private JButton getBtn1() {
		if (btn1 == null) {
			btn1 = new JButton("가입완료");
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TrainMember m = new TrainMember();
					m.setID(tfId.getText());
					m.setPW(tfPass.getText());
					m.setName(tF3.getText());
					m.setPhonenum(tF4.getText());
				   
				    
				    tdba.TrainuserInsert(m);
				    new MessageBox("가입", "가입완료");
				    Login Login = new Login();
				    Login.setVisible(true);
				    dispose();
				    
				}	
			});
			btn1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			btn1.setBounds(157, 272, 97, 23);
		}
		return btn1;
	}

	private JButton getBtn3() {
		if (btn3 == null) {
			btn3 = new JButton("취소");
			btn3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			btn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login Login = new Login();
					Login.setVisible(true);
					dispose();
			}
		});
		btn3.setBounds(344, 272, 97, 23);
	}
	return btn3;
	}
	private JPasswordField getTfPass() {
		if (tfPass == null) {
			tfPass = new JPasswordField();
			tfPass.setBounds(164, 92, 218, 21);
		}
		return tfPass;
	}
}
