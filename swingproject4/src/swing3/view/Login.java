package swing3.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import swing3.model.TrainDBA;

public class Login extends JFrame {

	protected static Object btnView;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tfId;
	private JButton BtnLogin;
	private JButton BtnCancel;
	private JLabel lblNewLabel_1;
	private JLabel lblPw;
	private JPasswordField tfPass;
	TrainDBA dba= new TrainDBA();
	

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
		contentPane.add(getTfId());
		contentPane.add(getBtnLogin());
		contentPane.add(getBtnCancel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblPw());
		contentPane.add(getTfPass());
		
		JButton btnsignup = new JButton("회원가입");
		btnsignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUp SignUp = new SignUp();
				SignUp.setVisible(true);
				dispose();
			}
		});
		btnsignup.setBounds(239, 269, 97, 23);
		contentPane.add(btnsignup);
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Login");
			lblNewLabel.setFont(new Font("바탕", Font.BOLD, 28));
			lblNewLabel.setBounds(217, 43, 310, 95);
		}
		return lblNewLabel;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(227, 148, 116, 21);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JButton getBtnLogin() { 
	      if (BtnLogin == null) {
	         BtnLogin = new JButton("로그인");
	         BtnLogin.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	     String id = tfId.getText();
	        	     char[] s = tfPass.getPassword();
	        	     String pwd = String.valueOf(s);
	        	     System.out.println("pwd : " + pwd);
	        	     int i  =  dba.login(id,pwd);
						if(i==0){
								JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "경고", 1);
						}else if(i==1){
							TrainView TrainView = new TrainView();
							TrainView.setVisible(true);
							
					    }else {
					    	JOptionPane.showMessageDialog(null, "아이디가 없습니다.", "경고", 1);
					    }
						dispose();
	              }
	         });
	      }
			BtnLogin.setBounds(102, 269, 97, 23);
		return BtnLogin;
		
	}
	protected static int dba(String text, String text2) {
		return 0;
	}

	private JButton getBtnCancel() {
		if (BtnCancel == null) {
			BtnCancel = new JButton("취소");
			BtnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			BtnCancel.setBounds(359, 269, 97, 23);
			
		}
		
		return BtnCancel;
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
	private JPasswordField getTfPass() {
		if (tfPass == null) {
			tfPass = new JPasswordField();
			tfPass.setBounds(227, 211, 116, 21);
		}
		return tfPass;
	}
}
