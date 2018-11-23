package chap09;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PlayerMain {
   private Scanner sc = new Scanner(System.in);
   Connection con;
   
   public PlayerMain() {
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
   
   //�޴������ֱ� : 1.�������, 2.��������, 3.����ã��, 4.�������� 5.����  
   public void dbUse() {
      while(true) {
         System.out.println("1.������� 2.�������� 3.����ã�� 4.��������, 5.������������, 6.����");
         int choice = sc.nextInt();
         sc.nextLine();
         if(choice==1) {
            playerInsert();
         }else if(choice==2) {
            playerView();
         }else if(choice==3) {
            playerSearch();
         }else if(choice==4) {
            playerRemove();
         }else if(choice==5) {
            playerUpdate();
         }else if(choice==6){
        	playerExit();
         }else {
            System.out.println("�Է¿���");
         }         
      }
   }   

   
   //1.�������
   private void playerInsert() {   //�̸�, ����, Ű, ������, ����   
      System.out.println("�̸�>>");
      String name = sc.nextLine();
      System.out.println("����>>");
      String birth = sc.nextLine();
      System.out.println("Ű>>");
      double height = sc.nextDouble();
      System.out.println("������>>");
      double weight = sc.nextDouble();
      sc.nextLine(); //������ �Է��� ���� ���� ó��
      System.out.println("����>>");
      String kind = sc.nextLine();
      //db���̺� �Է�
//      String sql = "insert into player values(player_seq.nextval,'"+name+"','"+birth+"',"+height+","+weight+",'"+kind+"')";
      String sql ="insert into player values(player_seq.nextval,?,?,?,?,?)";
      try {
      //Statement st = con.createStatement();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, name);
      ps.setString(2, birth);
      ps.setDouble(3, height);
      ps.setDouble(4, weight);
      ps.setString(5, kind);
      ps.executeUpdate();
//      st.executeUpdate(sql);
      
      } catch (SQLException e) {            
         e.printStackTrace();         
      }
   }
   
   //2.��������
   private void playerView() {      
      String sql = "SELECT * FROM PLAYER";
      Statement st;
      try {
         st=con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while(rs.next()) {
            System.out.println("��ȣ :"+rs.getInt("num"));
            System.out.println("�̸� :"+rs.getString("name"));
            System.out.println("���� :"+rs.getString("birth"));
            System.out.println("Ű :"+rs.getDouble("height"));
            System.out.println("������ :"+rs.getDouble("weight"));            
            System.out.println("���� :"+rs.getString("kind"));
            System.out.println();
         }
         st.executeQuery(sql);
      } catch (SQLException e) {         
         e.printStackTrace();
      }      
   }
   
   //3.���� ã��
   private void playerSearch() {
      System.out.println("ã�� ���� �̸�>>>");
      String sname = sc.nextLine();
      search(sname);      
   }
   //4.��������
   private void playerRemove() {
      
   /*   
       * 1. ������ �̸� ����
       * 2. �̸� ���Ե� ���� �����ֱ�
       * 3. ��ȣ�� �Է¹ޱ�
       * 4. �� ��ȣ�� �ش��ϴ� ���� ����
      */ 
      System.out.println("������ ���� �̸�>>>");
         String sname = sc.nextLine();
         search(sname); 
       
      System.out.println("������ ���� ��ȣ>>>");
      int num = sc.nextInt();
      String sql1 = "DELETE FROM PLAYER WHERE NUM="+num;
            
      try {
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql1);
      } catch (SQLException e) {         
         e.printStackTrace();
      }
      
   }
   //5.������������
   private void playerUpdate() {
	   /*
	    * 1.������ ���� �̸� ����
	    * 2.�� ������ ���� �����ְ� (search)
	    * 3.���� ���� ��ȣ �Է� �ް�
	    * 4.������ �׸� �����
	    * 	1.�̸� 2.���� 3.Ű 4.������ 5.���� 6.����
	    * 5.�������� �����ϱ�
	    */
	   System.out.println("������ ���� �̸�>>");
	   String sname = sc.nextLine();
	   search(sname);
	   System.out.println("������ ���� ��ȣ>>");
	   int num = sc.nextInt();
	   System.out.println("���� �÷� 1.�̸� 2.���� 3.Ű 4.������ 5.����");
	   int changeNum = sc.nextInt();
	   String colName="";
	   switch(changeNum) {
	   case 1 :colName="name";break;
	   case 2 :colName="birth";break;
	   case 3 :colName="height";break;
	   case 4 :colName="weight";break;
	   case 5 :colName="kind";break;
	   }
	   sc.nextLine();
	   System.out.println("���� ���� >>");
	   String content = sc.nextLine();
	   //colName�� ������ content�� �ٲٱ�
	   String sql = "update player set " +colName+"='"+content+"'where num="+num;
	   try {
		   Statement st = con.createStatement();
		   st.executeUpdate(sql);
		  } catch (SQLException e) {
			  e.printStackTrace();
		  }
   
   }
   //6.����
   private void playerExit() {      
      System.out.println("����");
      System.exit(0);
   }
   
   //����ã�� ȣ��
   private void search(String sname) {      
      String sql = "SELECT * FROM PLAYER WHERE NAME LIKE '%"+sname+"%'";      
      Statement st;
      try {
         st=con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while(rs.next()) {
            System.out.println("��ȣ :"+rs.getInt("num"));
            System.out.println("�̸� :"+rs.getString("name"));
            System.out.println("���� :"+rs.getString("birth"));
            System.out.println("Ű :"+rs.getDouble("height"));
            System.out.println("������ :"+rs.getDouble("weight"));            
            System.out.println("���� :"+rs.getString("kind"));
            System.out.println();
         }         
         st.executeQuery(sql);         
      } catch (SQLException e) {         
         e.printStackTrace();         
      }   
   }
   

   public static void main(String[] args) {      
      PlayerMain pm = new PlayerMain();
      pm.dbUse();
   }

}