package yamada.jdbc.study;


public class JavaStudy0428 {
	public static void main (String[] args) {
		int [] array = {1, 2, 3};
		incArray(array);
		for (int i: array) {
			System.out.println(i);
		}
	}

	public static void incArray (int[] array) {
		for(int i = 0; i<array.length; i++) {
			array[i]++;
		}
	}
}