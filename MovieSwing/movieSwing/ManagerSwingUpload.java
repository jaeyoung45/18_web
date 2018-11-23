package movieSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import movieDBA.Movie;
import movieDBA.UploadDBA;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManagerSwingUpload extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField tfTitle;
	private JTextField tfDirector;
	private JLabel label_4;
	private JComboBox cbYear;
	private JComboBox cbMonth;
	private JTextField tfActor;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField tfRuntime;
	private JComboBox cbLimit;
	private JComboBox cbGenre;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JLabel label_7;
	private JLabel label_8;
	private JTextField tfPoster;
	private JLabel label_9;
	Movie movie = new Movie();
	UploadDBA dba = new UploadDBA();
	private JLabel lblAlert;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ManagerSwingUpload() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 487);
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
			panel.add(getLabel());
			panel.add(getLabel_1());
			panel.add(getLabel_2());
			panel.add(getLabel_3());
			panel.add(getTfTitle());
			panel.add(getTfDirector());
			panel.add(getLabel_4());
			panel.add(getCbYear());
			panel.add(getCbMonth());
			panel.add(getTfActor());
			panel.add(getLabel_5());
			panel.add(getLabel_6());
			panel.add(getTfRuntime());
			panel.add(getCbLimit());
			panel.add(getCbGenre());
			panel.add(getButton());
			panel.add(getButton_1());
			panel.add(getButton_2());
			panel.add(getLabel_7());
			panel.add(getLabel_8());
			panel.add(getTfPoster());
			panel.add(getLabel_9());
			panel.add(getLblAlert());
		}
		return panel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("영화 제목");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("굴림", Font.BOLD, 16));
			label.setBounds(12, 30, 96, 18);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("감독");
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setFont(new Font("굴림", Font.BOLD, 16));
			label_1.setBounds(12, 79, 96, 18);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("출연진");
			label_2.setHorizontalAlignment(SwingConstants.RIGHT);
			label_2.setFont(new Font("굴림", Font.BOLD, 16));
			label_2.setBounds(12, 120, 96, 18);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("개봉 년도");
			label_3.setHorizontalAlignment(SwingConstants.RIGHT);
			label_3.setFont(new Font("굴림", Font.BOLD, 16));
			label_3.setBounds(22, 159, 86, 18);
		}
		return label_3;
	}
	private JTextField getTfTitle() {
		if (tfTitle == null) {
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
			tfTitle.setColumns(10);
			tfTitle.setBounds(112, 29, 116, 24);
		}
		return tfTitle;
	}
	private JTextField getTfDirector() {
		if (tfDirector == null) {
			tfDirector = new JTextField();
			tfDirector.setColumns(10);
			tfDirector.setBounds(112, 78, 116, 24);
		}
		return tfDirector;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("개봉 월");
			label_4.setHorizontalAlignment(SwingConstants.RIGHT);
			label_4.setFont(new Font("굴림", Font.BOLD, 16));
			label_4.setBounds(22, 203, 86, 18);
		}
		return label_4;
	}
	private JComboBox getCbYear() {
		if (cbYear == null) {
			cbYear = new JComboBox();
			cbYear.setModel(new DefaultComboBoxModel(new String[] {"", "2014년", "2015년", "2016년", "2017년", "2018년", "2019년"}));
			cbYear.setBounds(112, 157, 94, 24);
		}
		return cbYear;
	}
	private JComboBox getCbMonth() {
		if (cbMonth == null) {
			cbMonth = new JComboBox();
			cbMonth.setModel(new DefaultComboBoxModel(new String[] {"", "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"}));
			cbMonth.setBounds(112, 197, 94, 24);
		}
		return cbMonth;
	}
	private JTextField getTfActor() {
		if (tfActor == null) {
			tfActor = new JTextField();
			tfActor.setColumns(10);
			tfActor.setBounds(112, 119, 116, 24);
		}
		return tfActor;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("런타임");
			label_5.setHorizontalAlignment(SwingConstants.RIGHT);
			label_5.setFont(new Font("굴림", Font.BOLD, 16));
			label_5.setBounds(22, 249, 86, 18);
		}
		return label_5;
	}
	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("상영등급");
			label_6.setHorizontalAlignment(SwingConstants.RIGHT);
			label_6.setFont(new Font("굴림", Font.BOLD, 16));
			label_6.setBounds(22, 296, 86, 18);
		}
		return label_6;
	}
	private JTextField getTfRuntime() {
		if (tfRuntime == null) {
			tfRuntime = new JTextField();
			tfRuntime.setColumns(10);
			tfRuntime.setBounds(112, 243, 116, 24);
		}
		return tfRuntime;
	}
	private JComboBox getCbLimit() {
		if (cbLimit == null) {
			cbLimit = new JComboBox();
			cbLimit.setModel(new DefaultComboBoxModel(new String[] {"", "전체 이용가", "12세 이용가", "15세 이용가", "19세 이용가"}));
			cbLimit.setBounds(112, 294, 116, 24);
		}
		return cbLimit;
	}
	private JComboBox getCbGenre() {
		if (cbGenre == null) {
			cbGenre = new JComboBox();
			cbGenre.setModel(new DefaultComboBoxModel(new String[] {"", "드라마", "SF", "공포", "액션", "느와르", "학교", "미스터리", "판타지"}));
			cbGenre.setBounds(309, 60, 94, 24);
		}
		return cbGenre;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("영화 업로드");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
			button.setBounds(42, 360, 144, 27);
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("다시 작성");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clear();
				}
			});
			button_1.setBounds(200, 360, 116, 27);
		}
		return button_1;
	}
	private JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("돌아가기");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			button_2.setBounds(330, 360, 105, 27);
		}
		return button_2;
	}
	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("장르");
			label_7.setFont(new Font("굴림", Font.BOLD, 16));
			label_7.setBounds(241, 63, 62, 18);
		}
		return label_7;
	}
	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("포스터");
			label_8.setFont(new Font("굴림", Font.BOLD, 16));
			label_8.setBounds(239, 95, 77, 15);
		}
		return label_8;
	}
	private JTextField getTfPoster() {
		if (tfPoster == null) {
			tfPoster = new JTextField();
			tfPoster.setColumns(10);
			tfPoster.setBounds(309, 92, 116, 21);
		}
		return tfPoster;
	}
	private JLabel getLabel_9() {
		if (label_9 == null) {
			label_9 = new JLabel("");
			label_9.setBounds(240, 130, 185, 220);
		}
		return label_9;
	}
	public void clear() {
		tfTitle.setText("");
		tfDirector.setText("");
		tfActor.setText("");
		tfRuntime.setText("");
	}
	private JLabel getLblAlert() {
		if (lblAlert == null) {
			lblAlert = new JLabel("");
			lblAlert.setFont(new Font("굴림", Font.PLAIN, 10));
			lblAlert.setBounds(240, 33, 219, 20);
		}
		return lblAlert;
	}
}
