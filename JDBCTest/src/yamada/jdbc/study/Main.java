package yamada.jdbc.study;

public class Main {
	public static void main(String[] args) {


		//仲間
		Hero.money = 100;


		Hero loto = new Hero();
		loto.setPower(5);


		//a.name = "ロト";
		//a.hp = 100;
		// Hero aにステータス(属性)を与える

		System.out.println("勇者" + loto.getName() + "を生み出しました!" + "(HP=" + loto.getHp() + ")");
		System.out.println("HP:" + loto.getHp() + " ATTACK:" + loto.getPower());
		System.out.println("所持金" + Hero.money + "G");

		Hero fujiwara = new Hero();
		fujiwara.setName("フジワラ");
		fujiwara.setPower(10);

		//a1.name = "フジワラ";
		System.out.println("勇者" + fujiwara.getName() + "を生み出しました!");
		System.out.println("HP:" + fujiwara.getHp() + " ATTACK:" + fujiwara.getPower());
		System.out.println("所持金" + fujiwara.money + "G");

		Hero kamui = new Hero("カムイ");
		kamui.setPower(8);

		//a2.name = "カムイ";
		System.out.println("勇者" + kamui.getName() + "を生み出しました!");
		System.out.println("HP:" + kamui.getHp() + " ATTACK:" + kamui.getPower());
		kamui.money = 300;
		System.out.println("所持金(a2)" + kamui.money + "G");
		System.out.println("所持金(Hero)" + Hero.money + "G");
		System.out.println("所持金(a1)" + fujiwara.money + "G");


		Sword flame = new Sword();

		flame.setName("炎の剣");
		flame.setDamage(1.2);
		loto.setSword(flame);
		System.out.println(loto.getName() + "は" + flame.getName() +"を持っている。");

		SuperHero yusyaou = new SuperHero();
		yusyaou.setName("あああああ");
		yusyaou.setHp(150);
		yusyaou.setMax_hp(yusyaou.getHp());
		yusyaou.setPower(25);
		//HPが変化しない?メソッドがかぶっていた
		System.out.println("勇者王" + yusyaou.getName() + "を生み出しました!" + "(HP=" + yusyaou.getHp() + ")");

		flame.setName("勇者の剣");
		flame.setDamage(8.2);
		yusyaou.setSword(flame);
		System.out.println(yusyaou.getName() + "は" + flame.getName() +"を持っている。");

		Cleric b = new Cleric("僧侶1", 40, 5);
		//b.name = "ああああ";
		System.out.println("僧侶" + b.name + "を生み出しました!" + "(HP=" + b.hp + "MP=" + b.mp + ")");

		Cleric c = new Cleric("僧侶2", 40);
		System.out.println("僧侶" + c.name + "を生み出しました!" + "(HP=" + c.hp + "MP=" + c.mp + ")");

		Wizard w = new Wizard();
		w.setName("いいいい");
		//w.name = "いいいい";
		w.setHp(50);
		//w.hp = 50;


		Wand ww = new Wand();
		ww.setName("マジック棒");
		ww.setPower(1.0);
		w.setWand(ww);

		System.out.println("魔法使い" + w.getName()  + "を生み出しました!" + "(HP=" + w.getHp() + ")");
		System.out.println("所持品:" + ww.getName());

		King ousama = new King();

		Inn tokyo = new Inn();

		//敵


		Matango en1 = new Matango();
		en1.setSuffix('A');
		System.out.println(en1.getName() + en1.getSuffix() + "が現れた!");

		Matango en2 = new Matango();
		en2.setSuffix('B');
		System.out.println(en2.getName() + en2.getSuffix() + "が現れた!");



		System.out.println("----------------------------------------------");

		kamui.run(en2);
		en1.attack(fujiwara);
		en1.attack(loto);
		en1.attack(fujiwara);
		en1.attack(yusyaou);
		en1.attack(fujiwara);
		yusyaou.attack(en2);
		b.selfAid();
		b.pray (4);
		loto.attack(en1);
		kamui.slip();
		yusyaou.sleep();
		yusyaou.run();
		w.heal(kamui);
		loto.sit(10);
		loto.slip();


		//tokyo.checkIn(a2);
		//ousama.talk(a);

		//a.run();
	}
}
