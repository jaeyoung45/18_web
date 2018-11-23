package memberDBA;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class UpdateDBA {
	String url, user, pwd;
	public UpdateDBA() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "movieswing";
			pwd = "1234";
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Member> updateView(String id){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Member> arr = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from MemberInfo where id= '"+id+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Member m = new Member();
				m.setNum(rs.getInt("num"));
				m.setName(rs.getString("name"));
				m.setBirth(rs.getString("birth"));
				m.setAddr(rs.getString("addr"));
				m.setEmail(rs.getString("email"));
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
	public void updateInfo(Member m) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "update memberinfo set pwd = ?, name = ? , birth = ?, addr = ?, Email = ? where id = '"+m.getId()+"'";
			ps = con.prepareStatement(sql);
			ps.setString(1, String.valueOf(m.getPwd()));
			ps.setString(2, m.getName());
			ps.setString(3, m.getBirth());
			ps.setString(4, m.getAddr());
			ps.setString(5, m.getEmail());
			ps.executeQuery();
			JOptionPane.showMessageDialog(null, "정보가 수정되었습니다.");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "비밀번호는 필수 입력입니다.");
		}finally {
			try {
			if(con != null)con.close();
			if(ps != null)ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void deleteUser(String id) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "delete from memberinfo where id = '"+id+"'";
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
	public void deleteUserAction(String id) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql =  "delete from memberaction where num =( " + 
					"select mi.num " + 
					"from memberaction ma, memberinfo mi, movie m " + 
					"where ma.num = mi.num and ma.m_num = m.m_num and id = '"+id+"'" + 
					")";
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
	public void deleteRe(String re) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql =  "delete from memberaction where re = '"+re+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			JOptionPane.showMessageDialog(null, "후기가 삭제되었습니다.");
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
