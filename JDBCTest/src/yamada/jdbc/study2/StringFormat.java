package yamada.jdbc.study2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StringFormat {
	public static void main (String[] args) throws Exception {
		Date now = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		String s = f.format(now);

		System.out.println(s);

		Date d = f.parse("2011/09/22 01:23:45");

		System.out.println(d);


//		try {
//			FileWriter fw = new FileWriter("data.txt");
//			fw.write("hello!");
//
//		}
//		catch (Exception e) {
//			System.out.println("何らかの例外が発生しました");
//		}
//		finally {
//			fw.close();
//		}

		FileWriter fw = null;
		try {
			fw = new FileWriter("data.txt");
			fw.write("hello!");

		}
		catch (Exception e) {
			System.out.println("何らかの例外が発生しました");
		}
		finally {
			fw.close();
		}

		//ファイル

		String filename = "C:/Users/tohru/Documents/GitHub/kensyu/java/test.txt";
		FileWriter fw2 = new FileWriter(filename);
		try {
			fw2.write('そ');
			fw2.write('れ');
			fw2.write("はそれ");
		}
		catch (Exception e) {
			System.out.println("例外が発生しました");
		}
		finally {
			fw2.close();
		}

		FileReader fr = new FileReader(filename);
		try {
			char c1 = (char) fr.read();
			char c2 = (char) fr.read();
			System.out.println(c1 + "" + c2);//「それ」にならない

			System.out.println(String.format("%c%c%04d%x", c1,c2,15,15));
		}
		catch (IOException e) {
			System.out.println("例外が発生しました");
		}
		finally {
			fw2.close();
		}

		URL u = new URL("http://www.google.co.jp");
		try {
			InputStream is = u.openStream();
			int i = is.read();
			while (i != -1) {
				char c = (char) i;
				System.out.println(c);
				i = is.read();
			}
		}
		catch (Exception e) {
			System.out.println("例外が発生しました");

		}

		String s1 = "スッキリJava";
		String s2 = "Java";
		String s3 = "java";
		String s4 = "";

		if (s2.equals(s3)) {
			System.out.println("s2とs3は等しい");
		}
		if (s2.equalsIgnoreCase(s3)) {
			System.out.println("s2とs3はケースを区別しなければ等しい");
		}
		System.out.println("s1の長さは" + s1.length()+ "です");
		if (s4.isEmpty()) {
			System.out.println("s4は空っぽ");
		}
		String s5 = "Java and JavaScript";
		if (s5.contains("Java")) {
			System.out.println("文字列s5は、Javaが含まれています");
		}
		if (s5.endsWith("Java")) {
			System.out.println("文字列s5は末尾に、Javaが含まれています");
		}

//		StringBuilder sb = new StringBuilder();
//		for(int i = 0; i < 10000; i++) {
//		sb.append("Java");
//		System.out.println(sb);
//		}
//		String s6 = sb.toString();

	}
}
