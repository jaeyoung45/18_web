package chap09.player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlayerDBA {
   String url, user, pwd;
   //생성자에서 디비 셋팅
   public PlayerDBA() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
          url="jdbc:oracle:thin:@localhost:1521:xe";
          user = "scott";
          pwd = "TIGER";         
         } catch (ClassNotFoundException e) {            
            e.printStackTrace();         
         }
   }
   
   //추가
   public void PlayerInsert(Player p) {
      Connection con=null;
      PreparedStatement ps=null;
      try {      
      con = DriverManager.getConnection(url, user, pwd);
      String sql ="insert into player values(player_seq.nextval,?,?,?,?,?)";
      ps = con.prepareStatement(sql);
      ps.setString(1, p.getName());
      ps.setString(2, p.getBirth());
      ps.setDouble(3, p.getHeight());
      ps.setDouble(4, p.getWeight());
      ps.setString(5, p.getKind());
      ps.executeUpdate();
      
      } catch (SQLException e) {            
         e.printStackTrace();         
      }finally {
      try {
            if(ps!=null) ps.close();
            if(con!=null) con.close();
      } catch (SQLException e) {            
            e.printStackTrace();
      }         
      }      
   }
      
   //수정
   public void PlayerUpdate() {
      
   }
   
   //삭제
   public void PlayerDelete() {
      
   }
   
   //전체보기
   public ArrayList<Player> PlayerView() {
      
      Connection con = null;
      Statement st = null;
      ResultSet rs =null;
      ArrayList<Player> arr = new ArrayList<>();
      
      try {
      con = DriverManager.getConnection(url, user, pwd);
      String sql = "select * from player";
      st = con.createStatement();
      rs = st.executeQuery(sql);
      while(rs.next()) {
         Player p = new Player();
         p.setNum(rs.getInt("num"));
         p.setName(rs.getString("name"));
         p.setBirth(rs.getString("birth"));
         p.setHeight(rs.getDouble("height"));
         p.setWeight(rs.getDouble("weight"));
         p.setKind(rs.getString("kind"));
         arr.add(p);
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

   //검색
   public ArrayList<Player> PlayerSearch(String key, String stxt) {
      Connection con=null;
      Statement st=null;
      ResultSet rs=null;
      ArrayList<Player> arr = new ArrayList<>();
      
      try {
         con=DriverManager.getConnection(url, user, pwd);
         String sql = "SELECT * FROM PLAYER WHERE "+key+" like '%"+stxt+"%'";
         
         st=con.createStatement();
         rs=st.executeQuery(sql);
         while(rs.next()) {
            Player p = new Player();
            p.setNum(rs.getInt("num"));
            p.setName(rs.getString("name"));
            p.setBirth(rs.getString("birth"));
            p.setHeight(rs.getDouble("height"));
            p.setWeight(rs.getDouble("weight"));
            p.setKind(rs.getString("kind"));
            arr.add(p);
         }
         } catch (SQLException e) {         
         e.printStackTrace();
      }finally {
         try {
            if(rs!=null)rs.close();
            if(st!=null)st.close();
            if(con!=null)con.close();   
         } catch (Exception e) {
            e.printStackTrace();
         }
      }      
      return arr;
   }
}