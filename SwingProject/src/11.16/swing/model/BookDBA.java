package swing.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDBA {
   
   Connection con;
   PreparedStatement ps;
   String url, user, pwd ; 
   //디비셋팅
   public BookDBA() {      
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
   public void bookInsert(BookBean b) {     
         
         try {               
         String sql ="insert into Book values(Book_seq.nextval,?,?,?,?,?,?)";
         ps = con.prepareStatement(sql);
         ps.setString(1, b.getTitle());
         ps.setString(2, b.getWriter());         
         ps.setString(3, b.getIndate());
         ps.setString(4, b.getOutdate());
         ps.setString(5, b.getGubun());
         ps.setInt(6, b.getPrice());         
         ps.executeUpdate();
         
         } catch (SQLException e) {            
            e.printStackTrace();          
         }               
   }
   
   //보기   
   public ArrayList<BookBean> bookView(){
      Connection con = null;
         Statement st = null;
         ResultSet rs =null;
         ArrayList<BookBean> arr = new ArrayList<>();      
         try {
         con = DriverManager.getConnection(url, user, pwd);
         String sql = "select * from Book";
         st = con.createStatement();
         rs = st.executeQuery(sql);
         while(rs.next()) {
            BookBean b = new BookBean();
            b.setNum(rs.getInt("num"));
            b.setTitle(rs.getString("title"));
            b.setWriter(rs.getString("writer"));
            b.setIndate(rs.getString("indate"));
            b.setOutdate(rs.getString("outdate"));
            b.setGubun(rs.getString("gubun"));
            b.setPrice(rs.getInt("price"));            
            arr.add(b);
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
   public void bookDelete(int num) {
      Connection con;
         Statement st;      
         try {
            con = DriverManager.getConnection(url, user, pwd);
            String sql = "DELETE FROM BOOK WHERE NUM="+num;
            st = con.createStatement();
            st.executeQuery(sql);
      } catch (SQLException e) {
         e.printStackTrace();
      
         }
//         return null;
      }

   //수정
   public void bookUpdate(BookBean b) {
      Connection con;
       PreparedStatement ps;       
         try {      
         con = DriverManager.getConnection(url, user, pwd);
         String sql ="UPDATE BOOK SET TITLE=?,WRITER=?,INDATE=?,OUTDATE=?,GUBUN=?,PRICE=? WHERE NUM=?";
         ps = con.prepareStatement(sql);
         ps.setString(1, b.getTitle());
         ps.setString(2, b.getWriter());         
         ps.setString(3, b.getIndate());      
         ps.setString(4, b.getOutdate());   
         ps.setString(5, b.getGubun());   
         ps.setInt(6, b.getPrice());
         ps.setInt(7, b.getNum());
         ps.executeUpdate();         
         } catch (SQLException e) {            
            e.printStackTrace();         
         }         
   }
}