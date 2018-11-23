package swing.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test02 extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel panel;
	private JLabel label;
	private JTabbedPane tabbedPane;
	private JPanel tab1;
	private JPanel tab2;
	private JPanel tab3;
	private JButton button;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test02 frame = new Test02();
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
	public Test02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setDividerSize(1);
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getTabbedPane());
			splitPane.setDividerLocation(250);
		}
		return splitPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 200, 0), 3), "\uC2A4\uC719\uD14C\uC2A4\uD2B8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setLayout(null);
			panel.add(getLabel());
		}
		return panel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("이름");
			label.setBackground(Color.DARK_GRAY);
			label.setFont(new Font("굴림", Font.PLAIN, 18));
			label.setForeground(Color.MAGENTA);
			label.setBounds(12, 39, 149, 107);
		}
		return label;
	}
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("첫번째", null, getTab1(), null);
			tabbedPane.addTab("두번째", null, getTab2(), null);
			tabbedPane.addTab("세번째", null, getTab3(), null);
		}
		return tabbedPane;
	}
	private JPanel getTab1() {
		if (tab1 == null) {
			tab1 = new JPanel();
			tab1.setLayout(null);
			tab1.add(getButton());
		}
		return tab1;
	}
	private JPanel getTab2() {
		if (tab2 == null) {
			tab2 = new JPanel();
			tab2.setLayout(null);
			tab2.add(getTextField());
		}
		return tab2;
	}
	private JPanel getTab3() {
		if (tab3 == null) {
			tab3 = new JPanel();
			tab3.setLayout(new BorderLayout(0, 0));
			tab3.add(getScrollPane(), BorderLayout.CENTER);
		}
		return tab3;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("첫번째탭클릭");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tabbedPane.setSelectedIndex(1);
					
					
				}
			});
			button.setBounds(24, 98, 148, 23);
		}
		return button;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(52, 96, 116, 21);
			textField.setColumns(10);
			textField.setText("안녕");
		}
		return textField;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
