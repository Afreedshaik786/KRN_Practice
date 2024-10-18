package Jeera_learning;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class demo {

	public static void main(String[] args) {
		Map<String, String> m = new Hashtable<>();
		
		Map<String, String> hm = new Map<String, String>();
		m.put("vel", "Selenium");
		m.put("Ganesh", "framework");
		m.put("Dinesh", "oracle");
		m.put("vengat", "corejava");
		m.put("Subash", "jira");

		Set<java.util.Map.Entry<String, String>> ref = m.entrySet();

		for (java.util.Map.Entry<String, String> e : ref) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
		}

	}
}