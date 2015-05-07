package yamada.jdbc.study;

import java.util.Random;

public class Cleric {
	String name;
	int hp = 50;
	static final int MAX_HP = 50;
	int mp = 10;
	static final int MAX_MP = 10;

	Cleric(String name, int hp, int mp) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
	}
	Cleric(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}
//	Cleric(String name) {
//		this.name = name;
//		this(name, Cleric.MAX_HP);
//		//上2つに格納
//	}

	void selfAid() {
		System.out.println(this.name + "はセルフエイドを唱えた!");
		this.hp = this.MAX_HP;
		this.mp -= 5;
		System.out.println(this.name + "はHPが最大まで回復した!");
	}

	void pray (int sec) {
		System.out.println(this.name + "は" + sec + "秒間天に祈った!");
		int recover = new Random().nextInt(3) + sec;
		this.mp += new Random().nextInt(3) + sec;
		System.out.println(this.name + "のMPは" + this.mp + "まで回復した!");
	}
}
