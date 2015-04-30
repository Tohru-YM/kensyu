//package yamada.jdbc.study;
//
//public class Bug {
//	public static void main(String[] args) {
//		System.out.println("勇者の名前を入力してください");
//		String named = new java.util.Scanner(System.in).nextLine();
//
//		if("".equals(named) ) {
//			// namedがnullになったときにも対応
//			Hero a = new Hero();
//			//a.name = "ロト";
//			//a.hp = 100;
//			// Hero aにステータス(属性)を与える
//
//			System.out.println("勇者" + a.name + "を生み出しました!" + "(HP=" + a.hp + ")");
//		}
//		else {
//			Hero a1 = new Hero(named);
//			System.out.println("勇者" + a1.name + "を生み出しました!" + "(HP=" + a1.hp + ")");
//		}
//
//		/*Hero a1 = new Hero("フジワラ");
//
//		//a1.name = "フジワラ";
//		System.out.println("勇者" + a1.name + "を生み出しました!" + "(HP=" + a1.hp + ")");
//
//		Hero a2 = new Hero("カムイ");
//
//		//a2.name = "カムイ";
//		System.out.println("勇者" + a2.name + "を生み出しました!" + "(HP=" + a2.hp + ")");
//		/
//		else {
//			Hero a3 = new Hero(named);
//
//			//a2.name = "カムイ";
//			System.out.println("勇者" + a3.name + "を生み出しました!" + "(HP=" + a3.hp + ")");
//		}*/
////
////		Sword s = new Sword();
////		s.name = "炎の剣";
////		s.damage = 10;
////		System.out.println(named + "は" + s.name +"を持っている。");
////
////		Cleric b = new Cleric();
////		b.name = "ああああ";
////
////		Wizard w = new Wizard();
////		w.name = "いいいい";
////		w.hp = 50;
////
////		Matango en1 = new Matango();
////		en1.hp = 50;
////		en1.suffix = 'A';
////		System.out.println("お化けキノコ" + en1.suffix + "が現れた!");
////
////		Matango en2 = new Matango();
////		en2.hp = 50;
////		en2.suffix = 'B';
////		System.out.println("お化けキノコ" + en2.suffix + "が現れた!");
////
////		b.selfAid();
////		b.pray (4);
////		w.heal(named);
////		named.sit(10);
////		named.slip();
////		en1.run();
////		named.run();
//	}
//}
