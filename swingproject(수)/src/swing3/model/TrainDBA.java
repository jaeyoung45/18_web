package swing3.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TrainDBA {
   
   Connection con;
   PreparedStatement ps;
   String url, user, pwd ; 
   //디비셋팅
   public TrainDBA() {      
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
   public void TrainInsert(TrainBean t) {     
         
         try {               
         String sql ="insert into Train values(train_seq.nextval,?,?,?,?)";
         ps = con.prepareStatement(sql);
         ps.setString(1, t.getDepart());
         ps.setString(2, t.getArrival());         
         ps.setString(3, t.getPerson());
         ps.setString(4, t.getTraintype());
         ps.executeUpdate();
         
         } catch (SQLException e) {            
            e.printStackTrace();          
         }               
   }
   
   //보기   
   public ArrayList<TrainBean> trainView(){
      Connection con = null;
         Statement st = null;
         ResultSet rs =null;
         ArrayList<TrainBean> arr = new ArrayList<>();      
         try {
         con = DriverManager.getConnection(url, user, pwd);
         String sql = "select * from train";
         st = con.createStatement();
         rs = st.executeQuery(sql);
         while(rs.next()) {
            TrainBean t = new TrainBean();
            t.setNum(rs.getInt("num"));
            t.setDepart(rs.getString("depart"));
            t.setArrival(rs.getString("arrival"));
            t.setPerson(rs.getString("person"));
            t.setTraintype(rs.getString("traintype"));           
            arr.add(t);
         }      
         }catch (SQLException e) {
            e.printStackTrace();      
         }finally{
         try {
            if(rs!=null)rs.close();
            if(st!=null)st.close();
            if(con!=null)con.close();      
         
         }catch (Exception e) {
            e.printStackTrace();      
         }
         }
         return arr;   
   }
   
   //삭제하기
   public void trainDelete(int num) {
      Connection con;
         Statement st;      
         try {
            con = DriverManager.getConnection(url, user, pwd);
            String sql = "delete from train where num="+num;
            st = con.createStatement();
            st.executeQuery(sql);
      } catch (SQLException e) {
         e.printStackTrace();
      
         }
      }

   //수정
   public void trainUpdate(TrainBean b) {
      Connection con;
       PreparedStatement ps;       
         try {      
         con = DriverManager.getConnection(url, user, pwd);
         String sql ="UPDATE train set depart=?, arrival=?, person=?, traintype=? where num=?";
         ps = con.prepareStatement(sql); 
         ps.setString(1, b.getDepart());
         ps.setString(2, b.getArrival());         
         ps.setString(3, b.getPerson());      
         ps.setString(4, b.getTraintype());
         ps.setInt(5, b.getNum());   
         ps.executeUpdate();        
         } catch (SQLException e) {            
            e.printStackTrace();         
         }         
   }

public String login(String text, String text2) {
	// TODO Auto-generated method stub
	return null;
}
}