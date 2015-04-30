package yamada.jdbc.study;

import java.util.Random;

public class Slime {
	int hp;
	final int LEVEL = 10;
	char suffix;
	static int run = new Random().nextInt(3);

	void run() {
		System.out.println("スライム" + this.suffix + "は逃げ出した!");
	}
}
