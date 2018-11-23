package chap09;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//내부 클래스로 변환하기

public class FlowLayoutEx2 extends JFrame {
   private JTextField tf1;
   private JTextField tf2;
   private JTextField result;
   
   public FlowLayoutEx2() {
      setTitle("FlowLayoutEx 예제");
      setLayout(new FlowLayout());//차례대로 배치
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = getContentPane();
      c.add(new JLabel("숫자1"));      
      tf1 = new JTextField(5);
      add(tf1);
      c.add(new JLabel("숫자2"));
      tf2 = new JTextField(5);
      add(tf2);
      JButton sum = new JButton("+");
      JButton sub = new JButton("-");
      JButton mul = new JButton("*");
      JButton div = new JButton("/");      
      add(sum);
      add(sub);
      add(mul);
      add(div);
      add(new JLabel("결과"));
      result = new JTextField(10);
      add(result);      
      sum.addActionListener(new ActionListener() {         
         public void actionPerformed(ActionEvent e) {            
            int a = Integer.parseInt(tf1.getText());
            int b = Integer.parseInt(tf2.getText());
            result.setText(a+b+"");
         }      
      });
      sub.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {            
            int a = Integer.parseInt(tf1.getText());
            int b = Integer.parseInt(tf2.getText());
            result.setText(a-b+"");
         }
      });
      mul.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {            
            int a = Integer.parseInt(tf1.getText());
            int b = Integer.parseInt(tf2.getText());
            result.setText(a*b+"");
         }
      });
      div.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {            
            int a = Integer.parseInt(tf1.getText());
            int b = Integer.parseInt(tf2.getText());            
            try {
               result.setText(String.valueOf(a/b));//int -> String 변환
            }catch(ArithmeticException ar) {
               result.setText("0으로 나눌 수 없음");
            }
            }         
      });
      setSize(250,200);
      setVisible(true);
   }
   
//   public void actionPerformed(ActionEvent e) {
//      String str = e.getActionCommand();
//      try {
//      int a = Integer.parseInt(tf1.getText());
//      int b = Integer.parseInt(tf2.getText());
//      if(str.equals("+")) {
//         result.setText(a+b+"");
//      }else if(str.equals("-")) {
//         result.setText(a-b+"");
//      }else if(str.equals("*")) {
//         result.setText(a*b+"");
//      }else if(str.equals("/")) {         
//      try {
//         result.setText(String.valueOf(a/b));//int -> String 변환
//      }catch(ArithmeticException ar) {
//         result.setText("0으로 나눌 수 없음");
//      }
//      }
//            
//   }catch (NumberFormatException n) {
//   result.setText("숫자를 입력하세요.");
//   }
//}
//   public static void main(String[] args) {
//      new FlowLayoutEx1();
//   }
//}

//class FlowEvnet implements ActionListener{
//      public void actionPerformed(ActionEvent e) {
//      String str = e.getActionCommand();
//      try {
//      int a = Integer.parseInt(tf1.getText());
//      int b = Integer.parseInt(tf2.getText());
//      if(str.equals("+")) {
//         result.setText(a+b+"");
//      }else if(str.equals("-")) {
//         result.setText(a-b+"");
//      }else if(str.equals("*")) {
//         result.setText(a*b+"");
//      }else if(str.equals("/")) {         
//      try {
//         result.setText(String.valueOf(a/b));//int -> String 변환
//      }catch(ArithmeticException ar) {
//         result.setText("0으로 나눌 수 없음");
//      }
//      }
//            
//      }catch (NumberFormatException n) {
//         result.setText("숫자를 입력하세요.");
//      }
//      }
//}
public static void main(String[] args) {
   new FlowLayoutEx2();
   }
}