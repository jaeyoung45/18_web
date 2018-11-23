package movieDBA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

public class ManagerCountDBA {
	String url, user, pwd;
	public ManagerCountDBA() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "movieswing";
			pwd = "1234";
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int ViewPeopleCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select count(num) from memberinfo";
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

	public int GenderCount(String gender) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select count(num) from memberinfo where gender = '"+gender+"'";
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

	public int ViewGenderCount(String gender, int m_num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select count(distinct(memberinfo.id)) from memberaction, memberinfo, movie "
					+ "where memberaction.num = memberinfo.num and memberaction.m_num = movie.m_num "
					+ "and movie.m_num ="+m_num+ "and gender = '"+gender+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				cnt = rs.getInt("count(distinct(memberinfo.id))");
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

	public String maxScoreMovie(Object year) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String title = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select title\r\n" + 
					"from( " + 
					"select title , avg(score) " + 
					"from memberaction ma, memberinfo mi, movie m " + 
					"where ma.num = mi.num and ma.m_num = m.m_num  and year = '"+year+"' " + 
					"group by title " + 
					"order by avg(score) desc " + 
					") " + 
					"where rownum = 1";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				title = rs.getString("title");
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
		return title;
	}
	
	public String minScoreMovie(Object year) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String title = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select title\r\n" + 
					"from( " + 
					"select title , avg(score) " + 
					"from memberaction ma, memberinfo mi, movie m " + 
					"where ma.num = mi.num and ma.m_num = m.m_num  and year = '"+year+"' " + 
					"group by title " + 
					"order by avg(score) " + 
					") " + 
					"where rownum = 1";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				title = rs.getString("title");
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
		return title;
	}

	public String maxScoreMovieMonth(Object year, JComboBox cbMonth_1 ) {
		Connection con = null;
		Statement st = null;
		String month = null;
		ResultSet rs = null;
		String[] mon = { "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
		if(cbMonth_1.getSelectedIndex()==0) {
			month = null; 
		}else {
			month = mon[cbMonth_1.getSelectedIndex()-1];
		}
		String title = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select title\r\n" + 
					"from( " + 
					"select title , avg(score) " + 
					"from memberaction ma, memberinfo mi, movie m " + 
					"where ma.num = mi.num and ma.m_num = m.m_num  and year = '"+year+"' and month = '"+month+"'" + 
					"group by title " + 
					"order by avg(score) desc " + 
					") " + 
					"where rownum = 1";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				title = rs.getString("title");
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
		return title;
	}
	public String minScoreMovieMonth(Object year, JComboBox cbMonth_1) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String month = null;
		String[] mon = { "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
		if(cbMonth_1.getSelectedIndex()==0) {
			month = null; 
		}else {
			month = mon[cbMonth_1.getSelectedIndex()-1];
		}
		String title = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select title\r\n" + 
					"from( " + 
					"select title , avg(score) " + 
					"from memberaction ma, memberinfo mi, movie m " + 
					"where ma.num = mi.num and ma.m_num = m.m_num  and year = '"+year+"' and month = '"+month+"'" + 
					"group by title " + 
					"order by avg(score) " + 
					") " + 
					"where rownum = 1";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				title = rs.getString("title");
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
		return title;
	}

	public String maxPopulaMovie(Object year) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String title = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select title " + 
					"from( " + 
					"select title, count(re) " + 
					"from memberaction ma, memberinfo mi, movie m " + 
					"where ma.num = mi.num and ma.m_num = m.m_num  and year = '"+year+"' " + 
					"group by title " + 
					"order by count(re) desc " + 
					") " + 
					"where rownum = 1";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				title = rs.getString("title");
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
		return title;
	}
	public String minPopulaMovie(Object year) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String title = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select title " + 
					"from( " + 
					"select title, count(re) " + 
					"from memberaction ma, memberinfo mi, movie m " + 
					"where ma.num = mi.num and ma.m_num = m.m_num  and year = '"+year+"' " + 
					"group by title " + 
					"order by count(re) " + 
					") " + 
					"where rownum = 1";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				title = rs.getString("title");
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
		return title;
	}
	public String maxPopulaMovieMonth(Object year,JComboBox cbMonth_1) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String month = "";
		String[] mon = { "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
		if(cbMonth_1.getSelectedIndex()==0) {
			month = null; 
		}else {
			month = mon[cbMonth_1.getSelectedIndex()-1];
		}
		String title = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select title " + 
					"from( " + 
					"select title, count(re) " + 
					"from memberaction ma, memberinfo mi, movie m " + 
					"where ma.num = mi.num and ma.m_num = m.m_num  and year = '"+year+"' and month = '"+month+"' "+ 
					"group by title " + 
					"order by count(re) desc " + 
					") " + 
					"where rownum = 1";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				title = rs.getString("title");
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
		return title;
	}
	public String minPopulaMovieMonth(Object year,JComboBox cbMonth_1) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String month = "";
		String[] mon = { "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
		if(cbMonth_1.getSelectedIndex()==0) {
			month = null; 
		}else {
			month = mon[cbMonth_1.getSelectedIndex()-1];
		}
		String title = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select title " + 
					"from( " + 
					"select title, count(re) " + 
					"from memberaction ma, memberinfo mi, movie m " + 
					"where ma.num = mi.num and ma.m_num = m.m_num  and year = '"+year+"'  and month = '"+month+"' "+ 
					"group by title " + 
					"order by count(re) " + 
					") " + 
					"where rownum = 1";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				title = rs.getString("title");
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
		return title;
	}
	public String popularGenre(Object year, String gender) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String genre = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * " + 
					"from( " + 
					"select genre, count(re) " + 
					"from movie m, memberinfo mi, memberaction ma " + 
					"where m.m_num = ma.m_num and mi.num=ma.num and year = '"+year+"' and gender='"+gender+"'\r\n" + 
					"group by genre " + 
					"having avg(score)>3 " + 
					"order by count(re) desc, avg(score) desc" + 
					") " + 
					"where rownum = 1";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				genre = rs.getString("genre");
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
		return genre;
	}
	public String popularGenreMonth(Object year,JComboBox cbMonth_1, String gender) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String genre = null;
		String month = "";
		String[] mon = { "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
		if(cbMonth_1.getSelectedIndex()==0) {
			month = null; 
		}else {
			month = mon[cbMonth_1.getSelectedIndex()-1];
		}
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select *\r\n" + 
					"from(\r\n" + 
					"select genre, count(re)\r\n" + 
					"from movie m, memberinfo mi, memberaction ma\r\n" + 
					"where m.m_num = ma.m_num and mi.num=ma.num and year = '"+year+"' and gender='"+gender+"' and month = '"+month+"'\r\n" + 
					"group by genre\r\n" + 
					"having avg(score)>3 \r\n" + 
					"order by count(re) desc, avg(score) desc" + 
					")\r\n" + 
					"where rownum = 1";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				genre = rs.getString("genre");
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
		return genre;
	}
}
