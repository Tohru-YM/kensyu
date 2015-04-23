public class lesson16{
	public static void main (String[] args) {
		sayHi("aさん");
		sayHi();
		time();
	}

	public static void sayHi (String name) {
		System.out.println("Hi!" +name);
	}
	public static void sayHi () {
		System.out.println("Hi! Nobody.");
	}
	public static void time () {
		Date d = new Date();
		System.out.println(d);
	}
}