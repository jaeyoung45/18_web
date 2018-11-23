package movieSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import movieDBA.Movie;
import movieDBA.ReviewDBA;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerMovieRe extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JPanel panel;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JScrollPane scrollPane;
	private JTable table;
	ReviewDBA rdba = new ReviewDBA();
	private String m_num;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMovieRe frame = new ManagerMovieRe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public ManagerMovieRe(String m_num) {
		this.m_num=m_num;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
		}
		return menuBar;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panel;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("돌아가기");
			mnNewMenu.add(getMntmNewMenuItem());
		}
		return mnNewMenu;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("돌아가기");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
		}
		return mntmNewMenuItem;
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

			ArrayList<Movie> arr = rdba.reAllView(m_num);
			String[] cols = {"ID","RE","SCORE","DATE"};
			DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
			for(int i = 0 ; i< arr.size() ; i++) {
				dt.setValueAt(arr.get(i).getId(), i, 0);
				dt.setValueAt(arr.get(i).getReply(), i, 1);
				dt.setValueAt(arr.get(i).getScore(), i, 2);
				dt.setValueAt(arr.get(i).getDate(), i, 3);
			}
			table.setModel(dt);
		}
		return table;
	}
}
