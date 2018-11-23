package chap09;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChangeMoney extends JFrame{
   private int [] unit = {50000, 10000, 1000, 5000, 500, 100, 50, 10, 1};
   private String[] text = {"오만원", "만원", "천원","500원", "100원", "50원", "10원", "1원"};
   private JTextField[] tf = new JTextField[8];
   private JCheckBox[] cb = new JCheckBox[7];
   
   public ChangeMoney() {
      setTitle("동전기입기");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(null);
      Container c = getContentPane();
      c.setBackground(Color.PINK);
      
      //금액
      JLabel la = new JLabel("금액");
      la.setSize(50,20);
      la.setLocation(20,20);
      add(la);
      
      JTextField won = new JTextField(30);
      won.setHorizontalAlignment(JTextField.RIGHT);
      won.setSize(100, 20);
      won.setLocation(100,20);
      add(won);
      
      //계산버튼
      JButton btn = new JButton("계산");
      btn.setSize(70,20);
      btn.setLocation(210,20);
      add(btn);
      btn.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
            int don = Integer.parseInt(won.getText());
            for(int i=0;i<unit.length;i++) {
               if(i==unit.length-1) {
                  int a = don/unit[i];
                  tf[i].setText(a+"");
                  break;
               }
               if(!cb[i].isSelected()) {
               tf[i].setText("0");
               continue;
               }
               int a = don/unit[i];
               tf[i].setText(a+"");
               don = don%unit[i];            
            }  
            }catch(NumberFormatException n){
               new MessageBox("오류", "숫자를 입력하세요.");
            }
         }
      });
      
      
      //액수별 for
      for(int i=0;i<text.length;i++) {
         //text
         la = new JLabel(text[i]);
         la.setHorizontalAlignment(JLabel.RIGHT);
         la.setSize(50, 20);
         la.setLocation(50, 50+i*20);
         add(la);
         
         //JTextField
         tf[i] = new JTextField();
         tf[i].setEditable(false);
         tf[i].setHorizontalAlignment(JTextField.CENTER);
         tf[i].setSize(70, 20);
         tf[i].setLocation(120,50+i*20);
         add(tf[i]);
         
         //체크박스
         if(i==text.length-1)break;
        //cb[i]=new JCheckBox("", true);
         cb[i]=new JCheckBox();
         cb[i].setBackground(Color.pink);
         cb[i].setSelected(true);
         cb[i].setSize(30,20);
         cb[i].setLocation(200, 50+i*20);
         cb[i].addItemListener(new ItemListener() {
            
            @Override
            public void itemStateChanged(ItemEvent e) {
               btn.doClick();
               
            }
         });
         add(cb[i]);         
         
      }
      setSize(300,300);
      setVisible(true);
         
   }
   
   
   public static void main(String[] args) {
      new ChangeMoney();

   }
}