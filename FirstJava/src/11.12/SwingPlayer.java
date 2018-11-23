package chap09;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingPlayer extends JFrame{
   private JTextField [] tf =new JTextField [5];
   Connection con;
   public SwingPlayer() {
      dbCon();
      setTitle("SwingPlayer");
      setLayout(new GridLayout(2,2));
      Container c= getContentPane();
      c.add(new PlayerPanel()); //1�� 1��
      JTextArea ta = new JTextArea(); //1�� 2��
      JScrollPane jsp = new JScrollPane(ta);
      c.add(jsp);
      JPanel p1 = new JPanel();  //2�� 1��
      JLabel lblNum = new JLabel("");
      lblNum.setVisible(false); //��ȣ label �Ⱥ��̰�
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
      //����
      insertBtn.addActionListener(new ActionListener() {         
         
         public void actionPerformed(ActionEvent e) {
            String sql ="insert into player values(player_seq.nextval,?,?,?,?,?)";
            try {            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tf[0].getText());
            ps.setString(2, tf[1].getText());
            ps.setDouble(3, Double.parseDouble(tf[2].getText()));
            ps.setDouble(4, Double.parseDouble(tf[3].getText()));
            ps.setString(5, tf[4].getText());
            ps.executeUpdate();
            
            } catch (SQLException e1) {            
               e1.printStackTrace();         
            }
            
         }
      });
      //����
      viewBtn.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {

            String sql = "SELECT * FROM PLAYER";
            Statement st;
            try {
               st=con.createStatement();
               ResultSet rs = st.executeQuery(sql);
               while(rs.next()) {
                  ta.append("��ȣ :"+rs.getInt("num")+"\n");
                  ta.append("�̸� :"+rs.getString("name")+"\n");
                  ta.append("���� :"+rs.getString("birth")+"\n");
                  ta.append("Ű :"+rs.getDouble("height")+"\n");
                  ta.append("������ :"+rs.getDouble("weight")+"\n");
                  ta.append("���� :"+rs.getString("kind")+"\n");
                  ta.append("\n");                  
               }
               //st.executeQuery(sql);
            } catch (SQLException e1) {         
               e1.printStackTrace();
            } catch (NumberFormatException e2) {
				new MessageBox("����!!!", "�ٽ� �����ϼ���");
			} catch (NullPointerException e3) {
				new MessageBox("����!!!", "�ٽ� �����ϼ���");
			}           
         }
      });
      
      JPanel p2 = new JPanel(); //2�� 2��
      JComboBox<String> jcb = new JComboBox<>();
      jcb.addItem("�̸�");
      jcb.addItem("����");
      JTextField searchtf = new JTextField(15);
      JButton searchBtn = new JButton("�˻�");
      p2.add(jcb);
      p2.add(searchtf);
      p2.add(searchBtn);
      //�˻�
      searchBtn.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
        	if(searchtf.getText().isEmpty()) return;
            ta.setText("");
            int idx=jcb.getSelectedIndex();
            String key = "name";
            if(idx==0) {
               key="name";
            }else if(idx==1) {
               key="kind";
            }
            String sql = "SELECT * FROM PLAYER WHERE "+key+" LIKE '%"+searchtf.getText()+"%'";      
            Statement st;
            try {
               st=con.createStatement();
               ResultSet rs = st.executeQuery(sql);
               while(rs.next()) {
                  ta.append("��ȣ :"+rs.getInt("num")+"\n");
                  ta.append("�̸� :"+rs.getString("name")+"\n");
                  ta.append("���� :"+rs.getString("birth")+"\n");
                  ta.append("Ű :"+rs.getDouble("height")+"\n");
                  ta.append("������ :"+rs.getDouble("weight")+"\n");
                  ta.append("���� :"+rs.getString("kind")+"\n");
                  ta.append("\n");                  
               }
               st.executeQuery(sql);
            } catch (SQLException e1) {         
               e1.printStackTrace();
            }            
         }            
      });
      ta.addMouseListener(new MouseAdapter() {
    	  @Override
    	public void mouseReleased(MouseEvent e) {
    		
    		  //System.out.println(ta.getSelectedText());
    		  try {
    		  lblNum.setVisible(true);
    		  int num = Integer.parseInt(ta.getSelectedText().trim());
    		  lblNum.setText(ta.getSelectedText());
    		  String sql = "select * from player where num = "+num;
    		  Statement st;
			try {
				st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if(rs.next()) {
    			  tf[0].setText(rs.getString("name"));
    			  tf[1].setText(rs.getString("birth"));
    			  tf[2].setText(rs.getString("height"));
    			  tf[3].setText(rs.getString("weight"));
    			  tf[4].setText(rs.getString("kind"));
			} 
			}catch (SQLException e1) {
				e1.printStackTrace();
    
    		  }
    	  }
      });
      //����
      updateBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String sql = "update player set name=?,birth=?,weight=?"
					+ ",height=?,kind=? where num=?";
			try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tf[0].getText());
			ps.setString(2, tf[1].getText());
			ps.setDouble(3, Double.parseDouble(tf[2].getText()));
			ps.setDouble(4, Double.parseDouble(tf[3].getText()));
			ps.setString(5, tf[4].getText());
			ps.setInt(6,Integer.parseInt(lblNum.getText()));
			ps.executeUpdate();
			viewBtn.doClick();//���� Ŭ��(������ ���� Ȯ�� ����)
			
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
		}
      });
      //����
      deleteBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int num = Integer.parseInt(lblNum.getText());
			String sql = "delete from player where num="+num;
			try {
				Statement st = con.createStatement();
				st.executeQuery(sql);
				viewBtn.doClick(); //���� ��ư Ŭ���ϱ�
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	});
      c.add(p2);  
      
      
      setSize(600,400);
      setVisible(true);         
   }
   
   //������
   private void dbCon() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url="jdbc:oracle:thin:@localhost:1521:xe";
         String user = "scott";
         String pwd = "TIGER";         
         con = DriverManager.getConnection(url, user, pwd);
         } catch (SQLException | ClassNotFoundException e) {            
            e.printStackTrace();         
         }
   }
   
   class PlayerPanel extends JPanel{
      private String [] text = {"�̸�", "����", "Ű", "������", "����"};      
      public PlayerPanel() {
       setLayout(null);
       
       for(int i=0;i<text.length;i++) {
          JLabel la = new JLabel(text[i]);
          la.setHorizontalAlignment(JLabel.RIGHT);
          la.setSize(50,20);
          la.setLocation(30,50+i*20);
          add(la);
          tf[i]=new JTextField(50);
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