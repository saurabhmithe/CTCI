import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Given a string, write a function to check if it is a 
 * permutation of a palin- drome. A palindrome is a word 
 * or phrase that is the same forwards and backwards. 
 * A permutation is a rearrangement of letters.The palindrome 
 * does not need to be limited to just dictionary words.
 */
public class PallindromePremutation {

	public static void main(String[] args) {
		String input = "Tact Coa";

		System.out.println(isPallindromePermutation(input));
	}

	private static boolean isPallindromePermutation(String input) {
		String workingString = input.toLowerCase();

		Map<Character, Integer> palMap = new HashMap<Character, Integer>();

		for (int i = 0; i < workingString.length(); i++) {
			if (workingString.charAt(i) != ' ') {
				if (!palMap.containsKey(workingString.charAt(i))) {
					palMap.put(workingString.charAt(i), 1);
				} else {
					palMap.put(workingString.charAt(i), palMap.get(workingString.charAt(i)) + 1);
				}
			}
		}

		boolean isPallindrome = false;

		Iterator<Map.Entry<Character, Integer>> iterator = palMap.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry<Character, Integer> entry = iterator.next();
			if (entry.getValue() % 2 == 0) {
				iterator.remove();
			}
			if (palMap.isEmpty() || palMap.size() == 1) {
				isPallindrome = true;
				break;
			}
		}

		return isPallindrome;
	}
}
