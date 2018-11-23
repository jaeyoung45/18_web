package swing2.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TrainView extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JComboBox<String> comboBox;
	private JSplitPane splitPane_1;
	private JPanel panel;
	private JRadioButton rB1;
	private JRadioButton rB2;
	private JComboBox cB1;
	private JComboBox cB2;
	private JComboBox cB3;
	private JComboBox cB4;
	private JComboBox cB5;
	private JPanel panel_1;
	private JRadioButton rb3;
	private JComboBox cB6;
	private JComboBox cB7;
	private JComboBox cB8;
	private JSplitPane splitPane_2;
	private JSplitPane splitPane_3;
	private JPanel panel_2;
	private JRadioButton rB4;
	private JRadioButton rB5;
	private JRadioButton rB6;
	private JRadioButton rB7;
	private JRadioButton rB8;
	private JRadioButton rB9;
	private JPanel panel_3;
	private JRadioButton rB10;
	private JRadioButton rB11;
	private JTextField tF3;
	private JTextField tF6;
	private JComboBox<String> cB9;
	private JPanel panel_4;
	private JButton btn2;
	private JButton btn4;
	private JButton btn3;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainView frame = new TrainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TrainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getSplitPane_1());
			splitPane.setRightComponent(getSplitPane_2());
			splitPane.setDividerLocation(300);
		}
		return splitPane;
	}

	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setLeftComponent(getPanel_1());
			splitPane_1.setRightComponent(getPanel_1_1());
			splitPane_1.setDividerLocation(200);
		}
		return splitPane_1;
	}

	private JPanel getPanel_1() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getRadioButton_2());
			panel.add(getRadioButton_1_1());
			panel.add(getComboBox_1_1());
			panel.add(getComboBox_2_1());
			panel.add(getComboBox_3_1());
			panel.add(getComboBox_4_1());
			panel.add(getComboBox_5_1());
		}
		return panel;
	}

	private JRadioButton getRadioButton_2() {
		if (rB1 == null) {
			rB1 = new JRadioButton("장애급수");
			rB1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			rB1.setBounds(193, 23, 73, 23);
		}
		return rB1;
	}

	private JRadioButton getRadioButton_1_1() {
		if (rB2 == null) {
			rB2 = new JRadioButton("인원정보");
			rB2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			rB2.setBounds(23, 23, 73, 23);
		}
		return rB2;
	}

	private JComboBox<String> getComboBox_1_1() {
		if (cB1 == null) {
			cB1 = new JComboBox<String>();
			cB1.setModel(new DefaultComboBoxModel(new String[] { "장애 1-3급 1명",
					"장애 1-3급 2명", "장애 1-3급 3명", "장애 1-3급 4명" }));
			cB1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			cB1.setBounds(156, 46, 110, 23);

		}
		return cB1;
	}

	private JComboBox<String> getComboBox_2_1() {
		if (cB2 == null) {
			cB2 = new JComboBox();
			cB2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			cB2.setBounds(156, 89, 110, 21);
			cB2.addItem("장애 4-6급 1명");
			cB2.addItem("장애 4-6급 2명");
			cB2.addItem("장애 4-6급 3명");
			cB2.addItem("장애 4-6급 4명");
		}
		return cB2;
	}

	private JComboBox<String> getComboBox_3_1() {
		if (cB3 == null) {
			cB3 = new JComboBox();
			cB3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			cB3.setBounds(12, 134, 110, 23);
			cB3.addItem("경로 1명");
			cB3.addItem("경로 2명");
			cB3.addItem("경로 3명");
			cB3.addItem("경로 4명");
		}
		return cB3;
	}

	private JComboBox getComboBox_4_1() {
		if (cB4 == null) {
			cB4 = new JComboBox();
			cB4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			cB4.setBounds(12, 87, 110, 23);
			cB4.addItem("어린이 1명");
			cB4.addItem("어린이 2명");
			cB4.addItem("어린이 3명");
			cB4.addItem("어린이 4명");
		}
		return cB4;
	}

	private JComboBox<String> getComboBox_5_1() {
		if (cB5 == null) {
			cB5 = new JComboBox();
			cB5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			cB5.setBounds(12, 49, 110, 21);
			cB5.addItem("어른 1명");
			cB5.addItem("어른 2명");
			cB5.addItem("어른 3명");
			cB5.addItem("어른 4명");
		}
		return cB5;
	}

	private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getRadioButton_3());
			panel_1.add(getComboBox_1_2());
			panel_1.add(getComboBox_2_2());
			panel_1.add(getComboBox_3_2());
		}
		return panel_1;
	}

	private JRadioButton getRadioButton_3() {
		if (rb3 == null) {
			rb3 = new JRadioButton("좌석종류선택");
			rb3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			rb3.setBounds(8, 20, 121, 23);
		}
		return rb3;
	}

	private JComboBox getComboBox_1_2() {
		if (cB6 == null) {
			cB6 = new JComboBox();
			cB6.setBounds(12, 58, 121, 23);
			cB6.addItem("기본");
			cB6.addItem("1인석");
			cB6.addItem("창측내석");
			cB6.addItem("내측내석");
		}
		return cB6;
	}

	private JComboBox<String> getComboBox_2_2() {
		if (cB7 == null) {
			cB7 = new JComboBox();
			cB7.setBounds(164, 58, 121, 23);
			cB7.addItem("좌석방향");
			cB7.addItem("순방향석");
			cB7.addItem("역방향석");
		}
		return cB7;
	}

	private JComboBox<String> getComboBox_3_2() {
		if (cB8 == null) {
			cB8 = new JComboBox();
			cB8.setBounds(98, 107, 121, 23);
			cB8.addItem("기본");
			cB8.addItem("유아동반");
			cB8.addItem("편안대화");
			cB8.addItem("노트북");
			cB8.addItem("휠체어");
			cB8.addItem("전동휠체어");
			cB8.addItem("수유실 인접");
			cB8.addItem("2층석");
			cB8.addItem("자전거 거치대");
		}
		return cB8;
	}

	private JSplitPane getSplitPane_2() {
		if (splitPane_2 == null) {
			splitPane_2 = new JSplitPane();
			splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_2.setLeftComponent(getSplitPane_3());
			splitPane_2.setRightComponent(getPanel_4());
			splitPane_2.setDividerLocation(350);
		}
		return splitPane_2;
	}

	private JSplitPane getSplitPane_3() {
		if (splitPane_3 == null) {
			splitPane_3 = new JSplitPane();
			splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_3.setLeftComponent(getPanel_2_1());
			splitPane_3.setRightComponent(getPanel_3());
			splitPane_3.setDividerLocation(150);
		}
		return splitPane_3;
	}

	private JPanel getPanel_2_1() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.add(getRB4());
			panel_2.add(getRB5());
			panel_2.add(getRB6());
			panel_2.add(getRB7());
			panel_2.add(getRB8());
			panel_2.add(getRB9());
		}
		return panel_2;
	}

	private JRadioButton getRB4() {
		if (rB4 == null) {
			rB4 = new JRadioButton("전체");
			rB4.setBounds(8, 6, 121, 23);
		}
		return rB4;
	}

	private JRadioButton getRB5() {
		if (rB5 == null) {
			rB5 = new JRadioButton("KTX/KTX-산천/SRT");
			rB5.setBounds(8, 41, 148, 23);
		}
		return rB5;
	}

	private JRadioButton getRB6() {
		if (rB6 == null) {
			rB6 = new JRadioButton("새마을호/ITX-새마을");
			rB6.setBounds(8, 74, 148, 23);
		}
		return rB6;
	}

	private JRadioButton getRB7() {
		if (rB7 == null) {
			rB7 = new JRadioButton("통근열차");
			rB7.setBounds(8, 108, 148, 23);
		}
		return rB7;
	}

	private JRadioButton getRB8() {
		if (rB8 == null) {
			rB8 = new JRadioButton("ITX-청춘");
			rB8.setBounds(183, 41, 148, 23);
		}
		return rB8;
	}

	private JRadioButton getRB9() {
		if (rB9 == null) {
			rB9 = new JRadioButton("무궁화호/누리로");
			rB9.setBounds(183, 74, 148, 23);
		}
		return rB9;
	}

	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.add(getRadioButton_4());
			panel_3.add(getRadioButton_5());
			panel_3.add(getTF3());
			panel_3.add(getTextField_1_1());
			panel_3.add(getCB9());
			panel_3.add(getLblNewLabel());
			panel_3.add(getLabel());
			panel_3.add(getLabel_1());
			panel_3.add(getLabel_2());
		}
		return panel_3;
	}

	private JRadioButton getRadioButton_4() {
		if (rB10 == null) {
			rB10 = new JRadioButton("환승");
			rB10.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			rB10.setBounds(85, 9, 49, 23);
		}
		return rB10;
	}

	private JRadioButton getRadioButton_5() {
		if (rB11 == null) {
			rB11 = new JRadioButton("왕복");
			rB11.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			rB11.setBounds(185, 9, 54, 23);
		}
		return rB11;
	}

	private JTextField getTF3() {
		if (tF3 == null) {
			tF3 = new JTextField();
			tF3.setBounds(85, 41, 116, 21);
			tF3.setColumns(10);
		}
		return tF3;
	}

	private JTextField getTextField_1_1() {
		if (tF6 == null) {
			tF6 = new JTextField();
			tF6.setColumns(10);
			tF6.setBounds(85, 79, 116, 21);
		}
		return tF6;
	}

	private JComboBox<String> getCB9() {
		if (cB9 == null) {
			cB9 = new JComboBox<String>();
			cB9.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			cB9.setBounds(85, 129, 132, 21);
			cB9.addItem("2018-11-19-월");
			cB9.addItem("2018-11-20-화");
			cB9.addItem("2018-11-21-수");
			cB9.addItem("2018-11-22-목");
			cB9.addItem("2018-11-23-금");
			cB9.addItem("2018-11-24-토");
			cB9.addItem("2018-11-25-일");
		}
		return cB9;
	}

	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(null);
			panel_4.add(getBtn2());
			panel_4.add(getBtn4());
			panel_4.add(getBtn3());
		}
		return panel_4;
	}

	private JButton getBtn2() {
		if (btn2 == null) {
			btn2 = new JButton("로그인");
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Login l = new Login();
					l.setVisible(true);
				}
			});
			btn2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			btn2.setBounds(12, 26, 97, 23);

		}
		return btn2;
	}

	private JButton getBtn4() {
		if (btn4 == null) {
			btn4 = new JButton("조회하기");
			btn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			btn4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			btn4.setBounds(244, 26, 97, 23);
		}
		return btn4;
	}

	private JButton getBtn3() {
		if (btn3 == null) {
			btn3 = new JButton("회원가입");
			btn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SignUp s = new SignUp();
					s.setVisible(true);
				}
			});
			btn3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			btn3.setBounds(121, 27, 97, 23);

		}
		return btn3;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("출발일");
			lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			lblNewLabel.setBounds(12, 133, 57, 15);
		}
		return lblNewLabel;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("도착역");
			label.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			label.setBounds(9, 82, 57, 15);
		}
		return label;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("출발역");
			label_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			label_1.setBounds(9, 41, 57, 15);
		}
		return label_1;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("여정경로");
			label_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			label_2.setBounds(12, 14, 57, 15);
		}
		return label_2;
	}
}
