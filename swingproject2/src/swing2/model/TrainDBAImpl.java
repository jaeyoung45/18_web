package swing2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import swing2.util.ConnectionUtil;
import swing2.view.Train;

public class TrainDBAImpl implements TrainDBA {

	ConnectionUtil cu;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public TrainDBAImpl() {
		cu = new ConnectionUtil();
	}
	
	// 목록
	public ArrayList<Train> list() {
		return null;
	}

	// 검색
	public ArrayList<Train> search(String strType, String strValue) {

		ArrayList<Train> arr = new ArrayList<>();

		try {
			con = cu.getConnection();
			String sql = " SELECT * FROM train WHERE " + strType + " like '%"
					+ strValue + "%' ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Train t = new Train();
				t.setNum(rs.getInt("num"));
				t.setDeprt(rs.getString("deprt"));
				t.setArrival(rs.getString("arrival"));
				t.setDay(rs.getString("day"));
				arr.add(t);
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		return arr;

	}

	// 등록
	public int insert(Train t) {

		try {
			String sql = " insert into train values (train_seq.nextval, ?, ?, ?) ";
			con = cu.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, t.getDeprt());
			ps.setString(2, t.getArrival());
			ps.setString(3, t.getDay());

			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (con != null) {
				cu.returnConnection(con);
			}
		}
	}
	
	// 수정
	public int update(Train t) {
		   	  Connection con=null;
		      PreparedStatement ps=null;
		      try {      
		      con = DriverManager.getConnection(url, user, pwd);
		      String sql ="update friend set name=?, birth=?, phone=?, addr=? where num=?";
		      ps = con.prepareStatement(sql);
		      ps.setString(1, t.getDepart());
		      ps.setString(2, t.getArrival());
		      ps.setString(3, t.getPerson());
		      ps.setString(4, t.getTraintype());;
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
 }
	}
	
	// 삭제
	public int delete(int num) {
		return 0;
	}

}
