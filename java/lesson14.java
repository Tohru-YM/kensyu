public class lesson14{
	public static void main (String[] args) {
		// int sales[]; //宣言
		// sales = new int[4]; //領域の確保 0から始まる4つ
		// // =int sales[] =new int[4];
		// sales[0] =150;
		// sales[1] =200;
		// sales[2] =140;
		// sales[3] =400;
		// =
		int sales[] = {150, 200, 140, 400};
		//sales.length; 領域の個数 4

		for (int i = 0; i < sales.length; i++)
		System.out.println(sales[i]);
	}
}