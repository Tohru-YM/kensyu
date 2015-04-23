public class lesson11{
	public static void main (String[] args) {
		// int n = 0;
		
		// // while (n<10) {
		// // 	System.out.println(n);
		// // 	n++;
		// // }
		// do {
		// 	System.out.println(n);
		// 	n++;
		// } while (n < 10);
		for (int n = 0; n < 10; n++) {
			// if (n == 5) {
			// 	break;
			// }
			if (n % 2 == 0) {
				continue;
			}
			System.out.println(n);
		}
	}
}