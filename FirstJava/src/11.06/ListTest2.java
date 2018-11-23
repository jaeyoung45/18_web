package chap09;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//익명 클래스
public class ListTest2 extends JFrame {
   private JTextField tf;
   private JTextArea ta;
   private List lst;
   private JCheckBox cb;
   
   public ListTest2() {
      setTitle("List예제");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      JPanel p1 = new JPanel();
      p1.setLayout(new FlowLayout());
      tf = new JTextField(15);
      JButton btn = new JButton("추가");
      cb = new JCheckBox("다중선택");
      p1.add(tf);
      p1.add(btn);
      p1.add(cb);
      JPanel p2 = new JPanel();
      p2.setLayout(new GridLayout(1,2));
      lst = new List();
      ta = new JTextArea();
      p2.add(lst);
      p2.add(ta);
      btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if(tf.getText().isEmpty())return;
            lst.add(tf.getText());
            tf.setText("");            
         }
      });
      lst.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {   
      
      ta.setText("");
      if(lst.isMultipleMode()) { //리스트 다중모드
         String[] tmp = lst.getSelectedItems();
         for(int i=0;i<tmp.length;i++) {
            ta.append(tmp[i]+"\n");
         }
      }else { //리스트 단일모드
         ta.setText(lst.getSelectedItem());
      }   
      }
      });

      
      cb.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {               
               if(cb.isSelected()) { //체크선택
                  lst.setMultipleMode(true);//리스트를 다중모드로
               }else { //체크해제
                  lst.setMultipleMode(false);//리스트를 단일모드로
               
            }
         }
      });
      
      add(BorderLayout.NORTH, p1);
      add(BorderLayout.CENTER, p2);      
      setSize(400,400);
      setVisible(true);
   }

   public static void main(String[] args) {
      new ListTest2();

   }
   
}
