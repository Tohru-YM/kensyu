package yamada.jdbc.study;

import java.util.Random;


public class Enemy {
	protected String name;
	public String getName() {return name;}
	//public void setName(String name) {this.name = name;}
	protected int hp;
	public int getHp() {return hp;}
	public void setHp(int hp) {this.hp = hp;}
	protected int level;
	public int level() {return level;}
	public void setLevel(int level) {this.level = level;}
	private char suffix;
	public char getSuffix() {return suffix;}
	public void setSuffix(char suffix) {this.suffix = suffix;}
	protected int power;
	public int getPower() {return power;}
	//public void setPower(int power) {this.power = power;}
	protected int ex;
	public int getEx() {return ex;}
	//public void setEx(int ex) {this.ex = ex;}
	protected int run;
	public int getRun() {return run;}
	//public void setRun(int run) {this.run = run;}


	public void attack(Hero hero) {

		int kaishin = new Random().nextInt(16);
		if (kaishin == 0) {
			System.out.println("会心の一撃!");
			System.out.println(this.name + this.suffix + "は" + hero.getName() + "に攻撃した");
			double rannsuu = new Random().nextDouble() + 0.1;
			double damage = (double) (this.power * rannsuu + this.power);
			int lastDamage = (int) (damage);
			hero.setHp(hero.getHp() - lastDamage);//lastDamage);
			if (hero.getHp() <= 0) {
				System.out.println(lastDamage + "ダメージ!");
				hero.die();
			}
			else {

				System.out.println(lastDamage + "ダメージ (HP:" + hero.getHp() + ")");
			}
		}
		else {

			System.out.println(this.name + this.suffix +  "は" + hero.getName() + "に攻撃した");
			double rannsuu = new Random().nextDouble() + 0.1;
			double damage =(double) (this.power * rannsuu) - this.power;
			int lastDamage = (int) (damage + this.power);
			hero.setHp(hero.getHp() - lastDamage);//lastDamage);

			if (hero.getHp() <= 0) {
				System.out.println(lastDamage + "ダメージ!");
				hero.die();
			}
			else {

				System.out.println(lastDamage + "ダメージ (HP:" + hero.getHp() + ")");
			}
		}

	}

//	void beAttacked() {
//		this.hp -= power;
//		System.out.println("お化けキノコ" + this.suffix + "に" + power + "ダメージ与えた!");
//	}

	public void run() {
		System.out.println(this.name + this.suffix + "は逃げ出した!");
	}


	public void die(Hero hero,Enemy enemy) {
		System.out.println(hero.getName() + "は" + this.name + this.suffix + "を倒した!");
		System.out.println(hero.getName() + "は" + this.ex + "の経験値を獲得した!");
	}


}
