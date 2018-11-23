package movieSwing;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import movieDBA.ManagerCountDBA;
import movieDBA.ManagerUpdateDBA;
import movieDBA.Movie;
import movieDBA.MovieDBA;
import movieDBA.ReviewDBA;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLSyntaxErrorException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class ManagerPanelMovie extends JPanel {
	private JPanel panel;
	private JSplitPane splitPane;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel_2;
	private JSplitPane splitPane_1;
	private JPanel panel_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPanel panel_4;
	MovieDBA mdba = new MovieDBA();
	ReviewDBA rdba = new ReviewDBA();
	ArrayList<Movie> arr = mdba.AllView();
	ManagerPanelMember msme = new ManagerPanelMember();
	ManagerCountDBA mcdba = new ManagerCountDBA();
	ManagerUpdateDBA mudba = new ManagerUpdateDBA();
	private JSplitPane splitPane_2;
	private JPanel panel_5;
	private JPanel panel_6;
	private JSplitPane splitPane_3;
	private JPanel panel_7;
	private JPanel panel_8;
	private JTextField tfMalecnt;
	private JTextField tfFemalecnt;
	private JTextField maxScoreMovie;
	private JTextField tfPopularMovie;
	private JTextField tfMaleGenre;
	private JTextField tfFemaleGenre;
	private JTextField tfScore;
	private JTextField tfReCount;
	private JTextField tfManView;
	private JTextField tfWoView;
	private JTextField tfOpendate;
	private JComboBox cbYear;
	private JComboBox cbMonth;
	private JComboBox cbGenre;
	private JLabel lblTitle;
	private int cnt = 0;
	private JLabel lblNewLabel_14;
	private JLabel lblM_num;
	private JLabel lblMemberCnt;
	private JLabel lblMale_1;
	private JLabel lblFemale_1;
	private JLabel lblMale;
	private JLabel lblFemale;
	private JComboBox cbYear_1;
	private JComboBox cbMonth_1;
	private JButton btnAllview;
	private JButton btnNewButton_3;
	private JPanel panel_9;
	private JTabbedPane tabbedPane;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JLabel lblPoster;
	private JLabel label;
	private JTextField minScoreMovie;
	private JTextField tfMinorMovie;
	private JButton btnNewButton_2;

	/**
	 * Create the panel.
	 */
	public ManagerPanelMovie() {
		setLayout(new BorderLayout(0, 0));
		add(getPanel(), BorderLayout.CENTER);

	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getSplitPane(), BorderLayout.CENTER);
		}
		return panel;
	}
	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane.setDividerSize(1);
			splitPane.setLeftComponent(getPanel_1());
			splitPane.setRightComponent(getPanel_2());
			splitPane.setDividerLocation(150);
		}
		return splitPane;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panel_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					movieSearch();
					review();
				}
			});
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					movieSearch();
					review();
				}
			});
			String[] cols = {"MOVIE NO","TITLE","DIRECTOR","YEAR","MONTH","RUNTIME","GENRE","LIMIT","SCORE"};
			DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
			table.setModel(dt);
			for(int i = 0; i < arr.size() ; i++) {
				dt.setValueAt(arr.get(i).getMnum(), i, 0);
				dt.setValueAt(arr.get(i).getTitle(), i, 1);
				dt.setValueAt(arr.get(i).getDirector(), i, 2);
				dt.setValueAt(arr.get(i).getYear(), i, 3);
				dt.setValueAt(arr.get(i).getMonth(), i, 4);
				dt.setValueAt(arr.get(i).getRuntime(), i, 5);
				dt.setValueAt(arr.get(i).getGenre(), i, 6);
				dt.setValueAt(arr.get(i).getLimit(), i, 7);
				dt.setValueAt(rdba.showAvg(String.valueOf(arr.get(i).getMnum())), i, 8);
			}
		}
		return table;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new BorderLayout(0, 0));
			panel_2.add(getSplitPane_1(), BorderLayout.CENTER);
		}
		return panel_2;
	}
	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setDividerSize(1);
			splitPane_1.setLeftComponent(getPanel_3());
			splitPane_1.setRightComponent(getPanel_4());
			splitPane_1.setDividerLocation(150);
		}
		return splitPane_1;
	}
	private JButton getBtnAllview() {
		if (btnAllview == null) {
			btnAllview = new JButton("전체 보기");
			btnAllview.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Allview();
					
				}
			});
			btnAllview.setBounds(26, 170, 97, 23);
		}
		return btnAllview;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.add(getBtnNewButton());
			panel_3.add(getBtnNewButton_1());
			
			cbYear = new JComboBox();
			cbYear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<Movie> arr = mdba.movieYearSearch(cbYear.getSelectedItem());
					String[] cols = {"MOVIE NO","TITLE","DIRECTOR","YEAR","MONTH","RUNTIME","GENRE","LIMIT","SCORE"};
					DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
					table.setModel(dt);
					for(int i =0 ; i<arr.size() ; i++) {
						dt.setValueAt(arr.get(i).getMnum(), i, 0);
						dt.setValueAt(arr.get(i).getTitle(), i, 1);
						dt.setValueAt(arr.get(i).getDirector(), i, 2);
						dt.setValueAt(arr.get(i).getYear(), i, 3);
						dt.setValueAt(arr.get(i).getMonth(), i, 4);
						dt.setValueAt(arr.get(i).getRuntime(), i, 5);
						dt.setValueAt(arr.get(i).getGenre(), i, 6);
						dt.setValueAt(arr.get(i).getLimit(), i, 7);
						dt.setValueAt(rdba.showAvg(String.valueOf(arr.get(i).getMnum())), i, 8);
					cnt=1;
					cbMonth.setEnabled(true);
					}
				}
			});
			cbYear.setModel(new DefaultComboBoxModel(new String[] {"", "2014년", "2015년", "2016년", "2017년", "2018년", "2019년"}));
			cbYear.setBounds(53, 24, 82, 24);
			panel_3.add(cbYear);
			
			cbMonth = new JComboBox();
			cbMonth.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<Movie> arr = mdba.movieMonthSearch(cbYear.getSelectedItem(),cbMonth.getSelectedItem());
					String[] cols = {"MOVIE NO","TITLE","DIRECTOR","YEAR","MONTH","RUNTIME","GENRE","LIMIT","SCORE"};
					DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
					table.setModel(dt);
					for(int i =0 ; i<arr.size() ; i++) {
						dt.setValueAt(arr.get(i).getMnum(), i, 0);
						dt.setValueAt(arr.get(i).getTitle(), i, 1);
						dt.setValueAt(arr.get(i).getDirector(), i, 2);
						dt.setValueAt(arr.get(i).getYear(), i, 3);
						dt.setValueAt(arr.get(i).getMonth(), i, 4);
						dt.setValueAt(arr.get(i).getRuntime(), i, 5);
						dt.setValueAt(arr.get(i).getGenre(), i, 6);
						dt.setValueAt(arr.get(i).getLimit(), i, 7);
						dt.setValueAt(rdba.showAvg(String.valueOf(arr.get(i).getMnum())), i, 8);
					cnt=2;
					}
				}
			});
			cbMonth.setModel(new DefaultComboBoxModel(new String[] {"", "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"}));
			cbMonth.setEnabled(false);
			cbMonth.setBounds(53, 61, 82, 24);
			panel_3.add(cbMonth);
			
			JLabel lblNewLabel = new JLabel("년도");
			lblNewLabel.setBounds(14, 27, 62, 18);
			panel_3.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("월별");
			lblNewLabel_1.setBounds(14, 64, 50, 18);
			panel_3.add(lblNewLabel_1);
			
			cbGenre = new JComboBox();
			cbGenre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					arr= mdba.movieGenreSearch(cbGenre.getSelectedItem());
					String[] cols = {"MOVIE NO","TITLE","DIRECTOR","YEAR","MONTH","RUNTIME","GENRE","LIMIT","SCORE"};
					DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
					table.setModel(dt);
					for(int i =0 ; i<arr.size() ; i++) {
						dt.setValueAt(arr.get(i).getMnum(), i, 0);
						dt.setValueAt(arr.get(i).getTitle(), i, 1);
						dt.setValueAt(arr.get(i).getDirector(), i, 2);
						dt.setValueAt(arr.get(i).getYear(), i, 3);
						dt.setValueAt(arr.get(i).getMonth(), i, 4);
						dt.setValueAt(arr.get(i).getRuntime(), i, 5);
						dt.setValueAt(arr.get(i).getGenre(), i, 6);
						dt.setValueAt(arr.get(i).getLimit(), i, 7);
						dt.setValueAt(rdba.showAvg(String.valueOf(arr.get(i).getMnum())), i, 8);
					cnt=4;
					}
				}
			});
			cbGenre.setModel(new DefaultComboBoxModel(new String[] {"", "드라마", "SF", "공포", "액션", "느와르", "학교", "미스터리", "판타지"}));
			cbGenre.setBounds(53, 97, 82, 24);
			panel_3.add(cbGenre);
			
			JLabel lblNewLabel_2 = new JLabel("장르");
			lblNewLabel_2.setBounds(14, 100, 62, 18);
			panel_3.add(lblNewLabel_2);
			
			lblM_num = new JLabel("영화 번호");
			lblM_num.setVisible(false);
			lblM_num.setEnabled(false);
			lblM_num.setBounds(24, 132, 62, 18);
			panel_3.add(lblM_num);
			panel_3.add(getBtnAllview());
			panel_3.add(getBtnNewButton_3());
		}
		return panel_3;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("영화 수정");
			btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try {	
					int i = table.getSelectedRow();
					Movie m = new Movie();
					m.setMnum(Integer.parseInt(lblM_num.getText()));
					m.setTitle(String.valueOf(table.getValueAt(i, 1)));
					m.setDirector(String.valueOf(table.getValueAt(i, 2)));
					m.setYear(String.valueOf(table.getValueAt(i, 3)));
					m.setMonth(String.valueOf(table.getValueAt(i, 4)));
					m.setRuntime(String.valueOf(table.getValueAt(i, 5)));
					m.setGenre(String.valueOf(table.getValueAt(i, 6)));
					m.setLimit(String.valueOf(table.getValueAt(i, 7)));
					m.setPoster(String.valueOf(arr.get(i).getPoster()));
					mudba.updateMovie(m);
					btnAllview.doClick();
				}catch(NumberFormatException a) {
					JOptionPane.showMessageDialog(null, "영화를 선택해주세요");
				}
				}
			});
			btnNewButton.setBounds(26, 238, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("영화 삭제");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					if(table.isRowSelected(i)) {
						String M_num = String.valueOf(table.getValueAt(i, 0));
						mudba.movieDelete(M_num);
						btnAllview.doClick();
					}else {
						JOptionPane.showMessageDialog(null, "영화를 선택해주세요");
						return;
					}
					
				}
			});
			btnNewButton_1.setBounds(26, 273, 97, 23);
		}
		return btnNewButton_1;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(new BorderLayout(0, 0));
			panel_4.add(getSplitPane_2(), BorderLayout.CENTER);
		}
		return panel_4;
	}
	private JSplitPane getSplitPane_2() {
		if (splitPane_2 == null) {
			splitPane_2 = new JSplitPane();
			splitPane_2.setDividerSize(1);
			splitPane_2.setLeftComponent(getPanel_5());
			splitPane_2.setRightComponent(getPanel_6());
			splitPane_2.setDividerLocation(300);
		}
		return splitPane_2;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setLayout(new BorderLayout(0, 0));
			panel_5.add(getSplitPane_3(), BorderLayout.CENTER);
		}
		return panel_5;
	}
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setLayout(null);
			
			lblTitle = new JLabel("선택하신 영화는 n 입니다");
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setBounds(14, 12, 434, 18);
			panel_6.add(lblTitle);
			
			JLabel lblNewLabel_15 = new JLabel("평점");
			lblNewLabel_15.setBounds(237, 127, 62, 18);
			panel_6.add(lblNewLabel_15);
			
			JLabel lblNewLabel_17 = new JLabel("후기 수");
			lblNewLabel_17.setBounds(237, 176, 62, 18);
			panel_6.add(lblNewLabel_17);
			
			lblMale_1 = new JLabel("남자");
			lblMale_1.setBounds(237, 230, 106, 18);
			panel_6.add(lblMale_1);

			lblFemale_1 = new JLabel("여자");
			lblFemale_1.setBounds(237, 288, 106, 18);
			panel_6.add(lblFemale_1);
			
			tfScore = new JTextField();
			tfScore.setBounds(332, 127, 116, 24);
			panel_6.add(tfScore);
			tfScore.setColumns(10);
			
			tfReCount = new JTextField();
			tfReCount.setBounds(332, 173, 116, 24);
			panel_6.add(tfReCount);
			tfReCount.setColumns(10);
			
			tfManView = new JTextField();
			tfManView.setBounds(332, 227, 116, 24);
			panel_6.add(tfManView);
			tfManView.setColumns(10);
			
			tfWoView = new JTextField();
			tfWoView.setBounds(332, 285, 116, 24);
			panel_6.add(tfWoView);
			tfWoView.setColumns(10);
			
			JLabel lblNewLabel_20 = new JLabel("개봉시기");
			lblNewLabel_20.setBounds(237, 68, 81, 18);
			panel_6.add(lblNewLabel_20);
			
			tfOpendate = new JTextField();
			tfOpendate.setBounds(332, 65, 116, 24);
			panel_6.add(tfOpendate);
			tfOpendate.setColumns(10);
			panel_6.add(getLblNewLabel_14());
			
			JLabel lblNewLabel_16 = new JLabel("관람객");
			lblNewLabel_16.setBounds(263, 290, 57, 15);
			panel_6.add(lblNewLabel_16);
			
			lblPoster = new JLabel("");
			lblPoster.setBounds(14, 65, 209, 341);
			panel_6.add(lblPoster);
			panel_6.add(getBtnNewButton_2());
		}
		return panel_6;
	}
	private JSplitPane getSplitPane_3() {
		if (splitPane_3 == null) {
			splitPane_3 = new JSplitPane();
			splitPane_3.setDividerSize(3);
			splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_3.setLeftComponent(getPanel_7());
			splitPane_3.setRightComponent(getPanel_8());
			splitPane_3.setDividerLocation(150);
		}
		return splitPane_3;
	}
	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "\uD68C\uC6D0 \uC218", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_7.setLayout(null);
			
			lblMemberCnt = new JLabel("회원수는 "+String.valueOf(mcdba.ViewPeopleCount())+"명 입니다.");
			lblMemberCnt.setBounds(14, 24, 182, 18);
			panel_7.add(lblMemberCnt);
			
			lblMale = new JLabel("남자");
			lblMale.setBounds(14, 67, 62, 18);
			panel_7.add(lblMale);
			
			lblFemale = new JLabel("여자");
			lblFemale.setBounds(14, 97, 62, 18);
			panel_7.add(lblFemale);
			
			tfMalecnt = new JTextField();
			tfMalecnt.setHorizontalAlignment(SwingConstants.CENTER);
			tfMalecnt.setEditable(false);
			tfMalecnt.setBounds(59, 64, 116, 24);
			panel_7.add(tfMalecnt);
			tfMalecnt.setText(String.valueOf(mcdba.GenderCount(lblMale.getText()))+"명");
			tfMalecnt.setColumns(10);
			
			tfFemalecnt = new JTextField();
			tfFemalecnt.setHorizontalAlignment(SwingConstants.CENTER);
			tfFemalecnt.setEditable(false);
			tfFemalecnt.setBounds(59, 94, 116, 24);
			panel_7.add(tfFemalecnt);
			tfFemalecnt.setText(mcdba.GenderCount(lblFemale.getText())+"명");
			tfFemalecnt.setColumns(10);
		}
		return panel_7;
	}
	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
			panel_8.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "\uC870\uAC74\uBCC4 \uC120\uD638\uB3C4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_8.setLayout(null);
			

			
			cbYear_1 = new JComboBox();
			cbYear_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					maxScoreMo();
				}
			});
			cbYear_1.setModel(new DefaultComboBoxModel(new String[] {"", "2014년", "2015년", "2016년", "2017년", "2018년", "2019년"}));
			cbYear_1.setBounds(55, 30, 85, 24);
			panel_8.add(cbYear_1);
			
			cbMonth_1 = new JComboBox();
			cbMonth_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					maxScoreMovie.setText(mcdba.maxScoreMovieMonth(cbYear_1.getSelectedItem(),cbMonth_1));
					minScoreMovie.setText(mcdba.minScoreMovieMonth(cbYear_1.getSelectedItem(), cbMonth_1));
					tfPopularMovie.setText(mcdba.maxPopulaMovieMonth(cbYear_1.getSelectedItem(), cbMonth_1));
					tfMinorMovie.setText(mcdba.minPopulaMovieMonth(cbYear_1.getSelectedItem(), cbMonth_1));
					tfMaleGenre.setText(mcdba.popularGenreMonth(cbYear_1.getSelectedItem(),cbMonth_1,lblMale_1.getText()));
					tfFemaleGenre.setText(mcdba.popularGenreMonth(cbYear_1.getSelectedItem(),cbMonth_1, lblFemale_1.getText()));
				}
			});
			cbMonth_1.setModel(new DefaultComboBoxModel(new String[] {"", "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"}));
			cbMonth_1.setEnabled(false);
			cbMonth_1.setBounds(192, 30, 91, 24);
			panel_8.add(cbMonth_1);
			
			JLabel lblNewLabel_9 = new JLabel("년도");
			lblNewLabel_9.setBounds(14, 33, 62, 18);
			panel_8.add(lblNewLabel_9);
			
			JLabel lblNewLabel_10 = new JLabel("월별");
			lblNewLabel_10.setBounds(154, 33, 62, 18);
			panel_8.add(lblNewLabel_10);
			
			panel_9 = new JPanel();
			panel_9.setBounds(9, 63, 278, 187);
			panel_8.add(panel_9);
			panel_9.setLayout(null);
			
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(0, 0, 273, 187);
			panel_9.add(tabbedPane);
			
			panel_10 = new JPanel();
			tabbedPane.addTab("평점", null, panel_10, null);
			panel_10.setLayout(null);
			
			JLabel lblNewLabel_6 = new JLabel("최고 평점");
			lblNewLabel_6.setBounds(0, 15, 101, 18);
			panel_10.add(lblNewLabel_6);
			
			maxScoreMovie = new JTextField();
			maxScoreMovie.setBounds(106, 12, 163, 24);
			panel_10.add(maxScoreMovie);
			maxScoreMovie.setHorizontalAlignment(SwingConstants.CENTER);
			maxScoreMovie.setEditable(false);
			maxScoreMovie.setColumns(10);
			
			label = new JLabel("최저 평점");
			label.setBounds(0, 46, 62, 18);
			panel_10.add(label);
			
			minScoreMovie = new JTextField();
			minScoreMovie.setEditable(false);
			minScoreMovie.setHorizontalAlignment(SwingConstants.CENTER);
			minScoreMovie.setBounds(106, 43, 163, 24);
			panel_10.add(minScoreMovie);
			minScoreMovie.setColumns(10);
			
			panel_11 = new JPanel();
			tabbedPane.addTab("후기", null, panel_11, null);
			panel_11.setLayout(null);
			
			JLabel lblNewLabel_7 = new JLabel("최다 후기");
			lblNewLabel_7.setBounds(0, 25, 101, 18);
			panel_11.add(lblNewLabel_7);
			
			tfPopularMovie = new JTextField();
			tfPopularMovie.setBounds(106, 22, 163, 24);
			panel_11.add(tfPopularMovie);
			tfPopularMovie.setHorizontalAlignment(SwingConstants.CENTER);
			tfPopularMovie.setEditable(false);
			tfPopularMovie.setText("");
			tfPopularMovie.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("최저 후기");
			lblNewLabel_3.setBounds(0, 55, 62, 18);
			panel_11.add(lblNewLabel_3);
			
			tfMinorMovie = new JTextField();
			tfMinorMovie.setEditable(false);
			tfMinorMovie.setHorizontalAlignment(SwingConstants.CENTER);
			tfMinorMovie.setBounds(106, 55, 163, 24);
			panel_11.add(tfMinorMovie);
			tfMinorMovie.setColumns(10);
			
			panel_12 = new JPanel();
			tabbedPane.addTab("장르", null, panel_12, null);
			panel_12.setLayout(null);
			
			JLabel lblMale_2 = new JLabel("남자");
			lblMale_2.setBounds(83, 60, 62, 18);
			panel_12.add(lblMale_2);
			
			JLabel lblFemale_2 = new JLabel("여자");
			lblFemale_2.setBounds(83, 85, 62, 18);
			panel_12.add(lblFemale_2);
			
			tfMaleGenre = new JTextField();
			tfMaleGenre.setBounds(113, 57, 163, 24);
			panel_12.add(tfMaleGenre);
			tfMaleGenre.setHorizontalAlignment(SwingConstants.CENTER);
			tfMaleGenre.setEditable(false);
			tfMaleGenre.setColumns(10);
			
			tfFemaleGenre = new JTextField();
			tfFemaleGenre.setBounds(113, 82, 163, 24);
			panel_12.add(tfFemaleGenre);
			tfFemaleGenre.setHorizontalAlignment(SwingConstants.CENTER);
			tfFemaleGenre.setEditable(false);
			tfFemaleGenre.setColumns(10);
			
			JLabel lblNewLabel_8 = new JLabel("선호장르");
			lblNewLabel_8.setBounds(7, 60, 62, 18);
			panel_12.add(lblNewLabel_8);
			
			JLabel lblNewLabel_4 = new JLabel("평점 3점이상 중 후기 갯수로 비교");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setBounds(7, 25, 269, 31);
			panel_12.add(lblNewLabel_4);
			
		}
		return panel_8;
		
	}
	public void movieSearch() {
		if(cnt==1) {
			arr = mdba.movieYearSearch(cbYear.getSelectedItem());
		}else if(cnt ==2) {
			arr = mdba.movieMonthSearch(cbYear.getSelectedItem(),cbMonth.getSelectedItem());
		}else if(cnt==4){
			arr= mdba.movieGenreSearch(cbGenre.getSelectedItem());
		}else {
			arr= mdba.AllView();
		}
		int i = table.getSelectedRow();
		lblTitle.setText("선택하신 영화는 "+arr.get(i).getTitle()+" 입니다.");//영화제목
		lblM_num.setText(String.valueOf(arr.get(i).getMnum()));// 영화 번호
		tfOpendate.setText(arr.get(i).getYear()+arr.get(i).getMonth());//영화 오픈 날짜
		ImageIcon icon = new ImageIcon("img\\"+arr.get(i).getPoster());//포스터 출력
		lblPoster.setIcon(icon);
		tfWoView.setText(String.valueOf(mcdba.ViewGenderCount(lblFemale_1.getText(),arr.get(i).getMnum()))+"명");//남자 시청자
		tfManView.setText(String.valueOf(mcdba.ViewGenderCount(lblMale_1.getText(),arr.get(i).getMnum()))+"명");//여자 시청자
		
	}
	private void review() {
		tfScore.setText(rdba.showAvg(lblM_num.getText())+"/5.0");
		tfReCount.setText(rdba.showCnt(lblM_num.getText())+"개");
	}
	private JLabel getLblNewLabel_14() {
		if (lblNewLabel_14 == null) {
			lblNewLabel_14 = new JLabel("관람객");
			lblNewLabel_14.setBounds(263, 232, 57, 15);
		}
		return lblNewLabel_14;
	}
	public void maxScoreMo() {
		maxScoreMovie.setText(mcdba.maxScoreMovie(cbYear_1.getSelectedItem()));
		minScoreMovie.setText(mcdba.minScoreMovie(cbYear_1.getSelectedItem()));
		tfPopularMovie.setText(mcdba.maxPopulaMovie(cbYear_1.getSelectedItem()));
		tfMinorMovie.setText(mcdba.minPopulaMovie(cbYear_1.getSelectedItem()));
		cbMonth_1.setEnabled(true);
		tfMaleGenre.setText(mcdba.popularGenre(cbYear_1.getSelectedItem(),lblMale_1.getText()));
		tfFemaleGenre.setText(mcdba.popularGenre(cbYear_1.getSelectedItem(), lblFemale_1.getText()));
		
	}
	public void Allview() {
		arr.clear();
		arr=mdba.AllView();
		cnt =0;
		String[] cols = {"MOVIE NO","TITLE","DIRECTOR","YEAR","MONTH","RUNTIME","GENRE","LIMIT","SCORE"};
		DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
		table.setModel(dt);
		for(int i = 0; i < arr.size() ; i++) {
			dt.setValueAt(arr.get(i).getMnum(), i, 0);
			dt.setValueAt(arr.get(i).getTitle(), i, 1);
			dt.setValueAt(arr.get(i).getDirector(), i, 2);
			dt.setValueAt(arr.get(i).getYear(), i, 3);
			dt.setValueAt(arr.get(i).getMonth(), i, 4);
			dt.setValueAt(arr.get(i).getRuntime(), i, 5);
			dt.setValueAt(arr.get(i).getGenre(), i, 6);
			dt.setValueAt(arr.get(i).getLimit(), i, 7);
			dt.setValueAt(rdba.showAvg(String.valueOf(arr.get(i).getMnum())), i, 8);
		}
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("영화 추가");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new ManagerSwingUpload().setVisible(true);
					
				}
			});
			btnNewButton_3.setBounds(26, 203, 97, 23);
		}
		return btnNewButton_3;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("댓글 모아 보기");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
					int i = table.getSelectedRow();
					String m_num = String.valueOf(table.getValueAt(i, 0));
					new ManagerMovieRe(m_num).setVisible(true);
					}catch(ArrayIndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(null, "영화를 선택해주세요");
					}
				}
			});
			btnNewButton_2.setBounds(237, 336, 163, 23);
		}
		return btnNewButton_2;
	}
}
