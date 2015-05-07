package yamada.jdbc.study2;

import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {

//		long start = System.currentTimeMillis();
//		long end = System.currentTimeMillis();
//
//		Date now = new Date();
//
//		System.out.println(now);
//		System.out.println(now.getTime());
//
//		Date past = new Date(1316622225935L);
//
//		System.out.println(past);
//
//		System.out.println("処理にかかった時間は…" + (end - start) + "ミリ秒でした");



		//現在の年の表示
		Date now = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		System.out.println("今年は " + year + " 年です");
		System.out.println("今日は " + (month + 1) + " 月 " + day +" 日です");
		System.out.println("時刻は " + hour + " 時 " + minute + " 分 " + second + " 秒です" );

		//指定日のDate型を得る

		c.set(2010, 8, 22, 1, 23, 45);
		c.set(Calendar.YEAR, 2011);
		Date past = c.getTime();
		System.out.println("今年は " + past);




	}
}
