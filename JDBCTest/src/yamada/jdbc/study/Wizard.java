package yamada.jdbc.study;

public class Wizard {

	private String name;
	public String getName() {return this.name;/*getterメソッド*/}
	public void setName(String name) {this.name = name;/*setterメソッド*/}

	private int hp;
	public int getHp() {return this.hp;/*getterメソッド*/}
	public void setHp(int hp) {this.hp = hp;/*setterメソッド*/}

	private int mp;
	public int getMp() {return this.mp;/*getterメソッド*/}
	public void setMp(int mp) {this.mp = mp;/*setterメソッド*/}

	private Wand wand;
	public Wand getWand() {return this.wand;}
	public void setWand(Wand wand) {this.wand = wand;}

	public void heal (Hero hero) {
		int basePoint = 10;
		int recoverPoint = (int) (basePoint * wand.getPower());

		if (recoverPoint+hero.getHp() >= hero.getMax_hp()) {
			hero.setHp(hero.getMax_hp());
			System.out.println(hero.getName() + "は全回復した(" + hero.getHp() + ")");
		}
		else {
		hero.setHp(hero.getHp() + recoverPoint);
		System.out.println(hero.getName() + "のHPを" + recoverPoint + "回復した(" + hero.getHp() + ")");
		// x はローカル変数
		}
	}
}
