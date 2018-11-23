package memberDBA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterDBA {
	String url, user, pwd;
	
	public RegisterDBA() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "movieswing";
			pwd = "1234";
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void memberInsert(Member m) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into memberinfo values(memnum_seq.nextval,?,?,?,?,?,?,?,?)";
			con = DriverManager.getConnection(url, user, pwd);
			ps= con.prepareStatement(sql);
			ps.setString(1, m.getId());
			ps.setString(2, String.valueOf(m.getPwd()));
			ps.setString(3, m.getGender());
			ps.setString(4, m.getBirth());
			ps.setString(5, m.getAddr());
			ps.setString(6, m.getEmail());
			ps.setString(7, m.getName());
			ps.setString(8, "관람객");
			ps.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			if(con!=null)con.close();
			if(ps!=null)ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean idCheck(String id) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String sql = "select id From memberinfo";
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				if(rs.getString("id").equals(id)) {//리절트셋에서 아이디가 중복하면 true 반환
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
}
