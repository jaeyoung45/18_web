package movieSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import memberDBA.Member;
import memberDBA.RegisterDBA;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class MovieSwingRegister extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfBirth;
	private JTextField tfAddr;
	private JTextField tfEmail;
	private JComboBox cbGender;

	RegisterDBA rdba = new RegisterDBA();
	private JTextField tfName;
	private JPasswordField tfPwd;
	private JPasswordField tfPwdc;
	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieSwingRegister frame = new MovieSwingRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public MovieSwingRegister() {
		setResizable(false);
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("*ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(66, 59, 62, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("*비밀번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(49, 105, 79, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("성별");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(66, 220, 62, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("생일");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(66, 268, 62, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("주소");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(66, 326, 62, 18);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("이메일");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(66, 379, 62, 18);
		contentPane.add(lblNewLabel_5);
		
		JButton btnCheck = new JButton("중복확인");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = rdba.idCheck(tfId.getText());
				if(tfId.getText().isEmpty()) {//boolean값을 반환하기 때문에 true이면 중복체크를 요구하고 return
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
					return;
				}else if(flag == true) {
					JOptionPane.showMessageDialog(null, "중복되는 아이디 입니다.\n 다시 작성해주세요");
					tfId.setText("");
				}else {					
					int confirm = JOptionPane.showConfirmDialog(null, "사용가능한 아이디 입니다.\n 확정하시겠습니까?.","아이디 확인",JOptionPane.YES_NO_OPTION);
					if(confirm == JOptionPane.YES_OPTION) {
						btnCheck.setEnabled(false);
						tfId.setEditable(false);
					}
				}
			}
		});
		
		JButton btnConfirm = new JButton("가입신청");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Member m = new Member();
				m.setId(tfId.getText());
				m.setPwd(tfPwd.getPassword());//패스워트 필드
				m.setGender(String.valueOf(cbGender.getSelectedItem()));
				m.setBirth(tfBirth.getText());
				m.setAddr(tfAddr.getText());
				m.setEmail(tfEmail.getText());
				m.setName(tfName.getText());
			   if(tfId.isEditable()) {//boolean값을 반환하기 때문에 true이면 중복체크를 요구하고 return
					JOptionPane.showMessageDialog(null, "중복확인을 해주세요");
					return;
				}
				if(tfPwd.getPassword().length==0) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요");
					return;
				}
				if(String.valueOf(tfPwd.getPassword()).equals(String.valueOf(tfPwdc.getPassword()))) {
				rdba.memberInsert(m);
				JOptionPane.showMessageDialog(null, "가입이 완료되었습니다.");
				setVisible(false);
				}else {
				JOptionPane.showMessageDialog(null, "비밀번호가 일지 하지 않습니다.");
				}
			}
		});
		btnConfirm.setBounds(118, 452, 105, 27);
		contentPane.add(btnConfirm);
		
		JButton btnReset = new JButton("다시작성");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
			}
		});
		btnReset.setBounds(251, 452, 105, 27);
		contentPane.add(btnReset);
		
		tfId = new JTextField();
		tfId.setBounds(171, 56, 145, 24);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfBirth = new JTextField();
		tfBirth.setColumns(10);
		tfBirth.setBounds(171, 265, 145, 24);
		contentPane.add(tfBirth);
		
		tfAddr = new JTextField();
		tfAddr.setColumns(10);
		tfAddr.setBounds(171, 323, 145, 24);
		contentPane.add(tfAddr);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(171, 376, 145, 24);
		contentPane.add(tfEmail);
		

		btnCheck.setFont(new Font("굴림", Font.PLAIN, 12));
		btnCheck.setBounds(333, 55, 88, 27);
		contentPane.add(btnCheck);
		
		
		cbGender = new JComboBox();
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"남자", "여자"}));
		cbGender.setBounds(185, 217, 105, 24);
		contentPane.add(cbGender);
		
		JLabel lblNewLabel_6 = new JLabel("성명");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(66, 171, 62, 18);
		contentPane.add(lblNewLabel_6);
		
		tfName = new JTextField();
		tfName.setBounds(171, 168, 145, 24);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfPwd = new JPasswordField();
		tfPwd.setBounds(171, 102, 145, 24);
		contentPane.add(tfPwd);
		
		JLabel lblNewLabel_7 = new JLabel("*표시는 필수입력 입니다.");
		lblNewLabel_7.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_7.setBounds(49, 29, 203, 18);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("1990년 10월 25일생이면 ex) 19901025");
		lblNewLabel_8.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(118, 296, 263, 18);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("*비밀번호 확인");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setBounds(14, 135, 114, 18);
		contentPane.add(lblNewLabel_9);
		
		tfPwdc = new JPasswordField();
		tfPwdc.setBounds(171, 132, 145, 24);
		contentPane.add(tfPwdc);
		
		JButton button = new JButton("로그인 화면으로 돌아가기");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MovieSwingLogin().setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(118, 495, 238, 27);
		contentPane.add(button);
	}
	public void clear() {
		tfId.setText("");
		tfPwd.setText("");
		tfBirth.setText("");
		tfAddr.setText("");
		tfEmail.setText("");
		tfName.setText("");
	}
}
