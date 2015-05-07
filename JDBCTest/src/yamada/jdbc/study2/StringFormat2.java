package yamada.jdbc.study2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class StringFormat2 {
	public static void main (String[] args) throws Exception {
		try {
			System.out.println("pattern1:");
			pattern1();
			System.out.println();

			System.out.println("pattern2:");
			pattern2();
			System.out.println();

			System.out.println("pattern3:");
			pattern3();
			System.out.println();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * パターン１：単純にInputStraemからreadする
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private static void pattern1() throws MalformedURLException, IOException {
		URL u = new URL("http://www.google.co.jp");

		InputStream is = u.openStream();

		byte[] buff = new byte[1024];

		StringBuffer sb = new StringBuffer();
		while(is.read(buff) != -1){
			sb.append(new String(buff, "JISAutoDetect"));
		}

		System.out.println(sb.toString());
	}

	/**
	 * パターン２：Reader(InputStreamReaderとBufferdReader)を利用してreadする
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private static void pattern2() throws MalformedURLException, IOException {
		URL u = new URL("http://www.google.co.jp");

		InputStream is = u.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "JISAutoDetect"));

		char[] buff = new char[1024];

		StringBuffer sb = new StringBuffer();
		while(br.read(buff) != -1){
			sb.append(new String(buff));
		}

		System.out.println(sb.toString());
	}

	/**
	 * パターン３：パターン２をreadLineで処理する
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private static void pattern3() throws MalformedURLException, IOException {
		URL u = new URL("http://www.google.co.jp");

		InputStream is = u.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "JISAutoDetect"));

		String str = null;
		StringBuffer sb = new StringBuffer();
		while((str =  br.readLine()) != null){
			sb.append(str);
			sb.append("\r\n");//改行 \r = CR  \n = LF
		}

		System.out.println(sb.toString());
	}

}
