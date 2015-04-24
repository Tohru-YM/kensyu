package yamada.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectTest {

	public void simpleSQL() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost/blog_app";
		String user = "dbuser";
		String password = "ptprfd";

		try {
			conn = DriverManager.getConnection(url, user, password); // 問い合わせ

			Statement stmt = conn.createStatement();
			String sql = "select users.id, users.name, posts.title, posts.created from users, posts where users.id = posts.user_id order by posts.created desc";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				/* 行からデータを取得 */
				int id = rs.getInt("users.id");
				String name = rs.getString("users.name");
				String title = rs.getString("posts.title");
				Timestamp created = rs.getTimestamp("posts.created");
				System.out.println("ID " + id + "Name "+ name + "Title " + title + "Created " + created);

			}
			rs.close();
			stmt.close(); //閉じる

		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getMessage());//SQL文か接続ミスで発生
		}
	}

	public static void main(String[] args) {
		SelectTest selectTest = new SelectTest();
		selectTest.simpleSQL();
	}
}

