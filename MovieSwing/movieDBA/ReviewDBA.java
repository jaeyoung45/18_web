package movieDBA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import memberDBA.Member;

public class ReviewDBA {
	String url, user, pwd;

	public ReviewDBA() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "movieswing";
			pwd = "1234";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void upLoadReview(Member member, Movie movie) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql =
		"insert into memberaction values"
		+ "((select num from memberinfo where id ='"+member.getId()+"'), "+movie.getMnum()+" , '"+movie.getReply()+"' ,'"+movie.getScore()+"', sysdate)";
			st = con.createStatement();
			rs = st.executeQuery(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(con != null)con.close();
			if(st != null)st.close();
			if(rs != null)rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Movie> showReview(String m_num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Movie> arr = new ArrayList<>();
		try {
			String sql= "select * from memberaction, memberinfo, movie "
					+ "where memberaction.num = memberinfo.num and memberaction.m_num = movie.m_num and movie.m_num ='"+m_num+"' order by time ";
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getString("id"));
				m.setReply(rs.getString("re"));
				m.setScore(rs.getDouble("score"));
				m.setDate(rs.getString("time"));
				arr.add(m);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(con != null)con.close();
			if(st != null)st.close();
			if(rs != null)rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return arr;
	}
	public double showAvg(String m_num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		double avg = 0;
		try {
			String sql= "select avg(score) from memberaction where M_num ="+m_num;
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				avg = (Math.round(rs.getDouble("avg(score)")*100))/100.0;
				//.0을 붙여줘야 실수로 나오게 된다.
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(con != null)con.close();
			if(st != null)st.close();
			if(rs != null)rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return avg;
	}
	public int showCnt(String m_num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			String sql= "select count(num) from memberaction where M_num ="+m_num;
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				cnt = rs.getInt("count(num)");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(con != null)con.close();
			if(st != null)st.close();
			if(rs != null)rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	public void upLoadReply(Member member, Movie movie) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql =
		"insert into memberaction(num , m_num , re , time) values"
		+ "((select num from memberinfo where id ='"+member.getId()+"'), "+movie.getMnum()+" , '"+movie.getReply()+"', sysdate)";
			st = con.createStatement();
			rs = st.executeQuery(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(con != null)con.close();
			if(st != null)st.close();
			if(rs != null)rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public ArrayList<Movie> reAllView(String m_num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Movie> arr = new ArrayList<>();
		try {
			String sql= "select mi.id, re, score, time\r\n" + 
					"from memberaction ma, memberinfo mi, movie m\r\n" + 
					"where ma.m_num=m.m_num and mi.num=ma.num and m.m_num = "+m_num;
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Movie mov = new Movie();

				mov.setId(rs.getString("id"));
				mov.setReply(rs.getString("re"));
				mov.setScore(rs.getDouble("score"));
				mov.setDate(rs.getString("time"));
				arr.add(mov);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();

		}finally {
			try {
			if(con != null)con.close();
			if(st != null)st.close();
			if(rs != null)rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return arr;
		
	}


}
