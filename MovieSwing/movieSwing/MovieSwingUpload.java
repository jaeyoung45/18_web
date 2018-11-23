package movieSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import movieDBA.Movie;
import movieDBA.UploadDBA;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Visibility;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class MovieSwingUpload extends JFrame {

	private JPanel contentPane;
	private JTextField tfTitle;
	private JTextField tfDirector;
	private JTextField tfActor;
	private JTextField tfRuntime;
	private String id;
	private JLabel lblAlert;
	
	Movie movie = new Movie();
	UploadDBA dba = new UploadDBA();
	private JTextField tfPoster;
	private JLabel lblPoster;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieSwingUpload frame = new MovieSwingUpload();
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
	public MovieSwingUpload(String id) {
		setResizable(false);
		this.id=id;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("영화 제목");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("굴림", Font.BOLD, 16));
		label.setBounds(14, 36, 96, 18);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("감독");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel.setBounds(14, 70, 96, 18);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("출연진");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1.setBounds(14, 114, 96, 18);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("개봉 년도");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_2.setBounds(24, 157, 86, 18);
		panel.add(lblNewLabel_2);
		
		tfTitle = new JTextField();
		tfTitle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				boolean flag = dba.titleCheck(tfTitle.getText());
				if(flag == true) {
					lblAlert.setVisible(true);
					lblAlert.setText(dba.titleAlert(tfTitle.getText())+" 가 이미 있습니다.");
				}else {
					lblAlert.setVisible(false);
				}
			}
		});
		tfTitle.setBounds(114, 35, 116, 24);
		panel.add(tfTitle);
		tfTitle.setColumns(10);
		
		tfDirector = new JTextField();
		tfDirector.setBounds(114, 69, 116, 24);
		panel.add(tfDirector);
		tfDirector.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("개봉 월");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_3.setBounds(24, 200, 86, 18);
		panel.add(lblNewLabel_3);
		
		JComboBox cbYear = new JComboBox();
		cbYear.setModel(new DefaultComboBoxModel(new String[] {"", "2014년", "2015년", "2016년", "2017년", "2018년", "2019년"}));
		cbYear.setBounds(114, 155, 94, 24);
		panel.add(cbYear);
		
		JComboBox cbMonth = new JComboBox();
		cbMonth.setModel(new DefaultComboBoxModel(new String[] {"", "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"}));
		cbMonth.setBounds(114, 198, 94, 24);
		panel.add(cbMonth);
		
		tfActor = new JTextField();
		tfActor.setBounds(114, 108, 116, 24);
		panel.add(tfActor);
		tfActor.setColumns(10);
		
		JLabel label_1 = new JLabel("런타임");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("굴림", Font.BOLD, 16));
		label_1.setBounds(24, 239, 86, 18);
		panel.add(label_1);
		
		JLabel lblNewLabel_4 = new JLabel("상영등급");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_4.setBounds(24, 278, 86, 18);
		panel.add(lblNewLabel_4);
		
		tfRuntime = new JTextField();
		tfRuntime.setBounds(114, 238, 116, 24);
		panel.add(tfRuntime);
		tfRuntime.setColumns(10);
		
		JComboBox cbLimit = new JComboBox();
		cbLimit.setModel(new DefaultComboBoxModel(new String[] {"", "전체 이용가", "12세 이용가", "15세 이용가", "19세 이용가"}));
		cbLimit.setBounds(114, 276, 116, 24);
		panel.add(cbLimit);
		
		JComboBox cbGenre = new JComboBox();
		cbGenre.setModel(new DefaultComboBoxModel(new String[] {"", "드라마", "SF", "공포", "액션", "느와르", "학교", "미스터리", "판타지"}));
		cbGenre.setBounds(312, 70, 94, 24);
		panel.add(cbGenre);
		
		JButton btnNewButton = new JButton("영화 업로드");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfTitle.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "영화명은 반드시 입력하세요. ");
					return;
				}
				movie.setTitle(tfTitle.getText());
				movie.setDirector(tfDirector.getText());
				movie.setActor(tfActor.getText());
				movie.setYear(String.valueOf(cbYear.getSelectedItem()));
				movie.setMonth(String.valueOf(cbMonth.getSelectedItem()));
				movie.setRuntime(tfRuntime.getText());
				movie.setLimit(String.valueOf(cbLimit.getSelectedItem()));
				movie.setGenre(String.valueOf(cbGenre.getSelectedItem()));
				movie.setPoster(tfPoster.getText());
				dba.Upload(movie);
				clear();
			}
		});
		btnNewButton.setBounds(47, 349, 144, 27);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("다시 작성");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnNewButton_1.setBounds(204, 349, 116, 27);
		panel.add(btnNewButton_1);
		
		JButton btnComeback = new JButton("돌아가기");
		btnComeback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new MovieSwingMain(id).setVisible(true);
				setVisible(false);
				
			}
		});
		btnComeback.setBounds(337, 349, 105, 27);
		panel.add(btnComeback);
		
		JLabel lblNewLabel_5 = new JLabel("장르");
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_5.setBounds(244, 73, 62, 18);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("포스터");
		lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_6.setBounds(242, 105, 77, 15);
		panel.add(lblNewLabel_6);
		panel.add(getTfPoster());
		panel.add(getLblPoster());
		
		lblAlert = new JLabel("");
		lblAlert.setFont(new Font("굴림", Font.PLAIN, 10));
		lblAlert.setVisible(false);
		lblAlert.setBounds(242, 36, 225, 23);
		panel.add(lblAlert);
		

	}
	public void clear() {
		tfTitle.setText("");
		tfDirector.setText("");
		tfActor.setText("");
		tfRuntime.setText("");
	}
	private JTextField getTfPoster() {
		if (tfPoster == null) {
			tfPoster = new JTextField();
			tfPoster.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					ImageIcon icon = new ImageIcon("img\\"+tfPoster.getText());
					lblPoster.setIcon(icon);
				}
			});
			tfPoster.setBounds(312, 102, 116, 21);
			tfPoster.setColumns(10);
		}
		return tfPoster;
	}
	private JLabel getLblPoster() {
		if (lblPoster == null) {
			lblPoster = new JLabel("");
			lblPoster.setBounds(241, 124, 187, 215);
		}
		return lblPoster;
	}
}
