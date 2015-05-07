
public abstract class Character {
	private String name;
	private int hp;
	private int max_hp;
	private int power;

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
}
