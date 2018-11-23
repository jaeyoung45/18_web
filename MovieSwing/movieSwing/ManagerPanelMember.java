package movieSwing;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import memberDBA.Member;
import memberDBA.UpdateDBA;
import movieDBA.ManagerMemberDBA;
import movieDBA.Movie;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManagerPanelMember extends JPanel {
	private JSplitPane splitPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;
	private JSplitPane splitPane_1;
	private JPanel panel_1;
	private JSplitPane splitPane_2;
	private JPanel panel_2;
	private JSplitPane splitPane_3;
	private JPanel panel_3;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JScrollPane scrollPane_2;
	private JTable table_2;
	private JPanel panel_4;
	ManagerMemberDBA mmdba = new ManagerMemberDBA();
	ArrayList<Member> arr = mmdba.viewAll();
	private JTextField tfSearch;
	private JButton btnNewButton_5;
	private JComboBox cbInfo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfActionCount;
	private JLabel lblNewLabel_2;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JComboBox cbAction;
	private JTextField tfActionSearch;
	private JButton btnNewButton_3;
	private JLabel label_2;
	private int cnt = 0;
	private JComboBox cbGrade;
	private JButton btnNewButton_4;
	private JButton btnNewButton_6;
	private JLabel lblNewLabel_7;
	UpdateDBA udba = new UpdateDBA();
	private JButton btnNewButton_1;


	/**
	 * Create the panel.
	 */
	public ManagerPanelMember() {
		setLayout(new BorderLayout(0, 0));
		add(getSplitPane_1(), BorderLayout.CENTER);

	}
	private JSplitPane getSplitPane_1() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane.setDividerSize(1);
			splitPane.setLeftComponent(getScrollPane());
			splitPane.setRightComponent(getPanel());
			splitPane.setDividerLocation(150);
		}
		return splitPane;
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
					userSelect();
				}
			});
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					userSelect();
				}
			});
			arr = mmdba.viewAll();
			String[] cols = {"MEMBER NO","ID","GRADE","NAME","GENDER","BIRTH","ADDR","EMAIL"};
			DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
			table.setModel(dt);
			for(int i = 0; i < arr.size() ; i++) {
				dt.setValueAt(arr.get(i).getNum(), i, 0);
				dt.setValueAt(arr.get(i).getId(), i, 1);
				dt.setValueAt(arr.get(i).getGrade(), i, 2);
				dt.setValueAt(arr.get(i).getName(), i, 3);
				dt.setValueAt(arr.get(i).getGender(), i, 4);
				dt.setValueAt(arr.get(i).getBirth(), i, 5);
				dt.setValueAt(arr.get(i).getAddr(), i, 6);
				dt.setValueAt(arr.get(i).getEmail(), i, 7);
			}
		}
		return table;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getSplitPane_1_1(), BorderLayout.CENTER);
		}
		return panel;
	}
	private JSplitPane getSplitPane_1_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setDividerSize(10);
			splitPane_1.setRightComponent(getPanel_1());
			splitPane_1.setLeftComponent(getPanel_3());
			splitPane_1.setDividerLocation(150);
		}
		return splitPane_1;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getSplitPane_2(), BorderLayout.CENTER);
		}
		return panel_1;
	}
	private JSplitPane getSplitPane_2() {
		if (splitPane_2 == null) {
			splitPane_2 = new JSplitPane();
			splitPane_2.setDividerSize(1);
			splitPane_2.setRightComponent(getPanel_2());
			splitPane_2.setLeftComponent(getScrollPane_1());
			splitPane_2.setDividerLocation(200);
		}
		return splitPane_2;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new BorderLayout(0, 0));
			panel_2.add(getSplitPane_3(), BorderLayout.CENTER);
		}
		return panel_2;
	}
	private JSplitPane getSplitPane_3() {
		if (splitPane_3 == null) {
			splitPane_3 = new JSplitPane();
			splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_3.setDividerSize(3);
			splitPane_3.setLeftComponent(getScrollPane_2());
			splitPane_3.setRightComponent(getPanel_4());
			splitPane_3.setDividerLocation(150);
		}
		return splitPane_3;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\uD68C\uC6D0\uAD00\uB9AC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setLayout(null);
			panel_3.add(getBtnNewButton());
			panel_3.add(getLblNewLabel_1());
			panel_3.add(getTfActionCount());
			panel_3.add(getLblNewLabel_2());
			panel_3.add(getLabel());
			panel_3.add(getLabel_1());
			panel_3.add(getLblNewLabel_3());
			panel_3.add(getLblNewLabel_5());
			panel_3.add(getLblNewLabel_6());
			panel_3.add(getCbGrade());
			panel_3.add(getBtnNewButton_4());
		}
		return panel_3;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("전체 보기");
			btnNewButton.setBounds(12, 314, 116, 23);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					viewMemberAll();
				}
			});
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("정보 수정");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int i = table.getSelectedRow();
					Member m = new Member();
					m.setNum(Integer.parseInt(String.valueOf(table.getValueAt(i, 0))));
					m.setId(String.valueOf(table.getValueAt(i, 1)));
					m.setGrade(String.valueOf(table.getValueAt(i, 2)));
					m.setName(String.valueOf(table.getValueAt(i, 3)));
					m.setGender(String.valueOf(table.getValueAt(i, 4)));
					m.setBirth(String.valueOf(table.getValueAt(i, 5)));
					m.setAddr(String.valueOf(table.getValueAt(i, 6)));
					m.setEmail(String.valueOf(table.getValueAt(i, 7)));
					mmdba.userUpdate(m);
				}
			});
			btnNewButton_2.setBounds(128, 62, 97, 23);
		}
		return btnNewButton_2;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\uD68C\uC6D0\uC774 \uBCF8 \uC601\uD654", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			scrollPane_1.setViewportView(getTable_1());
		}
		return scrollPane_1;
	}
	private JTable getTable_1() {
		if (table_1 == null) {
			table_1 = new JTable();
			table_1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					try {
					String[] cols = {"REPLY","SCORE","DATE"};
					DefaultTableModel dt = new DefaultTableModel(cols,0);
					table_2.setModel(dt);
					int i = table.getSelectedRow();
					String num = String.valueOf(table.getValueAt(i, 0));
					int j = table_1.getSelectedRow();
					String title = String.valueOf(table_1.getValueAt(j, 0));
					ArrayList<Movie> arr = mmdba.userAction(num,title);
					if(arr.size()==0) {
						dt = new DefaultTableModel(cols,0);
						table_2.setModel(dt);
						return;
					}
					 dt = new DefaultTableModel(cols,arr.size());
					table_2.setModel(dt);
					for(int k = 0 ; k<arr.size() ; k++) {
						dt.setValueAt(arr.get(k).getReply(), k, 0);
						dt.setValueAt(String.valueOf(arr.get(k).getScore()), k, 1);
						dt.setValueAt(arr.get(k).getDate(), k, 2);
					}
					}catch(ArrayIndexOutOfBoundsException e1) {
						JOptionPane.showMessageDialog(null, "회원 테이블에서 회원을 선택해주세요");
					}
				}
			});
			table_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					try {
					String[] cols = {"REPLY","SCORE","DATE"};
					DefaultTableModel dt = new DefaultTableModel(cols,0);
					table_2.setModel(dt);
					int i = table.getSelectedRow();
					String num = String.valueOf(table.getValueAt(i, 0));
					int j = table_1.getSelectedRow();
					String title = String.valueOf(table_1.getValueAt(j, 0));
					ArrayList<Movie> arr = mmdba.userAction(num,title);
					if(arr.size()==0) {
						dt = new DefaultTableModel(cols,0);
						table_2.setModel(dt);
						return;
					}
					 dt = new DefaultTableModel(cols,arr.size());
					table_2.setModel(dt);
					for(int k = 0 ; k<arr.size() ; k++) {
						dt.setValueAt(arr.get(k).getReply(), k, 0);
						dt.setValueAt(String.valueOf(arr.get(k).getScore()), k, 1);
						dt.setValueAt(arr.get(k).getDate(), k, 2);
					}
					}catch(ArrayIndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(null, "회원 테이블에서 회원을 선택해주세요");
					}
				}
			});
			String[] cols = {"TITLE"};
			DefaultTableModel dt = new DefaultTableModel(cols,0);
			table_1.setModel(dt);
		}
		return table_1;
	}
	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\uD68C\uC6D0\uD65C\uB3D9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPane_2.setViewportView(getTable_2());
		}
		return scrollPane_2;
	}
	private JTable getTable_2() {
		if (table_2 == null) {
			table_2 = new JTable();
			String[] cols = {"REPLY","SCORE","DATE"};
			DefaultTableModel dt = new DefaultTableModel(cols,0);
			table_2.setModel(dt);
		}
		return table_2;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\uD68C\uC6D0\uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_4.setLayout(null);
			panel_4.add(getTfSearch());
			panel_4.add(getBtnNewButton_5());
			panel_4.add(getCbInfo());
			panel_4.add(getLblNewLabel());
			panel_4.add(getBtnNewButton_2());
			panel_4.add(getLblNewLabel_4());
			panel_4.add(getCbAction());
			panel_4.add(getTfActionSearch());
			panel_4.add(getBtnNewButton_3());
			panel_4.add(getLabel_2());
			panel_4.add(getBtnNewButton_6());
			panel_4.add(getLblNewLabel_7());
			panel_4.add(getBtnNewButton_1());
		}
		return panel_4;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(303, 31, 116, 21);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JButton getBtnNewButton_5() {
		if (btnNewButton_5 == null) {
			btnNewButton_5 = new JButton("검색");
			btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<Member> arr = mmdba.userInfo(cbInfo.getSelectedItem(),tfSearch.getText());
					String[] cols = {"MEMBER NO","ID","GRADE","NAME","GENDER","BIRTH","ADDR","EMAIL"};
					DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
					table.setModel(dt);
					for(int i = 0; i < arr.size() ; i++) {
						dt.setValueAt(arr.get(i).getNum(), i, 0);
						dt.setValueAt(arr.get(i).getId(), i, 1);
						dt.setValueAt(arr.get(i).getGrade(), i, 2);
						dt.setValueAt(arr.get(i).getName(), i, 3);
						dt.setValueAt(arr.get(i).getGender(), i, 4);
						dt.setValueAt(arr.get(i).getBirth(), i, 5);
						dt.setValueAt(arr.get(i).getAddr(), i, 6);
						dt.setValueAt(arr.get(i).getEmail(), i, 7);
					}
				}
			});
			btnNewButton_5.setBounds(433, 30, 97, 23);
		}
		return btnNewButton_5;
	}
	private void viewMemberAll() {
		arr = mmdba.viewAll();
		String[] cols = {"MEMBER NO","ID","GRADE","NAME","GENDER","BIRTH","ADDR","EMAIL"};
		DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
		table.setModel(dt);
		for(int i = 0; i < arr.size() ; i++) {
			dt.setValueAt(arr.get(i).getNum(), i, 0);
			dt.setValueAt(arr.get(i).getId(), i, 1);
			dt.setValueAt(arr.get(i).getGrade(), i, 2);
			dt.setValueAt(arr.get(i).getName(), i, 3);
			dt.setValueAt(arr.get(i).getGender(), i, 4);
			dt.setValueAt(arr.get(i).getBirth(), i, 5);
			dt.setValueAt(arr.get(i).getAddr(), i, 6);
			dt.setValueAt(arr.get(i).getEmail(), i, 7);
		}
		
	}
	private JComboBox getCbInfo() {
		if (cbInfo == null) {
			cbInfo = new JComboBox();
			cbInfo.setModel(new DefaultComboBoxModel(new String[] {"ID", "GRADE", "NAME", "GENDER", "BIRTH", "ADDR", "EMAIL"}));
			cbInfo.setBounds(218, 30, 71, 21);
		}
		return cbInfo;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("조건별 검색");
			lblNewLabel.setBounds(118, 34, 88, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("회원이 남긴 후기 수");
			lblNewLabel_1.setBounds(12, 28, 125, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfActionCount() {
		if (tfActionCount == null) {
			tfActionCount = new JTextField();
			tfActionCount.setEditable(false);
			tfActionCount.setBounds(12, 53, 116, 21);
			tfActionCount.setColumns(10);
		}
		return tfActionCount;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("5개 미만 : 관람객");
			lblNewLabel_2.setBounds(12, 109, 110, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("5개 이상 : 매니아");
			label.setBounds(12, 134, 110, 15);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("20개 이상 : 비평가");
			label_1.setBounds(12, 159, 110, 15);
		}
		return label_1;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("50개 이상 : 투자자");
			lblNewLabel_3.setBounds(12, 184, 110, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("활동별 검색");
			lblNewLabel_4.setBounds(118, 120, 88, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("회원 등급 기준");
			lblNewLabel_5.setBounds(12, 84, 97, 15);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("등급 조정");
			lblNewLabel_6.setBounds(12, 209, 84, 15);
		}
		return lblNewLabel_6;
	}
	private JComboBox getCbAction() {
		if (cbAction == null) {
			cbAction = new JComboBox();
			cbAction.setModel(new DefaultComboBoxModel(new String[] {"후기갯수", "고객등급"}));
			cbAction.setBounds(190, 117, 97, 21);
		}
		return cbAction;
	}
	private JTextField getTfActionSearch() {
		if (tfActionSearch == null) {
			tfActionSearch = new JTextField();
			tfActionSearch.setBounds(303, 118, 116, 21);
			tfActionSearch.setColumns(10);
		}
		return tfActionSearch;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("검색");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<Member> arr = mmdba.userActionSearch(cbAction.getSelectedIndex(),tfActionSearch.getText());
					String[] cols = {"MEMBER NO","ID","GRADE","NAME","GENDER","BIRTH","ADDR","EMAIL"};
					DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
					table.setModel(dt);
					for(int i = 0; i < arr.size() ; i++) {
						dt.setValueAt(arr.get(i).getNum(), i, 0);
						dt.setValueAt(arr.get(i).getId(), i, 1);
						dt.setValueAt(arr.get(i).getGrade(), i, 2);
						dt.setValueAt(arr.get(i).getName(), i, 3);
						dt.setValueAt(arr.get(i).getGender(), i, 4);
						dt.setValueAt(arr.get(i).getBirth(), i, 5);
						dt.setValueAt(arr.get(i).getAddr(), i, 6);
						dt.setValueAt(arr.get(i).getEmail(), i, 7);
				}
				}
			});
			btnNewButton_3.setBounds(433, 118, 97, 23);
		}
		return btnNewButton_3;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("후기 갯수의 경우 입력한 값을 초과하는 고객을 검색합니다.");
			label_2.setBounds(190, 149, 340, 15);
		}
		return label_2;
	}
	private JComboBox getCbGrade() {
		if (cbGrade == null) {
			cbGrade = new JComboBox();
			cbGrade.setModel(new DefaultComboBoxModel(new String[] {"관람객", "매니아", "비평가", "투자자"}));
			cbGrade.setBounds(12, 234, 116, 21);
		}
		return cbGrade;
	}
	private JButton getBtnNewButton_4() {
		if (btnNewButton_4 == null) {
			btnNewButton_4 = new JButton("등급 변경");
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					String num = String.valueOf(table.getValueAt(i, 0));
					mmdba.updateGrade(cbGrade.getSelectedItem(),num);
					viewMemberAll();
				}
			});
			btnNewButton_4.setBounds(12, 265, 116, 23);
		}
		return btnNewButton_4;
	}
	private JButton getBtnNewButton_6() {
		if (btnNewButton_6 == null) {
			btnNewButton_6 = new JButton("회원의 기록포함 모두 삭제");
			btnNewButton_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int i = table.getSelectedRow();
					String id = String.valueOf(table.getValueAt(i, 1));
					udba.deleteUser(id);
					JOptionPane.showMessageDialog(null, "회원 삭제 되었습니다.");
				}
			});
			btnNewButton_6.setBounds(228, 62, 259, 23);
		}
		return btnNewButton_6;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("<주의> 회원이 남긴 후기와 평점이 모두 없어지게 됩니다.");
			lblNewLabel_7.setFont(new Font("바탕체", Font.BOLD, 9));
			lblNewLabel_7.setBounds(228, 92, 302, 15);
		}
		return lblNewLabel_7;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("후기 삭제");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
					int i = table_2.getSelectedRow();
					String re = String.valueOf(table_2.getValueAt(i, 0));
					udba.deleteRe(re);
					}catch(ArrayIndexOutOfBoundsException e1) {
						JOptionPane.showMessageDialog(null, "삭제할 후기를 선택하셔야 합니다.");
					}
				}
			});
			btnNewButton_1.setBounds(499, 63, 97, 23);
		}
		return btnNewButton_1;
	}
	private void userSelect() {
		int i = table.getSelectedRow();
		ArrayList<Movie> arr = mmdba.userViewMovie(table.getValueAt(i, 0));
		String[] cols = {"TITLE"};
		DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
		table_1.setModel(dt);
		for(int k = 0 ; k<arr.size() ; k++) {
			dt.setValueAt(arr.get(k).getTitle(), k, 0);
		}
		
		String num = String.valueOf(table.getValueAt(i, 0));
		tfActionCount.setText(mmdba.userActionCount(num)+"개 작성");
	}
}
