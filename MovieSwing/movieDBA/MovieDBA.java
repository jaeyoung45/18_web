package movieDBA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextField;

public class MovieDBA {
	String url, user, pwd;
	public MovieDBA() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "movieswing";
			pwd = "1234";
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Movie> AllView(){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Movie> arr = new ArrayList<>();
		try {
			String sql= "select * from movie order by year desc, month";
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Movie m = new Movie();
				m.setMnum(rs.getInt("m_num"));
				m.setDirector(rs.getString("director"));
				m.setTitle(rs.getString("TITLE"));
				m.setActor(rs.getString("actor"));
				m.setYear(rs.getString("year"));
				m.setMonth(rs.getString("month"));
				m.setRuntime(rs.getString("runtime"));
				m.setLimit(rs.getString("limit"));
				m.setGenre(rs.getString("genre"));
				m.setPoster(rs.getString("poster"));
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
	public ArrayList<Movie> movieTitleSearch(String title){

		Connection con = null;
		Statement st  = null;
		ResultSet rs = null;
		ArrayList<Movie> arr = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from movie where title like '%"+title+"%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Movie m = new Movie();
				m.setMnum(rs.getInt("m_num"));
				m.setDirector(rs.getString("director"));
				m.setTitle(rs.getString("TITLE"));
				m.setActor(rs.getString("actor"));
				m.setYear(rs.getString("year"));
				m.setMonth(rs.getString("month"));
				m.setRuntime(rs.getString("runtime"));
				m.setLimit(rs.getString("limit"));
				m.setGenre(rs.getString("genre"));
				m.setPoster(rs.getString("poster"));
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
	public ArrayList<Movie> movieYearSearch(Object year){

		Connection con = null;
		Statement st  = null;
		ResultSet rs = null;
		ArrayList<Movie> arr = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from movie where year = '"+year+"' order by month";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Movie m = new Movie();
				m.setMnum(rs.getInt("m_num"));
				m.setDirector(rs.getString("director"));
				m.setTitle(rs.getString("TITLE"));
				m.setActor(rs.getString("actor"));
				m.setYear(rs.getString("year"));
				m.setMonth(rs.getString("month"));
				m.setRuntime(rs.getString("runtime"));
				m.setLimit(rs.getString("limit"));
				m.setGenre(rs.getString("genre"));
				m.setPoster(rs.getString("poster"));
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

	public ArrayList<Movie> movieMonthSearch(Object year, Object month) {
		Connection con = null;
		Statement st  = null;
		ResultSet rs = null;
		ArrayList<Movie> arr = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from movie where year = '"+year+"' and month = '"+month+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Movie m = new Movie();
				m.setMnum(rs.getInt("m_num"));
				m.setDirector(rs.getString("director"));
				m.setTitle(rs.getString("TITLE"));
				m.setActor(rs.getString("actor"));
				m.setYear(rs.getString("year"));
				m.setMonth(rs.getString("month"));
				m.setRuntime(rs.getString("runtime"));
				m.setLimit(rs.getString("limit"));
				m.setGenre(rs.getString("genre"));
				m.setPoster(rs.getString("poster"));
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

	public ArrayList<Movie> movieGenreSearch(Object genre) {
		Connection con = null;
		Statement st  = null;
		ResultSet rs = null;
		ArrayList<Movie> arr = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from movie where genre = '"+genre+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Movie m = new Movie();
				m.setMnum(rs.getInt("m_num"));
				m.setDirector(rs.getString("director"));
				m.setTitle(rs.getString("TITLE"));
				m.setActor(rs.getString("actor"));
				m.setYear(rs.getString("year"));
				m.setMonth(rs.getString("month"));
				m.setRuntime(rs.getString("runtime"));
				m.setLimit(rs.getString("limit"));
				m.setGenre(rs.getString("genre"));
				m.setPoster(rs.getString("poster"));
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

	public Movie select(String title) {
		Connection con = null;
		Statement st  = null;
		ResultSet rs = null;
		Movie m = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from movie where title = '"+title+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				m = new Movie();
				m.setMnum(rs.getInt("m_num"));
				m.setDirector(rs.getString("director"));
				m.setTitle(rs.getString("TITLE"));
				m.setActor(rs.getString("actor"));
				m.setYear(rs.getString("year"));
				m.setMonth(rs.getString("month"));
				m.setRuntime(rs.getString("runtime"));
				m.setLimit(rs.getString("limit"));
				m.setGenre(rs.getString("genre"));
				m.setPoster(rs.getString("poster"));

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
		return m;
	}

	public boolean scoreView(String m_num, String id) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String sql = "select score From memberaction where m_num ='"+m_num+"' and num = (select num from memberinfo where id ='"+id+"')";
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				if(rs.getString("score") != null) {//title에서 가져온 값이 null이 아니면 true 반환
					return false;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(con!=null)con.close();
			if(st!=null)st.close();
			if(rs!=null)rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return true;//중복하지 않고 그냥 나왔을 때는 false 반환
		
	}
}
