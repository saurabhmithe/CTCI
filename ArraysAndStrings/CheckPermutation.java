import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
	public static void main(String[] args) {
		String s1 = "tweety";
		String s2 = "weetty";

		boolean res = checkPermutation(s1, s2);
		System.out.println(res);
	}

	private static boolean checkPermutation(String s1, String s2) {

		boolean isPermutation = false;

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
		
		if(firstMap.equals(secondMap)) {
			isPermutation = true;
		}

		return isPermutation;
	}
}
