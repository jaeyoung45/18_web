package FriendWrite;
import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;



	public class FriendDBA {
	   Connection con;
	   PreparedStatement ps;
	   String url, user, pwd ; 
	   //디비셋팅
	   public FriendDBA() {      
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
	   
	   
	   //친구추가   
	   public void friendInsert(Friend f) {     
	         
	         try {               
	         String sql ="insert into friend values(friend_seq.nextval,?,?,?,?)";
	         ps = con.prepareStatement(sql);
	         ps.setString(1, f.getName());
	         ps.setString(2, f.getBirth());         
	         ps.setString(3, f.getPhone());
	         ps.setString(4, f.getAddr());
	         ps.executeUpdate();
	         
	         } catch (SQLException e) {            
	            e.printStackTrace();          
	         }               
	   }

	   //친구전체보기
	   public ArrayList<Friend> friendView() {   
		      Connection con = null;
		         Statement st = null;
		         ResultSet rs =null;
		         ArrayList<Friend> arr = new ArrayList<>();      
		         try {
		         con = DriverManager.getConnection(url, user, pwd);
		         String sql = "select * from friend";
		         st = con.createStatement();
		         rs = st.executeQuery(sql);
		         while(rs.next()) {
		            Friend f = new Friend();
		            f.setNum(rs.getInt("num"));
		            f.setName(rs.getString("name"));
		            f.setBirth(rs.getString("birth"));
		            f.setPhone(rs.getString("Phone"));
		            f.setAddr(rs.getString("addr"));
		            
		            arr.add(f);
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
	   
	   //친구검색
	   public ArrayList<Friend> friendSearch(String str, String word) {
	        Statement st = null;
	         ResultSet rs =null;
	         ArrayList<Friend> arr = new ArrayList<>();  
	         
	         try {         
	            st = con.createStatement();
	            String sql = "SELECT * FROM friend WHERE "+str+" like '%"+word+"%'";
	         
	         rs = st.executeQuery(sql);
	         while(rs.next()) {
	            Friend f = new Friend();
	            f.setNum(rs.getInt("num"));
	            f.setName(rs.getString("name"));
	            f.setBirth(rs.getString("birth"));
	            f.setPhone(rs.getString("phone"));
	            f.setAddr(rs.getString("addr"));
	            
	            arr.add(f);
	         }      
	         }catch (SQLException e) {
	            e.printStackTrace();
	         }
	      return arr;
	   }
	   //상세보기
	   public Friend friendSelect(int num) {
		   Connection con = null;
		   Statement st = null;
		   ResultSet rs = null;
		   Friend f = null;
		   try {
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			String sql = "select * from friend where num="+num;
			rs = st.executeQuery(sql);
			while(rs.next()) {
				f = new Friend();
	            f.setNum(rs.getInt(1)); //f.setNum(rs.getInt("num"));
	            f.setName(rs.getString("name"));
	            f.setBirth(rs.getString("birth"));
	            f.setPhone(rs.getString("phone"));
	            f.setAddr(rs.getString("addr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		   return f;
	   }

}