package yamada.jdbc.study;

import java.util.Random;

public class Matango {
	int hp;
	final int LEVEL = 10;
	char suffix;
	int damage;
	int ex = 5;

	static int run = new Random().nextInt(2);



	void attack() {

	}

	void beAttacked() {
		this.hp -= damage;
		System.out.println("お化けキノコ" + this.suffix + "に" + damage + "ダメージ与えた!");
	}

	void run() {
		System.out.println("お化けキノコ" + this.suffix + "は逃げ出した!");
	}


	void die(Hero name,Matango suffix) {
		System.out.println(name + "は" + "お化けキノコ" + suffix + "を倒した!");
		System.out.println(name + "は" + ex + "の経験値を獲得した!");
	}
}
