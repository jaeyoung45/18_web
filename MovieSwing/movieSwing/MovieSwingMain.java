package movieSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import memberDBA.Member;
import movieDBA.Movie;
import movieDBA.MovieDBA;
import movieDBA.ReviewDBA;

import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.beans.Visibility;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MovieSwingMain extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JSplitPane splitPane_1;
	private JSplitPane splitPane_2;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField tfLoginId;
	private JLabel lblNewLabel_1;
	private JTextField tfScore;
	private JTextField tfReview;
	private JTextField tfSearch;
	Movie m = new Movie();
	MovieDBA mdba = new MovieDBA();
	ReviewDBA rdba = new ReviewDBA();
	ArrayList<Movie> arr = mdba.AllView();
	
	private ImageIcon[] images = null;
	private JTextField tfTitle;
	private JTextField tfDirector;
	private JTextField tfOutdate;
	private JTextField tfRuntime;
	private JTextField tfLimit;
	private JTextField tfGenre;
	private JTextField tfActor;
	private JComboBox cbMonth;
	private JComboBox cbYear;
	private JComboBox cbGenre;
	private JLabel lblNewLabel10;
	private JLabel lblTitle;
	private JLabel lblM_num;
	private JTextArea taReview;
	private JLabel lblScore;
	private JLabel lblCount;
	private JTable table_1;
	private JLabel lblPoster;
	private JPanel ScorePanel;	
	private String id;
	private JLabel lblScoreCheck;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieSwingMain frame = new MovieSwingMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public MovieSwingMain(String id) {
		setResizable(false);
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);

	}

