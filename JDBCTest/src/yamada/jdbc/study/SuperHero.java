package yamada.jdbc.study;

public class SuperHero extends Hero{

	private boolean flying;


	public void fly() {
		this.flying = true;
		System.out.println("飛び上がった!");
	}

	public void land() {
		this.flying = false;
		System.out.println("着地した!");
	}

	public void run() {
		System.out.println(this.getName() +  "撤退した!");
	}

	public void attack (Enemy enemy) {
		super.attack(enemy);
		if(this.flying) {
			super.attack(enemy);
		}
	}
}
