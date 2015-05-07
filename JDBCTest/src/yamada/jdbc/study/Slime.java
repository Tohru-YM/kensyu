package yamada.jdbc.study;

import java.util.Random;

public class Slime extends Enemy {

	public Slime () {

		this.name = "スライム" ;
		this.hp = 5;
		this.level = 5;
		this.ex = 2;
		this.run = new Random().nextInt(3);

	}

}
