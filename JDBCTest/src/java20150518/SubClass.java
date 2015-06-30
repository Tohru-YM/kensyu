package java20150518;

public class SubClass extends SuperClass {
	public SubClass () {
		super("B");
	}

	public SubClass (String val) {
		System.out.println(val);
	}
}
