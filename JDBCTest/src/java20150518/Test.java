package java20150518;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//A a = new A ();
		//B b = (B) a;
		//A a = new B ();

		A a;
		try {
//			a = (A) Class.forName("java20150518.B").newInstance();
//			B b = (B) a;

			Constructor<A>  c = (Constructor<A>) Class.forName("java20150518.B").getConstructor(Integer.class);
			a  = (A) c.newInstance(10);
			B b = (B) a;

		} catch (InstantiationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


	}

}
