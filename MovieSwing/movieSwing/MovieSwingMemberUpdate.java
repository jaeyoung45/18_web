package movieSwing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import memberDBA.Member;
import memberDBA.UpdateDBA;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class MovieSwingMemberUpdate extends JFrame {

	private JPanel contentPane;
	private JLabel lblLoginid;
	private JLabel lblNewLabel;
	private JTextField tfBirth;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel label;
	private JTextField tfAddr;
	private JLabel lblNewLabel_3;
	private JTextField tfEmail;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
//	MovieSwingMain msm = new MovieSwingMain();
	private JPasswordField tfPwd;
	private JPasswordField tfPwdc;
	private JTextField tfLoginid;
	private String id;
	UpdateDBA udba = new UpdateDBA();
	private JLabel lblNewLabel_4;
	private JTextField tfName;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton_2;
	

/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieSwingMemberUpdate frame = new MovieSwingMemberUpdate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/


	public MovieSwingMemberUpdate(String id) {
		setResizable(false);
		this.id=id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLoginid());
		contentPane.add(getLblNewLabel());
		contentPane.add(getTfBirth());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLabel());
		contentPane.add(getTfAddr());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getTfEmail());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getTfPwd());
		contentPane.add(getTfPwdc());
		contentPane.add(getTextField_1_1());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getTfName());
		contentPane.add(getLblNewLabel_5());
		contentPane.add(getBtnNewButton_2());
		
		ArrayList<Member> arr = udba.updateView(id);
		
		for( int i = 0 ; i<arr.size() ; i++) {
			tfName.setText(arr.get(i).getName());
			tfBirth.setText(arr.get(i).getBirth());
			tfAddr.setText(arr.get(i).getAddr());
			tfEmail.setText(arr.get(i).getEmail());
		}
	}
	private JLabel getLblLoginid() {
		if (lblLoginid == null) {
			lblLoginid = new JLabel("님의 회원정보수정 입니다.");
			lblLoginid.setHorizontalAlignment(SwingConstants.CENTER);
			lblLoginid.setBounds(152, 21, 156, 15);
		}
		return lblLoginid;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("생일 변경");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setBounds(98, 157, 57, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTfBirth() {
		if (tfBirth == null) {
			tfBirth = new JTextField();
			tfBirth.setBounds(167, 154, 116, 21);
			tfBirth.setColumns(10);
		}
		return tfBirth;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("*비밀번호 변경");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setBounds(46, 75, 109, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("*변경 확인");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setBounds(46, 106, 109, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("주소 변경");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setBounds(98, 188, 57, 15);
		}
		return label;
	}
	private JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setBounds(167, 185, 116, 21);
			tfAddr.setColumns(10);
		}
		return tfAddr;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("이메일 변경");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_3.setBounds(72, 217, 83, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setBounds(167, 216, 116, 21);
			tfEmail.setColumns(10);
		}
		return tfEmail;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("정보 수정");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!String.valueOf(tfPwd.getPassword()).equals(String.valueOf(tfPwdc.getPassword()))){
						JOptionPane.showMessageDialog(null, "비밀번호 변경과 변경확인이 불일치 합니다.");
						tfPwdc.setText("");
						return;
					}
					Member m = new Member();
					m.setId(id);
					m.setPwd(tfPwd.getPassword());
					m.setName(tfName.getText());
					m.setBirth(tfBirth.getText());
					m.setAddr(tfAddr.getText());
					m.setEmail(tfEmail.getText());
					udba.updateInfo(m);
				}
			});
			btnNewButton.setBounds(88, 247, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("돌아가기");
			btnNewButton_1.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					new MovieSwingMain(id).setVisible(true);
				}
			});
			btnNewButton_1.setBounds(197, 247, 97, 23);
		}
		return btnNewButton_1;
	}
	private JPasswordField getTfPwd() {
		if (tfPwd == null) {
			tfPwd = new JPasswordField();
			tfPwd.setBounds(167, 72, 116, 21);
		}
		return tfPwd;
	}
	private JPasswordField getTfPwdc() {
		if (tfPwdc == null) {
			tfPwdc = new JPasswordField();
			tfPwdc.setBounds(167, 103, 116, 21);
		}
		return tfPwdc;
	}
	private JTextField getTextField_1_1() {
		if (tfLoginid == null) {
			tfLoginid = new JTextField(id);
			
			tfLoginid.setEditable(false);
			tfLoginid.setBounds(57, 18, 97, 21);
			tfLoginid.setColumns(10);
		}
		return tfLoginid;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("이름 변경");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_4.setBounds(98, 131, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(167, 128, 116, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("*가 들어간 것은 필수 입력입니다.");
			lblNewLabel_5.setBounds(71, 46, 223, 15);
		}
		return lblNewLabel_5;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("회원 탈퇴");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					udba.deleteUserAction(tfLoginid.getText());
					udba.deleteUser(tfLoginid.getText());
					JOptionPane.showMessageDialog(null, "회원탈퇴 되었습니다.");
					new MovieSwingLogin().setVisible(true);
					setVisible(false);
				}
			});
			btnNewButton_2.setBounds(167, 280, 97, 23);
		}
		return btnNewButton_2;
	}
}
