import java.util.HashMap;
import java.util.Map;

public class OneAway {

	public static void main(String[] args) {
		String s1 = "pale";
		String s2 = "ela";

		System.out.println(oneAway(s1, s2));
	}

	private static boolean oneAway(String s1, String s2) {
		
		if(Math.abs(s1.length() - s2.length()) > 1) {
			return false;
		}

		Map<Character, Integer> firstMap = new HashMap<Character, Integer>();
		Map<Character, Integer> secondMap = new HashMap<Character, Integer>();

		for (int i = 0; i < s1.length(); i++) {
			if (!firstMap.containsKey(s1.charAt(i))) {
				firstMap.put(s1.charAt(i), 1);
			} else {
				firstMap.put(s1.charAt(i), firstMap.get(s1.charAt(i)) + 1);
			}
		}

		for (int i = 0; i < s2.length(); i++) {
			if (!secondMap.containsKey(s2.charAt(i))) {
				secondMap.put(s2.charAt(i), 1);
			} else {
				secondMap.put(s2.charAt(i), secondMap.get(s2.charAt(i)) + 1);
			}
		}

		Map<Character, Integer> larger = null;
		Map<Character, Integer> smaller = null;
		if (firstMap.size() >= secondMap.size()) {
			larger = firstMap;
			smaller = secondMap;
		} else {
			larger = secondMap;
			smaller = firstMap;
		}

		for (char c : larger.keySet()) {

			if (smaller.containsKey(c) && smaller.get(c) > 1) {
				// Decrementing value to indicate removal
				smaller.put(c, smaller.get(c) - 1);
			} else if (smaller.containsKey(c)) {
				smaller.remove(c);
			} else {
				continue;
			}
		}

		if (secondMap.size() <= 1) {
			return true;
		} else {
			return false;
		}
	}

}
