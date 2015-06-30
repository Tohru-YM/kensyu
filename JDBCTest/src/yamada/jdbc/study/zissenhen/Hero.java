package yamada.jdbc.study.zissenhen;


public class Hero implements Comparable<Hero> {
	private String name;
	public Hero(String name) {this.name = name;}
	public String getName () {return this.name;}
	//@Override
//	public int compare(Hero o1, Hero o2) {
//		// TODO 自動生成されたメソッド・スタブ
//		System.out.println(o1.name + " " +  o2.name);
//		return 0;
//
//	}
	@Override
	public int compareTo(Hero o) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(o.name);
		return 0;
	}
}
