package yamada.jdbc.study;

//p,204 練習問題
//練習 5-1 ～ 5-3

public class JavaStudy0428_02 {
	public static void main (String[] args) {
		introduceOneself();
		email("初メール", "???.@.co.jp", "HelloWorld");

	}

	public static void introduceOneself () {
		String [] name = {"山田 暢", "ああああ", "いいいい"};
		int [] age = {22,23,24};
		double [] height = {169.0, 170.8, 171.3};
		String [] sex = {"男", "女", "男"};
		/*for (String na: name) {

		System.out.println("私の名前は" + na + "です。 年齢は" + age[1]);
		// それぞれ対応するように拡張for文で
		}*/
		for(int i = 0; i < name.length; i++){
			System.out.println("私の名前は" + name[i] + "です。 年齢は" + age[i] + "身長は" + height[i] + "性別は" + sex[i] + "です。");
		}
	}
	public static void email (String title, String adress, String text) {
		System.out.println("「"+ adress +"」に、以下のメールを送信しました");
		System.out.println("件名:「" + title + "」");
		System.out.println("本文:「" + text + "」");
	}

}