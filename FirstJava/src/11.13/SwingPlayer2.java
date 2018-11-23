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
      c.add(new PlayerPanel()); //1행 1열
      JTextArea ta = new JTextArea(); //1행 2열
      JScrollPane jsp = new JScrollPane(ta);
      c.add(jsp);
      JPanel p1 = new JPanel();  //2행 1열
      JLabel lblNum = new JLabel("");
      lblNum.setVisible(false); //번호 label 안보이게
      JButton insertBtn = new JButton("추가");
      JButton viewBtn = new JButton("보기");
      JButton updateBtn = new JButton("수정");
      JButton deleteBtn = new JButton("삭제");
      p1.add(lblNum);
      p1.add(insertBtn);
      p1.add(viewBtn);
      p1.add(updateBtn);
      p1.add(deleteBtn);      
      c.add(p1);
      //추가 버튼
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
      //전체보기 버튼
      viewBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	  ta.setText("");
         ArrayList<Player> arr = dba.PlayerView();
         for(Player p:arr) {
            ta.append("번호 :"+p.getNum()+"\n");
            ta.append("이름 :"+p.getName()+"\n");
            ta.append("생일 :"+p.getBirth()+"\n");
            ta.append("키 :"+p.getHeight()+"\n");
            ta.append("몸무게 :"+p.getWeight()+"\n");
            ta.append("종목 :"+p.getKind()+"\n\n");                  
         }
            dba.PlayerView();
         }
      });
      //마우스로 블럭지정시 보여주기 
      ta.addMouseListener(new MouseAdapter() {
        public void mouseReleased(MouseEvent e) {
         int num = Integer.parseInt(ta.getSelectedText().trim());
    	 Player p=dba.playerSelect(num);
    	 lblNum.setVisible(true);
    	 lblNum.setText(p.getNum()+""); //번호출력
    	 tf[0].setText(p.getName()); //이름
    	 tf[1].setText(p.getBirth()); //생일
    	 tf[2].setText(p.getHeight()+""); //키
    	 tf[3].setText(p.getWeight()+""); //몸무게
    	 tf[4].setText(p.getKind()); //종목
         }
      });
      //삭제 버튼
      deleteBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {         
        int result = JOptionPane.showConfirmDialog(null, "삭제할까요?","Confirm",JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION) {
        	int num = Integer.parseInt(lblNum.getText());
        	lblNum.setText("");
        	dba.PlayerDelete(num);
        	ta.setText(""); //JTextArea 클리어
        	viewBtn.doClick(); //보기 클릭
        }
         }
      });
      //수정 버튼
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
            
      
      JPanel p2 = new JPanel(); //2행 2열
      JComboBox<String> jcb = new JComboBox<>();
      jcb.addItem("이름");
      jcb.addItem("종목");
      JTextField searchtf = new JTextField(15);
      JButton searchBtn = new JButton("검색");
      p2.add(jcb);
      p2.add(searchtf);
      p2.add(searchBtn);
      
      
      //검색 버튼
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
               ta.append("번호 :"+arr.get(i).getNum()+"\n");
               ta.append("이름 :"+arr.get(i).getName()+"\n");
               ta.append("생일 :"+arr.get(i).getBirth()+"\n");
               ta.append("키 :"+arr.get(i).getHeight()+"\n");
               ta.append("몸무게 :"+arr.get(i).getWeight()+"\n");
               ta.append("종목 :"+arr.get(i).getKind()+"\n\n");
            }            
         }            
      });
      
      c.add(p2);         
      
      setSize(600,400);
      setVisible(true);         
   }   

   //디비 셋팅
   class PlayerPanel extends JPanel{
      private String [] text = {"이름", "생일", "키", "몸무게", "종목"};      
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