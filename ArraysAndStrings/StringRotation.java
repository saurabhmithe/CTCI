
public class StringRotation {
	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";

		System.out.println(isRotation(s1, s2));
	}

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
