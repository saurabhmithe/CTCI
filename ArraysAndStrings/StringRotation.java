
/*
 * Assume you have a method isSubstring which checks if one word is 
 * a substring of another. Given two strings, S1 and S2, write code to
 * check if S2 is a rotation of S1 using only one call to isSubstring
 *  (e.g.,"waterbottle"is a rotation of"erbottlewat").
 */
public class StringRotation {
	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "tlewaterbot";

		System.out.println(isRotation(s1, s2));
	}

	/**
	 * In this approach, we build our solution on the fact that if a string s2 is just a rotation of another string s1,
	 * string s2 should be a substring of the concatenation of s1 with s1 i.e. s1s1
	 *
	 * The time complexity for this solution is same as the time complexity of the method isSubstring() which is
	 * O(A+B) where A is the length of string s1 and B is the length of string s2. This makes the time complexity O(N).
	 *
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean isRotation(String s1, String s2) {

		boolean isRotation = false;

		// Take the last character of the second string
		char lastCharInS2 = s2.charAt(s2.length() - 1);

		// Find that character in the first string.
		int index = s1.indexOf(lastCharInS2);
		String restOfTheStringInS1 = s1.substring(index + 1, s1.length());

		// Check if the partial sequence of S1 is present in the string S2
		if (isSubString(restOfTheStringInS1, s2)) {
			isRotation = true;
		}

		return isRotation;

	}

	private static boolean isSubString(String s1, String s2) {
		if (s2.contains(s1)) {
			return true;
		}
		return false;
	}
}
