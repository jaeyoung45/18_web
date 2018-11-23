package chap09;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ConsoleBank {
   Scanner sc = new Scanner(System.in);
   HashMap<String, Integer> hm = new HashMap<>();
   
   public void Menu() {
      System.out.println("1.계좌  2.예금  3.출금  4.총잔액확인  5.전체확인");
      int choice = sc.nextInt();
      switch(choice) {
      case 1:geja();
      case 2:input();
      case 3:output();
      case 4:total();
      case 5:all();
      default : System.out.println("1~5번을 입력하세요.");
      }
   }
   
   public void geja() {
      System.out.println("이름을 입력하세요.");
      String name = sc.next();
      hm.put(name, 0);
      Menu();
   }
   
   public void input() {
      System.out.println("이름을 입력하세요.");
      String name = sc.next();
      if(hm.containsKey(name)) {
         System.out.println("입금하실 금액>>");
         int don = sc.nextInt();
         hm.put(name, don);
         System.out.println("이름 : "+name+"\t"+"잔액 : "+hm.get(name));
         Menu();
      }else {
         System.out.println("사용하실 수 없습니다.");
         Menu();
      }
   }
   
   public void output() {
      System.out.println("이름을 입력하세요.");
      String name = sc.next();
      if(hm.containsKey(name)) {
         System.out.println("찾으실 금액>>");
         int don = sc.nextInt();
         hm.put(name, hm.get(name)-don);
         System.out.println("이름 : "+name+"\t"+"잔액 : "+hm.get(name));
         Menu();
      }else {
         System.out.println("없는 계좌이름입니다");
         Menu();
      }        
   }
   
   public void total() {
      System.out.println("이름을 입력하세요");
      String name = sc.next();
      int don = hm.get(name);
      System.out.println("잔액 : " + don);
      Menu();
   }
   
   public void all() {
      Set<String> set = hm.keySet();
      Iterator<String> it = set.iterator();
      while(it.hasNext()) {
         String key = it.next();
         System.out.println("이름 : " + key + "\t" + "잔액 : " + hm.get(key));
      }
      Menu();
   }
   
   public static void main(String[] args) {
      ConsoleBank cb = new ConsoleBank();
      cb.Menu();
   }
}