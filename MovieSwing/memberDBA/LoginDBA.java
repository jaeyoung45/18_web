package memberDBA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import movieSwing.MovieSwingLogin;

public class LoginDBA {
	private String url, user, pwd;

	public LoginDBA() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "movieswing";
			pwd = "1234";
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean Login(String id, String pass) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String sql = "select * from memberinfo where id= '"+id+"'";
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				if(rs.getString("pwd").equals(pass)) {
					return true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
