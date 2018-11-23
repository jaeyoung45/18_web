package chap09;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import chap09.player.Player;
import chap09.player.PlayerDBA;

public class SwingPlayer2 extends JFrame{
   private JTextField [] tf =new JTextField [5];
   PlayerDBA dba = new PlayerDBA();
   
   public SwingPlayer2() {      
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
      //�߰� ��ư
      insertBtn.addActionListener(new ActionListener() {         
         public void actionPerformed(ActionEvent e) {            
            String name = tf[0].getText();
            String birth = tf[1].getText();
            String h = tf[2].getText();
            String w = tf[3].getText();
            String kind = tf[4].getText();
            Player p = new Player();
            p.setName(name);
            p.setBirth(birth);
            p.setHeight(Double.parseDouble(h));
            p.setWeight(Double.parseDouble(w));
            p.setKind(kind);            
            dba.PlayerInsert(p);
         }
      });
      //��ü���� ��ư
      viewBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	  ta.setText("");
         ArrayList<Player> arr = dba.PlayerView();
         for(Player p:arr) {
            ta.append("��ȣ :"+p.getNum()+"\n");
            ta.append("�̸� :"+p.getName()+"\n");
            ta.append("���� :"+p.getBirth()+"\n");
            ta.append("Ű :"+p.getHeight()+"\n");
            ta.append("������ :"+p.getWeight()+"\n");
            ta.append("���� :"+p.getKind()+"\n\n");                  
         }
            dba.PlayerView();
         }
      });
      //���콺�� �������� �����ֱ� 
      ta.addMouseListener(new MouseAdapter() {
        public void mouseReleased(MouseEvent e) {
         int num = Integer.parseInt(ta.getSelectedText().trim());
    	 Player p=dba.playerSelect(num);
    	 lblNum.setVisible(true);
    	 lblNum.setText(p.getNum()+""); //��ȣ���
    	 tf[0].setText(p.getName()); //�̸�
    	 tf[1].setText(p.getBirth()); //����
    	 tf[2].setText(p.getHeight()+""); //Ű
    	 tf[3].setText(p.getWeight()+""); //������
    	 tf[4].setText(p.getKind()); //����
         }
      });
      //���� ��ư
      deleteBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {         
        int result = JOptionPane.showConfirmDialog(null, "�����ұ��?","Confirm",JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION) {
        	int num = Integer.parseInt(lblNum.getText());
        	lblNum.setText("");
        	dba.PlayerDelete(num);
        	ta.setText(""); //JTextArea Ŭ����
        	viewBtn.doClick(); //���� Ŭ��
        }
         }
      });
      //���� ��ư
      updateBtn.addActionListener(new ActionListener() {         
         public void actionPerformed(ActionEvent e) {               
        	 String name = tf[0].getText();
             String birth = tf[1].getText();
             String h = tf[2].getText();
             String w = tf[3].getText();
             String kind = tf[4].getText();
             int num = Integer.parseInt(lblNum.getText());
             Player p = new Player();
             p.setName(name);
             p.setBirth(birth);
             p.setHeight(Double.parseDouble(h));
             p.setWeight(Double.parseDouble(w));
             p.setKind(kind); 
             p.setNum(num);
             dba.PlayerUpdate(p);
             viewBtn.doClick();
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
      
      
      //�˻� ��ư
      searchBtn.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            ta.setText("");
            int num=jcb.getSelectedIndex();
            String key = "name";
            if(num==0) {
               key="name";
            }else if(num==1) {
               key="kind";
            }
         ArrayList<Player> arr = dba.PlayerSearch(key,searchtf.getText());
            for(int i=0;i<arr.size();i++) {
               ta.append("��ȣ :"+arr.get(i).getNum()+"\n");
               ta.append("�̸� :"+arr.get(i).getName()+"\n");
               ta.append("���� :"+arr.get(i).getBirth()+"\n");
               ta.append("Ű :"+arr.get(i).getHeight()+"\n");
               ta.append("������ :"+arr.get(i).getWeight()+"\n");
               ta.append("���� :"+arr.get(i).getKind()+"\n\n");
            }            
         }            
      });
      
      c.add(p2);         
      
      setSize(600,400);
      setVisible(true);         
   }   

   //��� ����
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
      new SwingPlayer2();      
   }
}