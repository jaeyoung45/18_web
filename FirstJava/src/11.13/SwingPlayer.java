package chap09;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import day14.MessageBox;


public class SwingPlayer extends JFrame {
	Connection con;
	PreparedStatement ps;
	JScrollPane jsp;
	private JTextField [] tf = new JTextField[5];
	
	
	public SwingPlayer(){
		setTitle("SwingPlayer");
		dbcon();
		setLayout(new GridLayout(2,2));
		Container c = getContentPane();
		c.add(new PlayerPanel());
		JTextArea ta= new JTextArea();
		jsp = new JScrollPane(ta);
		c.add(jsp);
		JPanel p1 = new JPanel();
		JLabel lblNum = new JLabel("");
		lblNum.setVisible(false); //lblNum �Ⱥ��̱�
		JButton insertBtn = new JButton("�߰�");
		JButton viewBtn = new JButton("����");
		JButton updateBtn = new JButton("����");
		JButton deleteBtn = new JButton("����");
		p1.add(lblNum);
		p1.add(insertBtn);	
		p1.add(viewBtn);
		p1.add(updateBtn);
		p1.add(deleteBtn);
		c.add(p1);
		
		insertBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String sql = "insert into player values(player_seq.nextval,?,?,?,?,?)";
				try {
					
					ps = con.prepareStatement(sql);
					ps.setString(1, tf[0].getText());
					ps.setString(2, tf[1].getText());
					ps.setDouble(3, Double.parseDouble(tf[2].getText()));
					ps.setDouble(4, Double.parseDouble(tf[3].getText()));
					ps.setString(5, tf[4].getText());
					ps.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		viewBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql= "Select * from player";
			
				try {
					Statement st = con.createStatement();
					ResultSet rs =st.executeQuery(sql);
					while(rs.next()) {
						ta.append("��ȣ: "+rs.getInt("num")+"\n");
						ta.append("�̸�: "+rs.getString("name")+"\n");
						ta.append("����: "+rs.getString("birth")+"\n");
						ta.append("����: "+rs.getString("kind")+"\n");
						ta.append("Ű: "+rs.getDouble("height")+"\n");
						ta.append("������: "+rs.getDouble("weight")+"\n");
						ta.append("\n");
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
	
		JPanel p2 = new JPanel();
		JComboBox<String> jcb = new JComboBox<>();
		jcb.addItem("�̸�");
		jcb.addItem("����");
		JTextField searchtf = new JTextField(10);
		JButton searchBtn = new JButton("�˻�");
		
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				ta.setText("");
				
				int idx = jcb.getSelectedIndex();
				String key="name";
				if(idx==0) {
					key="name";
				}else {
					key="kind";
				}
				String jcb= searchtf.getText();
				String sql= "SELECT * FROM player WHERE "+key+" like '%"+jcb+"%'";
				
				try {
					Statement st= con.createStatement();
					ResultSet rs =st.executeQuery(sql);
					
					if(!sql.equals(jcb)) {
						ta.append("ã�� ����� �����ϴ�.");
					}
					
					while(rs.next()) {
						ta.append("��ȣ: "+rs.getInt("num")+"\n");
						ta.append("�̸�: "+rs.getString("name")+"\n");
						ta.append("����: "+rs.getString("birth")+"\n");
						ta.append("����: "+rs.getString("kind")+"\n");
						ta.append("Ű: "+rs.getDouble("height")+"\n");
						ta.append("������: "+rs.getDouble("weight")+"\n");
						ta.append("\n");
						
					}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
			
				
			}
		});
		ta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(ta.getSelectedText());
				try {		
				lblNum.setVisible(true);
				int num = Integer.parseInt(ta.getSelectedText());
				lblNum.setText(num+"");
				String sql = "select * from player where num="+num;
				Statement st;
					st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					if(rs.next()) {
						tf[0].setText(rs.getString("name"));
						tf[1].setText(rs.getString("birth"));
						tf[2].setText(rs.getString("height"));
						tf[3].setText(rs.getString("weight"));
						tf[4].setText(rs.getString("kind"));
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch(NumberFormatException n) {
					new MessageBox("����", "�ٽ� �����ϼ���");
				} catch(NullPointerException n2) {
					new MessageBox("����", "�ٽ� �����ϼ���");
				}
				}
		});
		
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "update player set name=?,birth=?,height=?,weight=?,kind=? where num=?";
				PreparedStatement ps;
				try {
					ps = con.prepareStatement(sql);
					ps.setString(1, tf[0].getText());
					ps.setString(2, tf[1].getText());
					ps.setDouble(3, Double.parseDouble(tf[2].getText()));
					ps.setDouble(4, Double.parseDouble(tf[3].getText()));
					ps.setString(5, tf[4].getText());
					ps.setInt(6, Integer.parseInt(lblNum.getText()));
					ps.executeUpdate();
					viewBtn.doClick();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			int num = Integer.parseInt(lblNum.getText());
			String sql = "delete from player where num="+num;
			Statement st;
			try {
				st = con.createStatement();
				st.executeQuery(sql);
				viewBtn.doClick();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
				
			}
		});
		
	
		p2.add(jcb);
		p2.add(searchtf);
		p2.add(searchBtn);
		c.add(p2);
		setSize(600,400);
		setVisible(true);
	
	}
	
	private void dbcon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String pwd = "TIGER";
			con = DriverManager.getConnection(url, user, pwd);
			
		} catch (ClassNotFoundException | SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	
	
	class PlayerPanel extends JPanel{
		private String [] text = {"�̸�","����","Ű","������","����"};
		public PlayerPanel() {
		setLayout(null);
		
		for(int i=0; i<text.length; i++) {
			JLabel la = new JLabel(text[i]);
			la.setHorizontalAlignment(JLabel.RIGHT);
			la.setSize(50,20);
			la.setLocation(30,50+i*20);
			add(la);
			tf[i]= new JTextField(50);
			tf[i].setHorizontalAlignment(JTextField.CENTER);
			tf[i].setSize(150,20);
			tf[i].setLocation(120,50+i*20);
			add(tf[i]);
			
			
		}
		}
	}
	

	public static void main(String[] args) {
		new SwingPlayer();

	}

}
