package movieDBA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ManagerUpdateDBA {
	String url, user, pwd;
	public ManagerUpdateDBA() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "movieswing";
			pwd = "1234";
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void updateMovie(Movie m) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "update movie set title = ?, director = ?, year = ?, month = ?, runtime = ?, genre = ?, limit = ? , poster = ? where m_num="+m.getMnum();
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getTitle());
			ps.setString(2, m.getDirector());
			ps.setString(3, m.getYear());
			ps.setString(4, m.getMonth());
			ps.setString(5, m.getRuntime());
			ps.setString(6, m.getGenre());
			ps.setString(7, m.getLimit());
			ps.setString(8, m.getPoster());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, m.getTitle()+" 수정되었습니다.");
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
	public void movieDelete(String m_num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "delete from movie where m_num = '"+m_num+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			JOptionPane.showMessageDialog(null, "영화가 삭제 되었습니다.");
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
			if(con != null)con.close();
			if(st != null)st.close();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
