package swing3.view;

import java.sql.Connection;
import java.sql.DriverManager;

// 오라클 커넥션 유틸클래스
public class ConnectionUtil {

	private Connection conn;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "scott";
	String pwd = "TIGER";

	// 커넥션 획득
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pwd);
			return conn;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// 커넥션 반환
	public void returnConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
