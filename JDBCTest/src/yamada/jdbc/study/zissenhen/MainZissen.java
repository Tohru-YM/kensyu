package yamada.jdbc.study.zissenhen;

public class MainZissen {

	public void main(String[] args) {
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
	}
}
