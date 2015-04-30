package yamada.jdbc.study;

import java.util.Date;

import yamada.jdbc.study.comment.Kouhan;
import yamada.jdbc.study.comment.Zenhan;

public class JavaStudy0428_04 {
	public static void main (String[] args) throws Exception {
		Zenhan.doWarusa();
		Zenhan.doTogame();
		Kouhan.callDeae();
		Kouhan.showMondokoro();

		schedule();

	}

	private static void schedule() {
		// TODO 自動生成されたメソッド・スタブ
		Date Date = new Date();
		System.out.println(Date);
	}


}