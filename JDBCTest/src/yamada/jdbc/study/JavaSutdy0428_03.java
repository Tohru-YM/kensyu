package yamada.jdbc.study;




public class JavaSutdy0428_03 {
	public static void main (String[] args) {

		double area;
		area =

		calcTriangleArea(10.0, 5.0);

		System.out.println("この三角形の面積は" + area + "c㎡です");
		calcCircleArea(5.0);
	}

	public static double calcTriangleArea (double bottom, double height) {
		double result = bottom * height / 2;
		return result;


	}
	public static double calcCircleArea (double radius) {
		double area;
		area = radius * radius * 3.14;
		System.out.println("この円の面積は" + area + "c㎡です");

		return radius;

	}
}