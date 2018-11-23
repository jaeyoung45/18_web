package chap09;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ConsoleBank {
   Scanner sc = new Scanner(System.in);
   HashMap<String, Integer> hm = new HashMap<>();
   
   public void Menu() {
      System.out.println("1.����  2.����  3.���  4.���ܾ�Ȯ��  5.��üȮ��");
      int choice = sc.nextInt();
      switch(choice) {
      case 1:geja();
      case 2:input();
      case 3:output();
      case 4:total();
      case 5:all();
      default : System.out.println("1~5���� �Է��ϼ���.");
      }
   }
   
   public void geja() {
      System.out.println("�̸��� �Է��ϼ���.");
      String name = sc.next();
      hm.put(name, 0);
      Menu();
   }
   
   public void input() {
      System.out.println("�̸��� �Է��ϼ���.");
      String name = sc.next();
      if(hm.containsKey(name)) {
         System.out.println("�Ա��Ͻ� �ݾ�>>");
         int don = sc.nextInt();
         hm.put(name, don);
         System.out.println("�̸� : "+name+"\t"+"�ܾ� : "+hm.get(name));
         Menu();
      }else {
         System.out.println("����Ͻ� �� �����ϴ�.");
         Menu();
      }
   }
   
   public void output() {
      System.out.println("�̸��� �Է��ϼ���.");
      String name = sc.next();
      if(hm.containsKey(name)) {
         System.out.println("ã���� �ݾ�>>");
         int don = sc.nextInt();
         hm.put(name, hm.get(name)-don);
         System.out.println("�̸� : "+name+"\t"+"�ܾ� : "+hm.get(name));
         Menu();
      }else {
         System.out.println("���� �����̸��Դϴ�");
         Menu();
      }        
   }
   
   public void total() {
      System.out.println("�̸��� �Է��ϼ���");
      String name = sc.next();
      int don = hm.get(name);
      System.out.println("�ܾ� : " + don);
      Menu();
   }
   
   public void all() {
      Set<String> set = hm.keySet();
      Iterator<String> it = set.iterator();
      while(it.hasNext()) {
         String key = it.next();
         System.out.println("�̸� : " + key + "\t" + "�ܾ� : " + hm.get(key));
      }
      Menu();
   }
   
   public static void main(String[] args) {
      ConsoleBank cb = new ConsoleBank();
      cb.Menu();
   }
}