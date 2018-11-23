package movieDBA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class UploadDBA {
	String url,user,pwd;
	
	public UploadDBA() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "movieswing";
			pwd = "1234";
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void Upload(Movie movie) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into movie values(movie_seq.nextval,?,?,?,?,?,?,?,?,?)";
			con = DriverManager.getConnection(url, user, pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, movie.getTitle());
			ps.setString(2, movie.getDirector());
			ps.setString(3, movie.getActor());
			ps.setString(4, movie.getYear());
			ps.setString(5, movie.getMonth());
			ps.setString(6, movie.getRuntime());
			ps.setString(7, movie.getGenre());
			ps.setString(8, movie.getLimit());
			ps.setString(9, movie.getPoster());
			ps.executeQuery();
			JOptionPane.showMessageDialog(null, movie.getTitle()+" 추가 되었습니다.");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(con != null)con.close();
			if(ps != null)ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean titleCheck(String title) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String sql = "select title From movie where title like '%"+title+"%'";
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				if(rs.getString("title") != null) {//title에서 가져온 값이 null이 아니면 true 반환
					return true;
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
		return false;//중복하지 않고 그냥 나왔을 때는 false 반환
	}

	public String titleAlert(String inputtitle) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String title = null;
		try {
			String sql = "select title From movie where title like '%"+inputtitle+"%'";
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
			title = rs.getString("title");//리절트셋에서 아이디가 중복하면 true 반환
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
		return title;//중복하지 않고 그냥 나왔을 때는 false 반환
	}

}
