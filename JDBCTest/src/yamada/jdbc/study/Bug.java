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
//public class Hero extends Character {
//
//	static int money;
//	public static final int getMoney() {return money;}
//	public static final void setMoney(int money) {Hero.money = money;}
//	private Sword sword;
//
//
//
//	//フィールド
//
//
//	public Hero(String name) {
//		setHp(50);
//		setMax_hp(this.hp);
//		setName(name);
//	}
//	public Hero() {
//		this("ロト");
//	}
//
//
//
//
//
//	public void setName(String name) {
//		if (name.equals(null)) {
//			throw new IllegalArgumentException("名前がnullである。処理を中断。");
//		}
//		if (name.length() <= 1) {
//			throw new IllegalArgumentException("名前が短すぎる。処理を中断。");
//		}
//		if (name.length() >= 6) {
//			throw new IllegalArgumentException("名前が長すぎる。処理を中断。");
//		}
//
//		setName(name);
//		//setterメソッド
//	}
//
//	public Sword getSword() {return this.sword;}
//	public void setSword(Sword sword) {this.sword = sword;}
//
//	public void attack(Enemy enemy) {
//		System.out.println(this.name + sword.getName() +"で" + enemy.getName() + enemy.getSuffix() + "攻撃した!");
//		int dame = (int) (this.power  * sword.getDamage());
//		enemy.setHp(enemy.getHp() - dame);
//		System.out.println("敵に" + dame + "のダメージを与えた!");
//
//		if(enemy.getHp() <= 0) {enemy.die(this, enemy);}
//		else{
//		System.out.println(enemy.getName() + "の残りHP:" + enemy.getHp());
//		}
//	}
//
//
//
//
//	public void run(Enemy enemy) {
//
//		//↓あってるか不安
//		if (enemy.getRun() == 0) {
//		System.out.println(this.name + "は、" + enemy.getName() + enemy.getSuffix() + "から逃げ出した!");
//		System.out.println("GAME OVER");
//		System.out.println("最終HPは" + this.hp + "でした");
//		}
//		else {
//			System.out.println(this.name + "は、逃げ出した!");
//			System.out.println("しかし回り込まれてしまった!");
//		}
//	}
//
//	public final void bye() {
//		System.out.println("勇者は別れを告げた");
//	}
//
//	public void die() {
//		System.out.println(this.name + "は死んでしまった!");
//		System.out.println("GAME OVER");
//	}
//
//	public void sit(int sec) {
//		this.hp += sec;
//		System.out.println(this.name + "は、" + sec + "秒座った");
//		System.out.println(this.name + "は、" + sec + "ポイント回復した!");
//	}
//
//	public void slip() {
//		this.hp -= 5;
//		System.out.println(this.name + "は、転んだ!");
//		System.out.println("5のダメージ!");
//	}
//
//	public void sleep() {
//		this.hp = 100;
//		System.out.println(this.name + "は、眠って回復した!");
//	}
//}

