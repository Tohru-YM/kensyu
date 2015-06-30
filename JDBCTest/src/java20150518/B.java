package java20150518;

public class B extends A {
	public B () {
		System.out.println("B");
	}

	public B (Integer x) {
		System.out.println("B" + x);
		new A (x);
	}
}
