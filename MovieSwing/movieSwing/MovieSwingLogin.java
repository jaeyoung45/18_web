package movieSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import memberDBA.LoginDBA;
import memberDBA.Member;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;

public class MovieSwingLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JPasswordField tfPwd;
	LoginDBA ldba = new LoginDBA();
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieSwingLogin frame = new MovieSwingLogin();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MovieSwingLogin() {
		setResizable(false);
		setTitle("영화평론가들");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(27, 70, 62, 18);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(27, 131, 62, 18);
		contentPane.add(lblNewLabel_1);

		tfId = new JTextField();
		tfId.setBounds(103, 70, 116, 24);
		contentPane.add(tfId);
		tfId.setColumns(10);

		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tfId.getText();
				String pass = String.valueOf(tfPwd.getPassword());
				
				if (ldba.Login(id, pass)) {
					MovieSwingMain msm = new MovieSwingMain(id);//id 정보를 들고 메인뷰로 들어감
					
					new MovieSwingMemberUpdate(id);//회원정보에도 id를 들고 들어감
					
					JOptionPane.showMessageDialog(null, "로그인성공");
					msm.setVisible(true);// 메인뷰가 나오게 하고
					setVisible(false);// 본인은 사라지도록
				} else {//비밀번호가 틀렸을 경우
					JOptionPane.showMessageDialog(null, "ID와 비밀번호가 맞지 않습니다.");
					tfPwd.setText("");
				};
			}
		});
		btnLogin.setBounds(231, 70, 105, 49);
		contentPane.add(btnLogin);

		JButton btnRegister = new JButton("회원가입");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MovieSwingRegister mr = new MovieSwingRegister();
				mr.setVisible(true);
			}
		});
		btnRegister.setBounds(103, 174, 105, 27);
		contentPane.add(btnRegister);

		JLabel lblNewLabel_2 = new JLabel("영화 평론가들의 모임에 오신것을 환영합니다.");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setBounds(27, 12, 391, 37);
		contentPane.add(lblNewLabel_2);

		tfPwd = new JPasswordField();
		tfPwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogin.doClick();
			}
		});
		tfPwd.setBounds(103, 128, 116, 24);
		contentPane.add(tfPwd);
		
		JButton btnNewButton = new JButton("관리자모드");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagerSwingLogin().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(239, 174, 116, 27);
		contentPane.add(btnNewButton);
	}	

	}
