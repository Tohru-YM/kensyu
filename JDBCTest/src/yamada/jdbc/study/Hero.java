package yamada.jdbc.study;



public class Hero {
	private String name;
	private int hp;
	static int money;

	Sword sword;



	//フィールド


	Hero(String name) {
		this.hp = 100;
		this.name = name;
	}
	Hero() {
		this("ロト");
	}

	public String getName() {
		return this.name;
		//getterメソッド
	}

	public int getHp() {
		return this.hp;
		//getterメソッド
	}

	public void setHp(int hp) {
		this.hp = hp;
		//setterメソッド
	}

	public void setName(String name) {
		if (name.equals(null)) {
			throw new IllegalArgumentException("名前がnullである。処理を中断。");
		}
		if (name.length() <= 1) {
			throw new IllegalArgumentException("名前が短すぎる。処理を中断。");
		}
		if (name.length() >= 6) {
			throw new IllegalArgumentException("名前が長すぎる。処理を中断。");
		}

		this.name = name;
		//setterメソッド
	}

	void attack() {
		System.out.println(this.name + sword.name +"で攻撃した!");
		System.out.println("敵に5のダメージを与えた!");

	}



	void run() {
		int n =  new java.util.Random().nextInt(2);

		if (n == 0) {
		System.out.println(this.name + "は、逃げ出した!");
		System.out.println("GAME OVER");
		System.out.println("最終HPは" + this.hp + "でした");
		}
		else {
			System.out.println(this.name + "は、逃げ出した!");
			System.out.println("しかし回り込まれてしまった!");
		}
	}

	void bye() {
		System.out.println("勇者は別れを告げた");
	}

	private void die() {
		System.out.println(this.name + "は死んでしまった!");
		System.out.println("GAME OVER");
	}

	void sit(int sec) {
		this.hp += sec;
		System.out.println(this.name + "は、" + sec + "秒座った");
		System.out.println(this.name + "は、" + sec + "ポイント回復した!");
	}

	void slip() {
		this.hp -= 5;
		System.out.println(this.name + "は、転んだ!");
		System.out.println("5のダメージ!");
	}

	void sleep() {
		this.hp = 100;
		System.out.println(this.name + "は、眠って回復した!");
	}
}
