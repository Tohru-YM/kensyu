class User {
	String name;
	String email;
	User (String name) {
		this.name = name;
	}
	void sayHi() {
		System.out.println("Hi! I'm " + this.name);
	}
}

class SuperUser extends User {
	SuperUser(String name) {
		super(name);
	}
	void sayHi() {
		System.out.println("HIIIIIII! I'm " + this.name);
	}
}


public class lesson17 {
	public static void main (String[] args) {
		User Tom = new User("Tom");
		SuperUser Bob = new SuperUser("Bob");
		Tom.sayHi();
		Bob.sayHi();
	}
}