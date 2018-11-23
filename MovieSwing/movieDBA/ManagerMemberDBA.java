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

public class ManagerMemberDBA {
	String url, user, pwd;
	public ManagerMemberDBA() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "movieswing";
			pwd = "1234";
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Member> viewAll(){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Member> arr = new ArrayList<>();
		try {
			String sql = "select * from memberinfo order by num desc";
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Member m = new Member();
				m.setNum(rs.getInt("num"));
				m.setId(rs.getString("id"));
				m.setGrade(rs.getString("grade"));
				m.setName(rs.getString("name"));
				m.setGender(rs.getString("gender"));
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
	public ArrayList<Member> userInfo(Object info, String tfSearch) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Member> arr = new ArrayList<>();
		try {
			String sql = "select * from memberinfo where "+info+" like '%"+tfSearch+"%'";
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Member m = new Member();
				m.setNum(rs.getInt("num"));
				m.setId(rs.getString("id"));
				m.setGrade(rs.getString("grade"));
				m.setName(rs.getString("name"));
				m.setGender(rs.getString("gender"));
				m.setBirth(rs.getString("birth"));
				m.setAddr(rs.getString("addr"));
				m.setEmail(rs.getString("email"));
				arr.add(m);
			}
		}catch(SQLException e) {
			
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
	public ArrayList<Movie> userViewMovie(Object num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Movie> arr = new ArrayList<>();
		try {
			String sql = "select distinct(title) " + 
					" from memberaction ma, memberinfo mi, movie m " + 
					" where ma.num = mi.num and ma.m_num = m.m_num and mi.num = '"+num+"'";
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Movie m = new Movie();
				m.setTitle(rs.getString("title"));
				arr.add(m);
			}
		}catch(SQLException e) {	
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
	public ArrayList<Movie> userAction(String num, String title) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Movie> arr = new ArrayList<>();
		try {
			String sql = "select re,score,time " + 
					"from memberaction ma, memberinfo mi, movie m " + 
					"where ma.num = mi.num and ma.m_num = m.m_num and mi.num = '"+num+"' and title = '"+title+"'";
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Movie m = new Movie();
				m.setReply(rs.getString("re"));
				m.setScore(rs.getDouble("score"));
				m.setDate(rs.getString("time"));
				arr.add(m);
			}
		}catch(SQLException e) {
			
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
	public String userActionCount(String num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String count = null;
		try {
			String sql = "select count(time) " + 
					" from memberaction ma, memberinfo mi, movie m " + 
					" where ma.num = mi.num and ma.m_num = m.m_num and mi.num ="+num;
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
			count = rs.getString("count(time)");
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
		return count;
	}
	public void updateGrade(Object grade, String num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String sql = "update memberinfo set grade = '"+grade+"' where num = '"+num+"'";
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			JOptionPane.showMessageDialog(null, "등급이 조정되었습니다.");
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
	public void userUpdate(Member m) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			String sql = "update memberinfo set id = ?, grade =?, name=?, gender = ?, birth = ? , addr=? where num = '"+m.getNum()+"'";
			con = DriverManager.getConnection(url, user, pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getId());
			ps.setString(2, m.getGrade());
			ps.setString(3, m.getName());
			ps.setString(4, m.getGender());
			ps.setString(5, m.getBirth());
			ps.setString(6, m.getAddr());
			ps.executeQuery();
			JOptionPane.showMessageDialog(null, "회원정보가 수정되었습니다.");
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

	public ArrayList<Member> userActionSearch(int index, String tfSearch) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<Member> arr = new ArrayList<>();
		try {
		if(index ==0) {
			sql = "select *\r\n" + 
					"from(\r\n" + 
					"select mi.num,mi.id,mi.grade,mi.birth,mi.addr,mi.email,mi.name,count(time) cnt\r\n" + 
					"from memberaction ma, memberinfo mi, movie m\r\n" + 
					"where ma.num = mi.num and ma.m_num = m.m_num \r\n" + 
					"group by mi.num,mi.id,mi.grade,mi.birth,mi.addr,mi.email,mi.name\r\n" + 
					")\r\n" + 
					"where cnt > '"+tfSearch+"'";
		}
		if(index==1) {
			sql = "select * from memberinfo where grade ='"+tfSearch+"'";
		}
		con = DriverManager.getConnection(url, user, pwd);
		st = con.createStatement();
		rs = st.executeQuery(sql);
		while(rs.next()) {
			Member m = new Member();
			m.setNum(rs.getInt("num"));
			m.setId(rs.getString("id"));
			m.setGrade(rs.getString("grade"));
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
}
