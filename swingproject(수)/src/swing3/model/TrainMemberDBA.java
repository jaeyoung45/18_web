package swing3.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainMemberDBA {
   
   Connection con;
   PreparedStatement ps;
   String url, user, pwd ; 
   ResultSet rs;
   //디비셋팅
   public TrainMemberDBA() {      
         try {
               Class.forName("oracle.jdbc.driver.OracleDriver");
               url="jdbc:oracle:thin:@localhost:1521:xe";
               user = "scott";
               pwd = "TIGER";       
               con = DriverManager.getConnection(url, user, pwd);
               } catch (ClassNotFoundException | SQLException e) {            
                  e.printStackTrace();         
               }
         }
   
   //입력하기
   public void TrainuserInsert(TrainMember m) {     
         
         try {               
         String sql ="insert into Trainuser values(?,?,?,?,trainuser_seq.nextval)";
         ps = con.prepareStatement(sql);
         ps.setString(1, m.getID());         
         ps.setString(2, m.getPW());
         ps.setString(3, m.getName());
         ps.setString(4, m.getPhonenum());
         ps.executeUpdate();
         
         } catch (SQLException e) {            
            e.printStackTrace();          
         }               
   }
 //보기
   public String login (String id, String pwd){
       String str="";
       try {
       String sql ="select pwd,id from trainuser where id=?";
       ps = con.prepareStatement(sql);
       ps.setString(1, id);
       rs = ps.executeQuery();   
       if(rs.next()) { //회원이다
          if(rs.getString("pwd").equals(pwd)) {// 비번 맞음
             str=rs.getString("ID");
          }else {
             str="비번오류";//비번오류
          }
          
       }
       
    } catch (SQLException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
    }
    return str;
       
    }
}