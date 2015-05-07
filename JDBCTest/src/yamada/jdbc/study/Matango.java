package yamada.jdbc.study;

import java.util.Random;


public class Matango extends Enemy {

	public Matango () {
		this.name = "お化けキノコ" ;
		this.hp = 10;
		this.power = 10;
		this.level = 5;
		this.ex = 5;
		this.run = new Random().nextInt(2);
	}

//	コンストラクタとしてでなく外にオーバーライド private String name = "お化けキノコ" ;
//	public String getName() {return name;}//この式なしでできないのか?







}
