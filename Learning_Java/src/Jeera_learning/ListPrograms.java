package Jeera_learning;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ListPrograms {

	public static void main(String[] args) {

		Map<Integer, String> m = new HashMap<>();

		m.put(1, "Afreed");
		m.put(3, "apple");

		// System.out.println(m);

		 Set<Entry<Integer, String>> afr = m.entrySet();

		// System.out.println(afr);

		for (Entry<Integer, String> s1 : afr) {
			System.out.println(s1);
		}

	}

}
