package yamada.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBCテスト
 * @author otsubo
 *
 */
public class JDBCTest {

	/**
	 * コンストラクタ
	 */
	public JDBCTest(){

	}

	public void simpleSQL(){
		Connection conn = null;
		String url = "jdbc:mysql://localhost/passo_web";
	    String user = "passo_web";
	    String password = "passo_web";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);

			Statement stmt = conn.createStatement();
			String sql = "select * from client";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				String name = rs.getString("name");
				System.out.println("name: " + name);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					//nothing to do
				}
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JDBCTest jdbcTest = new JDBCTest();
		jdbcTest.simpleSQL();
	}

}
