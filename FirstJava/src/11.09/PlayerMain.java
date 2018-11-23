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
   
   //메뉴보여주기 : 1.선수등록, 2.선수보기, 3.선수찾기, 4.선수삭제 5.종료  
   public void dbUse() {
      while(true) {
         System.out.println("1.선수등록 2.선수보기 3.선수찾기 4.선수삭제, 5.선수정보수정, 6.종료");
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
            System.out.println("입력오류");
         }         
      }
   }   

   
   //1.선수등록
   private void playerInsert() {   //이름, 생일, 키, 몸무게, 종목   
      System.out.println("이름>>");
      String name = sc.nextLine();
      System.out.println("생일>>");
      String birth = sc.nextLine();
      System.out.println("키>>");
      double height = sc.nextDouble();
      System.out.println("몸무게>>");
      double weight = sc.nextDouble();
      sc.nextLine(); //몸무게 입력후 생긴 엔터 처리
      System.out.println("종목>>");
      String kind = sc.nextLine();
      //db테이블에 입력
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
   
   //2.선수보기
   private void playerView() {      
      String sql = "SELECT * FROM PLAYER";
      Statement st;
      try {
         st=con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while(rs.next()) {
            System.out.println("번호 :"+rs.getInt("num"));
            System.out.println("이름 :"+rs.getString("name"));
            System.out.println("생일 :"+rs.getString("birth"));
            System.out.println("키 :"+rs.getDouble("height"));
            System.out.println("몸무게 :"+rs.getDouble("weight"));            
            System.out.println("종목 :"+rs.getString("kind"));
            System.out.println();
         }
         st.executeQuery(sql);
      } catch (SQLException e) {         
         e.printStackTrace();
      }      
   }
   
   //3.선수 찾기
   private void playerSearch() {
      System.out.println("찾을 선수 이름>>>");
      String sname = sc.nextLine();
      search(sname);      
   }
   //4.선수삭제
   private void playerRemove() {
      
   /*   
       * 1. 삭제할 이름 묻기
       * 2. 이름 포함된 내용 보여주기
       * 3. 번호를 입력받기
       * 4. 그 번호에 해당하는 선수 삭제
      */ 
      System.out.println("삭제할 선수 이름>>>");
         String sname = sc.nextLine();
         search(sname); 
       
      System.out.println("삭제할 선수 번호>>>");
      int num = sc.nextInt();
      String sql1 = "DELETE FROM PLAYER WHERE NUM="+num;
            
      try {
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql1);
      } catch (SQLException e) {         
         e.printStackTrace();
      }
      
   }
   //5.선수정보수정
   private void playerUpdate() {
	   /*
	    * 1.수정할 선수 이름 묻고
	    * 2.그 선수들 정보 보여주고 (search)
	    * 3.수정 선수 번호 입력 받고
	    * 4.수정할 항목 물어보기
	    * 	1.이름 2.생일 3.키 4.몸무게 5.종목 6.종료
	    * 5.수정내용 수정하기
	    */
	   System.out.println("수정할 선수 이름>>");
	   String sname = sc.nextLine();
	   search(sname);
	   System.out.println("수정할 선수 번호>>");
	   int num = sc.nextInt();
	   System.out.println("수정 컬럼 1.이름 2.생일 3.키 4.몸무게 5.종목");
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
	   System.out.println("수정 내용 >>");
	   String content = sc.nextLine();
	   //colName의 내용을 content로 바꾸기
	   String sql = "update player set " +colName+"='"+content+"'where num="+num;
	   try {
		   Statement st = con.createStatement();
		   st.executeUpdate(sql);
		  } catch (SQLException e) {
			  e.printStackTrace();
		  }
   
   }
   //6.종료
   private void playerExit() {      
      System.out.println("종료");
      System.exit(0);
   }
   
   //선수찾기 호출
   private void search(String sname) {      
      String sql = "SELECT * FROM PLAYER WHERE NAME LIKE '%"+sname+"%'";      
      Statement st;
      try {
         st=con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while(rs.next()) {
            System.out.println("번호 :"+rs.getInt("num"));
            System.out.println("이름 :"+rs.getString("name"));
            System.out.println("생일 :"+rs.getString("birth"));
            System.out.println("키 :"+rs.getDouble("height"));
            System.out.println("몸무게 :"+rs.getDouble("weight"));            
            System.out.println("종목 :"+rs.getString("kind"));
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