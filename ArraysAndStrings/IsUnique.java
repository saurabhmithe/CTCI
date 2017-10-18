
/*
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class IsUnique {

	public static void main(String[] args) {
		String test = "abcde";
		boolean result = isUnique(test);
		System.out.println(result);
	}

	private static boolean isUnique(String test) {
		boolean isUnique = true;

		for (int i = 0; i < test.length() - 1; i++) {
			for (int j = i + 1; j < test.length(); j++) {
				if (test.charAt(i) == test.charAt(j)) {
					isUnique = false;
					break;
				}
			}
		}
		return isUnique;
	}
}