//	public MovieSwingMain() {
//		
//	}
	
	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setDividerSize(1);
			splitPane.setLeftComponent(getSplitPane_1());
			splitPane.setRightComponent(getSplitPane_2());
			splitPane.setDividerLocation(300);
		}
		return splitPane;
	}
	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setDividerSize(1);
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setLeftComponent(getPanel());
			
			JScrollPane scrollPane = new JScrollPane();
			splitPane_1.setRightComponent(scrollPane);
			
			table_1 = new JTable();
			table_1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					movieSelect();
					review();
					boolean flag = mdba.scoreView(lblM_num.getText(),id);
					ScorePanel.setVisible(flag);
					if(flag == true) {
						lblScoreCheck.setVisible(false);	
					}else {
						lblScoreCheck.setVisible(true);
					}

				}
			});
			String[] cols = {"TITLE","DIRECTOR","OUTDATE","GENRE"};
			DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
			table_1.setModel(dt);
			for(int i =0 ; i<arr.size() ; i++) {
				dt.setValueAt(arr.get(i).getTitle(), i, 0);
				dt.setValueAt(arr.get(i).getDirector(), i,1);
				dt.setValueAt(arr.get(i).getYear()+arr.get(i).getMonth(), i, 2);
				dt.setValueAt(arr.get(i).getGenre(), i, 3);
			}
			table_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					movieSelect();
					review();
					boolean flag = mdba.scoreView(lblM_num.getText(),id);
					ScorePanel.setVisible(flag);
					if(flag == true) {
						lblScoreCheck.setVisible(false);	
					}else {
						lblScoreCheck.setVisible(true);
					}
				}
			});
			scrollPane.setViewportView(table_1);
			splitPane_1.setDividerLocation(130);
		}
		return splitPane_1;
	}
	
	private JSplitPane getSplitPane_2() {
		if (splitPane_2 == null) {
			splitPane_2 = new JSplitPane();
			splitPane_2.setDividerSize(1);
			splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);

			
			JSplitPane splitPane_3 = new JSplitPane();
			splitPane_3.setDividerSize(1);
			splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_2.setRightComponent(splitPane_3);
			
			JPanel panel_1 = new JPanel();
			splitPane_3.setRightComponent(panel_1);
			panel_1.setLayout(null);
			
			ScorePanel = new JPanel();
			ScorePanel.setBounds(14, 9, 219, 24);
			panel_1.add(ScorePanel);
			ScorePanel.setLayout(null);
			
			JLabel lblNewLabel_6 = new JLabel("평점");
			lblNewLabel_6.setBounds(0, 3, 62, 18);
			ScorePanel.add(lblNewLabel_6);
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
			
			tfScore = new JTextField();
			tfScore.setBounds(76, 0, 77, 24);
			ScorePanel.add(tfScore);
			tfScore.setColumns(10);
			
			JLabel label = new JLabel("/5");
			label.setBounds(157, 3, 62, 18);
			ScorePanel.add(label);
			
			JLabel lblNewLabel_7 = new JLabel("후기");
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_7.setBounds(14, 42, 62, 18);
			panel_1.add(lblNewLabel_7);
			
			tfReview = new JTextField();
			tfReview.setBounds(90, 39, 260, 24);
			panel_1.add(tfReview);
			tfReview.setColumns(10);
			
			JButton btnNewButton = new JButton("올리기");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ScorePanel.isVisible()) {
					try {
					if(Double.parseDouble(tfScore.getText())<0||Double.parseDouble(tfScore.getText())>5) {
						JOptionPane.showMessageDialog(null, "0 과 5 사이의 점수만 입력 가능합니다.");
						tfScore.setText("");
						return;
					}
					if(tfReview.getText().length()>100) {
						JOptionPane.showMessageDialog(null, "최대 100자까지 입력가능합니다.");
						tfReview.setText("");
						return;
					}
					}catch(NumberFormatException a) {
					JOptionPane.showMessageDialog(null, "평점은 꼭 남겨주세요 ^^");
					return;
					}
					
					Movie mo = new Movie();
					mo.setMnum(Integer.parseInt(lblM_num.getText()));
					mo.setScore(Double.parseDouble(tfScore.getText()));
					mo.setReply(tfReview.getText());
					Member me = new Member();
					me.setId(tfLoginId.getText());
					rdba.upLoadReview(me,mo);
					JOptionPane.showMessageDialog(null, "후기가 작성되었습니다.");
					review();
					tfReview.setText("");
					tfScore.setText("");
					ScorePanel.setVisible(false);
					lblScoreCheck.setVisible(true);
					}else {
						if(tfReview.getText().length()>100) {
							JOptionPane.showMessageDialog(null, "최대 100자까지 입력가능합니다.");
							tfReview.setText("");
							return;
						}
						Movie mo = new Movie();
						mo.setMnum(Integer.parseInt(lblM_num.getText()));
						mo.setReply(tfReview.getText());
						Member me = new Member();
						me.setId(tfLoginId.getText());
						rdba.upLoadReply(me,mo);
						JOptionPane.showMessageDialog(null, "후기가 작성되었습니다.");
						review();
						tfReview.setText("");
						
					}
				}
			});
			btnNewButton.setBounds(364, 38, 90, 27);
			panel_1.add(btnNewButton);
			
			JLabel lblNewLabel_14 = new JLabel("후기는 최대 100자까지 작성 가능합니다.^^");
			lblNewLabel_14.setBounds(90, 66, 364, 18);
			panel_1.add(lblNewLabel_14);
			panel_1.add(getLblScoreCheck());
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			splitPane_3.setLeftComponent(tabbedPane);
			
			JPanel panel_4 = new JPanel();
			tabbedPane.addTab("영화 정보", null, panel_4, null);
			panel_4.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("제목");
			lblNewLabel_2.setBounds(14, 12, 62, 18);
			panel_4.add(lblNewLabel_2);
			
			tfTitle = new JTextField();
			tfTitle.setEditable(false);
			tfTitle.setBounds(90, 9, 116, 24);
			panel_4.add(tfTitle);
			tfTitle.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("감독");
			lblNewLabel_3.setBounds(14, 48, 62, 18);
			panel_4.add(lblNewLabel_3);
			
			tfDirector = new JTextField();
			tfDirector.setEditable(false);
			tfDirector.setBounds(90, 45, 116, 24);
			panel_4.add(tfDirector);
			tfDirector.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("개봉날짜");
			lblNewLabel_4.setBounds(14, 84, 62, 18);
			panel_4.add(lblNewLabel_4);
			
			tfOutdate = new JTextField();
			tfOutdate.setEditable(false);
			tfOutdate.setBounds(90, 81, 116, 24);
			panel_4.add(tfOutdate);
			tfOutdate.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("상영시간");
			lblNewLabel_5.setBounds(14, 120, 62, 18);
			panel_4.add(lblNewLabel_5);
			
			tfRuntime = new JTextField();
			tfRuntime.setEditable(false);
			tfRuntime.setBounds(90, 117, 116, 24);
			panel_4.add(tfRuntime);
			tfRuntime.setColumns(10);
			
			tfLimit = new JTextField();
			tfLimit.setEditable(false);
			tfLimit.setBounds(90, 153, 116, 24);
			panel_4.add(tfLimit);
			tfLimit.setColumns(10);
			
			tfGenre = new JTextField();
			tfGenre.setEditable(false);
			tfGenre.setBounds(90, 189, 116, 24);
			panel_4.add(tfGenre);
			tfGenre.setColumns(10);
			
			JLabel lblNewLabel_8 = new JLabel("나이등급");
			lblNewLabel_8.setBounds(14, 156, 62, 18);
			panel_4.add(lblNewLabel_8);
			
			JLabel lblNewLabel_9 = new JLabel("장르");
			lblNewLabel_9.setBounds(14, 192, 62, 18);
			panel_4.add(lblNewLabel_9);
			
			JLabel lblNewLabel_10 = new JLabel("출연진");
			lblNewLabel_10.setBounds(14, 231, 62, 18);
			panel_4.add(lblNewLabel_10);
			
			tfActor = new JTextField();
			tfActor.setEditable(false);
			tfActor.setBounds(90, 228, 150, 24);
			panel_4.add(tfActor);
			tfActor.setColumns(10);
			
			lblPoster = new JLabel("");
			lblPoster.setHorizontalAlignment(SwingConstants.CENTER);
			lblPoster.setBounds(252, 22, 203, 292);
			panel_4.add(lblPoster);
			
			JSplitPane splitPane_4 = new JSplitPane();
			splitPane_4.setDividerSize(1);
			tabbedPane.addTab("후기", null, splitPane_4, null);
			splitPane_4.setOrientation(JSplitPane.VERTICAL_SPLIT);
			
			JScrollPane scrollPane = new JScrollPane();
			splitPane_4.setRightComponent(scrollPane);
			
			taReview = new JTextArea();
			scrollPane.setViewportView(taReview);
			

			
			
			JPanel panel_3 = new JPanel();
			splitPane_4.setLeftComponent(panel_3);
			panel_3.setLayout(null);
			
			lblNewLabel10 = new JLabel("선택하신 영화는");
			lblNewLabel10.setBounds(14, 12, 97, 18);
			panel_3.add(lblNewLabel10);
			
			lblCount = new JLabel("총 n개의 후기가 있습니다.");
			lblCount.setBounds(14, 61, 251, 18);
			panel_3.add(lblCount);
			
			JLabel lblNewLabel_12 = new JLabel("평점 평균");
			lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_12.setBounds(335, 12, 81, 18);
			panel_3.add(lblNewLabel_12);
			
			lblScore = new JLabel("n/5.0");
			lblScore.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 30));
			lblScore.setHorizontalAlignment(SwingConstants.CENTER);
			lblScore.setBounds(301, 42, 141, 45);
			panel_3.add(lblScore);
			
			lblTitle = new JLabel("New label");
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setBounds(123, 12, 97, 18);
			panel_3.add(lblTitle);
			
			JLabel lblNewLabel_13 = new JLabel("입니다.");
			lblNewLabel_13.setBounds(255, 12, 55, 18);
			panel_3.add(lblNewLabel_13);
			
			lblM_num = new JLabel("New label");
			lblM_num.setVisible(false);
			lblM_num.setBounds(123, 31, 62, 18);
			panel_3.add(lblM_num);
			splitPane_4.setDividerLocation(100);
			splitPane_3.setDividerLocation(380);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\uC601\uD654\uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			splitPane_2.setLeftComponent(panel_2);
			panel_2.setLayout(null);
			
			JLabel label_1 = new JLabel("년월 검색");
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setBounds(34, 25, 84, 18);
			panel_2.add(label_1);
			

			
			cbYear = new JComboBox();
			cbYear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					arr = mdba.movieYearSearch(cbYear.getSelectedItem());
					String[] cols = {"TITLE","DIRECTOR","OUTDATE","GENRE"};
					DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
					table_1.setModel(dt);
					for(int i =0 ; i<arr.size() ; i++) {
						dt.setValueAt(arr.get(i).getTitle(), i, 0);
						dt.setValueAt(arr.get(i).getDirector(), i,1);
						dt.setValueAt(arr.get(i).getYear()+arr.get(i).getMonth(), i, 2);
						dt.setValueAt(arr.get(i).getGenre(), i, 3);
						cbMonth.setEnabled(true);
					}
				}
			});
			cbYear.setModel(new DefaultComboBoxModel(new String[] {"선택하세요", "2014년", "2015년", "2016년", "2017년", "2018년", "2019년"}));
			cbYear.setBounds(128, 18, 106, 24);
			panel_2.add(cbYear);
			
			cbMonth = new JComboBox();
			cbMonth.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] cols = {"TITLE","DIRECTOR","OUTDATE","GENRE"};
					arr = mdba.movieMonthSearch(cbYear.getSelectedItem(),cbMonth.getSelectedItem());
					
					DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
					table_1.setModel(dt);
					
					for(int i =0 ; i<arr.size() ; i++) {
						dt.setValueAt(arr.get(i).getTitle(), i, 0);
						dt.setValueAt(arr.get(i).getDirector(), i,1);
						dt.setValueAt(arr.get(i).getYear()+arr.get(i).getMonth(), i, 2);
						dt.setValueAt(arr.get(i).getGenre(), i, 3);
					}
				}
			});

			cbMonth.setEnabled(false);
			cbMonth.setModel(new DefaultComboBoxModel(new String[] {"선택", "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"}));
			cbMonth.setBounds(254, 18, 67, 24);
			panel_2.add(cbMonth);
			
			JLabel label_2 = new JLabel("장르별 검색");
			label_2.setHorizontalAlignment(SwingConstants.RIGHT);
			label_2.setBounds(34, 55, 84, 18);
			panel_2.add(label_2);
			
			cbGenre = new JComboBox();
			cbGenre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					arr= mdba.movieGenreSearch(cbGenre.getSelectedItem());
					String[] cols = {"TITLE","DIRECTOR","OUTDATE","GENRE"};
					DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
					table_1.setModel(dt);
					for(int i =0 ; i<arr.size() ; i++) {
						dt.setValueAt(arr.get(i).getTitle(), i, 0);
						dt.setValueAt(arr.get(i).getDirector(), i,1);
						dt.setValueAt(arr.get(i).getYear()+arr.get(i).getMonth(), i, 2);
						dt.setValueAt(arr.get(i).getGenre(), i, 3);
					}
				}
			});
			cbGenre.setModel(new DefaultComboBoxModel(new String[] {"", "드라마", "SF", "공포", "액션", "느와르", "학교", "미스터리", "판타지"}));
			cbGenre.setBounds(128, 52, 106, 24);
			panel_2.add(cbGenre);
			
			JLabel label_3 = new JLabel("제목 검색");
			label_3.setBounds(56, 92, 62, 18);
			panel_2.add(label_3);
			
			tfSearch = new JTextField();
			tfSearch.setColumns(10);
			tfSearch.setBounds(128, 89, 116, 24);
			panel_2.add(tfSearch);
			
			JButton button = new JButton("검색");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					arr = mdba.movieTitleSearch(tfSearch.getText());
					String[] cols = {"TITLE","DIRECTOR","OUTDATE","GENRE"};
					DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
					table_1.setModel(dt);
					for(int i =0 ; i<arr.size() ; i++) {
						dt.setValueAt(arr.get(i).getTitle(), i, 0);
						dt.setValueAt(arr.get(i).getDirector(), i,1);
						dt.setValueAt(arr.get(i).getYear()+arr.get(i).getMonth(), i, 2);
						dt.setValueAt(arr.get(i).getGenre(), i, 3);
					}
				}
			});
			button.setBounds(247, 88, 74, 27);
			panel_2.add(button);
			
			JButton btnUpload = new JButton("영화 업로드");
			btnUpload.setBounds(340, 88, 116, 27);
			panel_2.add(btnUpload);
			btnUpload.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new MovieSwingUpload(id).setVisible(true);
					setVisible(false);
				}
			});
			splitPane_2.setDividerLocation(130);
		}
		return splitPane_2;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getTfLoginId());
			panel.add(getLblNewLabel_1());
			
			JButton btnNewButton_2 = new JButton("로그아웃");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new MovieSwingLogin().setVisible(true);
					setVisible(false);
				}
			});
			btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 12));
			btnNewButton_2.setBounds(166, 55, 105, 27);
			panel.add(btnNewButton_2);
			
			JButton btnNewButton_3 = new JButton("회원정보수정");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new MovieSwingMemberUpdate(id).setVisible(true);
					setVisible(false);
				}
			});
			btnNewButton_3.setFont(new Font("굴림", Font.PLAIN, 12));
			btnNewButton_3.setBounds(27, 55, 125, 27);
			panel.add(btnNewButton_3);
			
			JButton btnNewButton_1 = new JButton("영화 전체 보기");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					arr = mdba.AllView();
					String[] cols = {"TITLE","DIRECTOR","OUTDATE","GENRE"};
					DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
					table_1.setModel(dt);
					for(int i =0 ; i<arr.size() ; i++) {
						dt.setValueAt(arr.get(i).getTitle(), i, 0);
						dt.setValueAt(arr.get(i).getDirector(), i,1);
						dt.setValueAt(arr.get(i).getYear()+arr.get(i).getMonth(), i, 2);
						dt.setValueAt(arr.get(i).getGenre(), i, 3);
					}
				}
			});
			btnNewButton_1.setBounds(85, 92, 131, 27);
			panel.add(btnNewButton_1);
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("환영합니다.");
			lblNewLabel.setBounds(29, 24, 84, 18);
		}
		return lblNewLabel;
	}
	private JTextField getTfLoginId() {
		if (tfLoginId == null) {
			tfLoginId = new JTextField(id);
			tfLoginId.setEditable(false);
			tfLoginId.setBounds(127, 21, 104, 24);
			tfLoginId.setColumns(10);
		}
		return tfLoginId;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("님");
			lblNewLabel_1.setBounds(245, 24, 26, 18);
		}
		return lblNewLabel_1;
	}
	private void review() {
		taReview.setText("");
		ArrayList<Movie> rearr = rdba.showReview(lblM_num.getText());
		for(int k = 0; k< rearr.size() ; k++) {
			taReview.append("아이디 : "+rearr.get(k).getId()+"\n");
			taReview.append("평점 : "+rearr.get(k).getScore()+"\n");
			taReview.append("후기 : " + rearr.get(k).getReply()+"\n");
			taReview.append("작성일 : "+ rearr.get(k).getDate()+"\n\n");
		}
		lblScore.setText(rdba.showAvg(lblM_num.getText())+"/5.0");
		lblCount.setText(rdba.showCnt(lblM_num.getText())+"개의 후기가 있습니다.");
	}
	private void movieSelect() {
		int i = table_1.getSelectedRow();
		String title = String.valueOf(table_1.getValueAt(i, 0));
		Movie m = mdba.select(title);
		
		tfTitle.setText(m.getTitle());
		System.out.println();
		tfDirector.setText(m.getDirector());
		tfActor.setText(m.getActor());
		tfOutdate.setText(m.getYear()+m.getMonth());
		tfRuntime.setText(m.getRuntime());
		tfLimit.setText(m.getLimit());
		tfGenre.setText(m.getGenre());
		lblTitle.setText(m.getTitle());
		lblM_num.setText(String.valueOf(m.getMnum()));
		ImageIcon icon = new ImageIcon("img\\"+arr.get(i).getPoster());
		lblPoster.setIcon(icon);
	}
	private JLabel getLblScoreCheck() {
		if (lblScoreCheck == null) {
			lblScoreCheck = new JLabel("이미 평점을 남긴 영화입니다.");
			lblScoreCheck.setBounds(36, 18, 405, 15);
			lblScoreCheck.setVisible(false);
			lblScoreCheck.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblScoreCheck;
	}
}

