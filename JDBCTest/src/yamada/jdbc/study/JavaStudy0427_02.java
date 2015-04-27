package yamada.jdbc.study;


public class JavaStudy0427_02{

	public static void main (String[] args) {
		System.out.println("【数あてゲーム】");
		int ans = new java.util.Random().nextInt(9);
		for (int i = 0; i<4; i++) {
			System.out.println("0～9の数字を入力してください");
			int num = new java.util.Scanner(System.in).nextInt();
			if(num == ans) {
				System.out.println("アタリ!");
				i = 5;
			}
			else {
				System.out.println("違います。");
			}

		}
		System.out.println("ゲームを終了します");
	}
}