package yamada.jdbc.study;

public class King {

	void talk(Hero hero) {
		System.out.println("王様:ようこそ、わが国へ勇者" + hero.getName() + "よ");
		System.out.println("王様:長旅疲れたであろう");
		System.out.println("王様:城下町を見てくるがよい");
		System.out.println("王様:ではまた会おう");
		//hero.die();
		hero.bye();
	}
}
