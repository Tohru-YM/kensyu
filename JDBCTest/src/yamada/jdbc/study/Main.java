package yamada.jdbc.study;

public class Main {
	public static void main(String[] args) {


		//仲間
		Hero.money = 100;


		Hero a = new Hero();

		//a.name = "ロト";
		//a.hp = 100;
		// Hero aにステータス(属性)を与える

		System.out.println("勇者" + a.getName() + "を生み出しました!" + "(HP=" + a.getHp() + ")");
		System.out.println("所持金" + Hero.money + "G");

		Hero a1 = new Hero();
		a1.setName("フジワラ");

		//a1.name = "フジワラ";
		System.out.println("勇者" + a1.getName() + "を生み出しました!" + "(HP=" + a1.getHp() + ")");
		System.out.println("所持金" + a1.money + "G");

		Hero a2 = new Hero("カムイ");

		//a2.name = "カムイ";
		System.out.println("勇者" + a2.getName() + "を生み出しました!" + "(HP=" + a2.getHp() + ")");
		a2.money = 300;
		System.out.println("所持金(a2)" + a2.money + "G");
		System.out.println("所持金(Hero)" + Hero.money + "G");
		System.out.println("所持金(a1)" + a1.money + "G");


		Sword s = new Sword();
		s.name = "炎の剣";
		s.damage = 10;
		System.out.println(a.getName() + "は" + s.name +"を持っている。");

		Cleric b = new Cleric("ああああ", 40, 5);
		//b.name = "ああああ";
		System.out.println("僧侶" + b.name + "を生み出しました!" + "(HP=" + b.hp + "MP=" + b.mp + ")");

		Cleric c = new Cleric("ああああ2", 40);
		System.out.println("僧侶" + c.name + "を生み出しました!" + "(HP=" + c.hp + "MP=" + c.mp + ")");

		Wizard w = new Wizard();
		w.setName("いいいい");
		//w.name = "いいいい";
		w.setHp(50);
		//w.hp = 50;
		Wand ww = new Wand();
		ww.setName("マジック棒");
		ww.setPower(1.0);

		System.out.println("魔法使い" + w.getName()  + "を生み出しました!" + "(HP=" + w.getHp() + ")");
		System.out.println("所持品:" + ww.getName());

		King ousama = new King();

		Inn tokyo = new Inn();

		//敵


		Matango en1 = new Matango();
		en1.hp = 50;
		en1.suffix = 'A';
		System.out.println("お化けキノコ" + en1.suffix + "が現れた!");

		Matango en2 = new Matango();
		en2.hp = 50;
		en2.suffix = 'B';
		System.out.println("お化けキノコ" + en2.suffix + "が現れた!");

		tokyo.checkIn(a2);
		ousama.talk(a);
		b.selfAid();
		b.pray (4);
		a2.slip();
		//w.heal(a2);
		a.sit(10);
		a.slip();
		en1.run();
		a.run();
	}
}
