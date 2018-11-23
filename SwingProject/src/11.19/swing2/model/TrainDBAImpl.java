package swing2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import swing2.view.Train;

public class TrainDBAImpl implements TrainDBA{
	Connection con;
	PreparedStatement ps;
	String url, user, pwd;
	//디비셋팅
	public TrainDBAImpl() {
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

	//추가   
	   @Override
	   public void trainInsert(Train t) {     
	         
	         try {               
	         String sql ="insert into train values(train_seq.nextval,?,?,?)";
	         ps = con.prepareStatement(sql);
	         ps.setString(1, t.getDeprt());         
	         ps.setString(2, t.getArrival());
	         ps.setString(3, t.getDay());
	         ps.executeUpdate();
	         
	         } catch (SQLException e) {            
	            e.printStackTrace();          
	         }               
	   }

	public ArrayList<Train> TrainSearch(String str) {
		        Statement st = null;
		         ResultSet rs =null;
		         ArrayList<Train> arr = new ArrayList<>();  
		         
		         try {         
		            st = con.createStatement();
		            String sql = "SELECT * FROM train WHERE "+str+" like '%"+word+"%'";
		         
		         rs = st.executeQuery(sql);
		         while(rs.next()) {
		        	Train t = new Train();
		            t.setNum(rs.getInt("num"));
		            t.setDeprt(rs.getString("deprt"));
		            t.setArrival(rs.getString("arrival"));
		            t.setDay(rs.getString("day"));
		            
		            arr.add(t);
		         }      
		         }catch (SQLException e) {
		            e.printStackTrace();
		         }
		      return arr;
		   }

}


