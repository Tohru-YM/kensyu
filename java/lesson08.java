public class lesson08{
	public static void main (String[] args) {
		int age = 21;
		String message;
		/*if (age > 20) {
			System.out.println("大人です。");
		}
		else {
			System.out.println("その他です。");
		}*/
		message = (age > 20)? "大人です" : "子供です";
		System.out.println(message);
	}
}