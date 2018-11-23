package chap09;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//���� Ŭ������ ��ȯ�ϱ�

public class FlowLayoutEx2 extends JFrame {
   private JTextField tf1;
   private JTextField tf2;
   private JTextField result;
   
   public FlowLayoutEx2() {
      setTitle("FlowLayoutEx ����");
      setLayout(new FlowLayout());//���ʴ�� ��ġ
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = getContentPane();
      c.add(new JLabel("����1"));      
      tf1 = new JTextField(5);
      add(tf1);
      c.add(new JLabel("����2"));
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
      add(new JLabel("���"));
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
               result.setText(String.valueOf(a/b));//int -> String ��ȯ
            }catch(ArithmeticException ar) {
               result.setText("0���� ���� �� ����");
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
//         result.setText(String.valueOf(a/b));//int -> String ��ȯ
//      }catch(ArithmeticException ar) {
//         result.setText("0���� ���� �� ����");
//      }
//      }
//            
//   }catch (NumberFormatException n) {
//   result.setText("���ڸ� �Է��ϼ���.");
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
//         result.setText(String.valueOf(a/b));//int -> String ��ȯ
//      }catch(ArithmeticException ar) {
//         result.setText("0���� ���� �� ����");
//      }
//      }
//            
//      }catch (NumberFormatException n) {
//         result.setText("���ڸ� �Է��ϼ���.");
//      }
//      }
//}
public static void main(String[] args) {
   new FlowLayoutEx2();
   }
}