package yamada.jdbc.study;



public class Hero {
	private String name;
	private int hp;
	private int max_hp;
	private int power;
	static int money;

	private Sword sword;



	//フィールド


	public Hero(String name) {
		this.hp = 50;
		this.max_hp = this.hp;
		this.name = name;
	}
	public Hero() {
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

	public int getPower() {
		return this.power;
		//getterメソッド
	}

	public void setPower(int power) {
		this.power = power;
		//setterメソッド
	}

	public int getMax_hp() {
		return max_hp;
	}
	public void setMax_hp(int max_hp) {
		this.max_hp = max_hp;
	}

	public static final int getMoney() {
		return money;
	}
	public static final void setMoney(int money) {
		Hero.money = money;
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

	public Sword getSword() {return this.sword;}
	public void setSword(Sword sword) {this.sword = sword;}

	public void attack(Enemy enemy) {
		System.out.println(this.name + sword.getName() +"で" + enemy.getName() + enemy.getSuffix() + "攻撃した!");
		int dame = (int) (this.power  * sword.getDamage());
		enemy.setHp(enemy.getHp() - dame);
		System.out.println("敵に" + dame + "のダメージを与えた!");

		if(enemy.getHp() <= 0) {enemy.die(this, enemy);}
		else{
		System.out.println(enemy.getName() + "の残りHP:" + enemy.getHp());
		}
	}




	public void run(Enemy enemy) {

		//↓あってるか不安
		if (enemy.getRun() == 0) {
		System.out.println(this.name + "は、" + enemy.getName() + enemy.getSuffix() + "から逃げ出した!");
		System.out.println("GAME OVER");
		System.out.println("最終HPは" + this.hp + "でした");
		}
		else {
			System.out.println(this.name + "は、逃げ出した!");
			System.out.println("しかし回り込まれてしまった!");
		}
	}

	public final void bye() {
		System.out.println("勇者は別れを告げた");
	}

	public void die() {
		System.out.println(this.name + "は死んでしまった!");
		System.out.println("GAME OVER");
	}

	public void sit(int sec) {
		this.hp += sec;
		System.out.println(this.name + "は、" + sec + "秒座った");
		System.out.println(this.name + "は、" + sec + "ポイント回復した!");
	}

	public void slip() {
		this.hp -= 5;
		System.out.println(this.name + "は、転んだ!");
		System.out.println("5のダメージ!");
	}

	public void sleep() {
		this.hp = 100;
		System.out.println(this.name + "は、眠って回復した!");
	}
}
