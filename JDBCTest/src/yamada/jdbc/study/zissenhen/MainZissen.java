package yamada.jdbc.study.zissenhen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import yamada.jdbc.study.Hero;

public class MainZissen {

	public static void main (String[] args) {
		String s1 = "スッキリJava";
		String s2 = "Java";
		String s3 = "java";
		String s4 = "";

		if (s2.equals(s3)) {
			System.out.println("s2とs3は等しい");
		}
		if (s2.equalsIgnoreCase(s3)) {
			System.out.println("s2とs3はケースを区別しなければ等しい");
		}
		System.out.println("s1の長さは" + s1.length()+ "です");
		if (s4.isEmpty()) {
			System.out.println("s4は空っぽ");
		}
		String s5 = "Java and JavaScript";
		if (s5.contains("Java")) {
			System.out.println("文字列s5は、Javaが含まれています");
		}
		if (s5.endsWith("Java")) {
			System.out.println("文字列s5は末尾に、Javaが含まれています");
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 100; i++) {
			sb.append(i+1).append(",");

		}
		System.out.println(sb);
		String s = sb.toString();
		String[] a = s.split(",");

		System.out.println(s);

		ArrayList<String> al = new ArrayList<String>();

		al.add("田中");
		al.add("佐藤");
		al.add("鈴木");

		System.out.println(al.get(1));

		ArrayList<Integer> al2 = new ArrayList<Integer>();

		al2.add(85);
		al2.add(19);
		al2.add(32);
		al2.add(0);

		al2.isEmpty();

		System.out.println(al2.get(2));
		System.out.println(al2.isEmpty());
		System.out.println(al2.contains(0));
		System.out.println(al2.indexOf(32));
		System.out.println(al2.size());

		System.out.println("----------------------------------------------");

		for (int i = 0; i < al2.size(); i++) {
			System.out.println(al2.get(i));
		}

		for (int i : al2) {
			System.out.println(i);
		}

		Iterator <Integer> it = al2.iterator();
		while(it.hasNext()) {
			Integer e = it.next();
			System.out.println(e);
		}

		Set <String> colors = new HashSet<String> ();
		colors.add("赤");
		colors.add("青");
		colors.add("黄");
		colors.add("赤");
		System.out.println("色は" + colors.size() + "種類");

		Set <String> words = new TreeSet<String> ();
		words.add("cats");
		words.add("apples");
		words.add("dogs");

		for(String sw : words) {
		System.out.println(sw + ",");
		}

		Map <Integer, String> city = new HashMap <Integer, String> ();
		city.put(1, "東京都");
		city.put(2, "千葉県");
		city.put(3, "神奈川県");

		System.out.println(city.get(1));
		System.out.println(city.keySet());
		for( int key : city.keySet()) {
			System.out.println( key + "番 " + city.get(key) );
		}

		Hero h1 = new Hero ("鈴木");
		Hero h2 = new Hero ("斎藤");

		List <Hero> heros = new ArrayList<Hero>();

		heros.add(h1);
		heros.add(h2);

		System.out.println(h1.getName());
		System.out.println((heros.get(0)).getName());

		System.out.println("---------------------------------------------");

		for (int i = 0; i < heros.size(); i++) {

			System.out.println((heros.get(i)).getName());
		}
		System.out.println("---------------------------------------------");
		for(Hero sp : heros) {
			System.out.println(sp.getName());
		}
		System.out.println("---------------------------------------------");
		Iterator<Hero> its = heros.iterator();
		while(its.hasNext()) {

			Hero e = its.next();
			System.out.println(e.getName());
		}

		//Map< Hero, Integer> heros1 = new TreeMap< Hero, Integer>();
		Map< Hero, Integer> heros1 = new LinkedHashMap< Hero, Integer>();

		heros1.put(h1, 3);
		heros1.put(h2, 7);

		System.out.println("---------------------------------------------");

		for (Hero key : heros1.keySet()) {
			int value = heros1.get(key);
			System.out.println(key.getName() + "が倒した敵=" + value);
			//結果が逆
		}

	}

}
