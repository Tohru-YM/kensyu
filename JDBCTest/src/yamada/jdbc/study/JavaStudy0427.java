package yamada.jdbc.study;


public class JavaStudy0427 {
	public static void main (String[] args) {
		System.out.println("[メニュー] 1:検索 2:登録 3:削除 4:変更>");
		int selected = new java.util.Scanner(System.in).nextInt();
		if (selected == 1){
				System.out.println("検索します");
		}
		if (selected == 2){
				System.out.println("登録します");
		}
		if (selected == 3){
				System.out.println("削除します");
		}
		if (selected == 4){
				System.out.println("変更します");
		}
		else {
			System.out.println("1～4の中からお選びください");
			main(args);
		}
	}
}