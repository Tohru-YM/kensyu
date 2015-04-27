package yamada.jdbc.study;


public class Java_0427{

	public static void main (String[] args) {
		System.out.println("あなたのお名前は?");
		String name = new java.util.Scanner(System.in).nextLine();
		System.out.println("あなたの年齢は?");
		int age = new java.util.Scanner(System.in).nextInt();
		int r = new java.util.Random().nextInt(5);
		switch (r) {
		case 0:
			System.out.println(age +"歳の" + name +"さんの運勢は大吉です。");
			break;
		case 1:
			System.out.println(age +"歳の" + name +"さんの運勢は吉です。");
			break;
		case 2:
			System.out.println(age +"歳の" + name +"さんの運勢は小吉です。");
			break;
		case 3:
			System.out.println(age +"歳の" + name +"さんの運勢は凶です。");
			break;
		case 4:
			System.out.println(age +"歳の" + name +"さんの運勢は大凶です。");

		}
	}
}