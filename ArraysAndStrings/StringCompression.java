
/*
 * Implement a method to perform basic string compression using 
 * the counts of repeated characters. For example, the string 
 * aabcccccaaa would become a2b1c5a3. If the "compressed" string 
 * would not become smaller than the original string, your method 
 * should return the original string. You can assume the string has 
 * only uppercase and lowercase letters (a - z).
 */
public class StringCompression {
	public static void main(String[] args) {
		String toBeCompressed = "aaabbbbbccccccc";

		System.out.println(compressString(toBeCompressed));
	}

	private static String compressString(String s) {

		StringBuilder compressedString = new StringBuilder();

		int count = 0;
		char previous = ' ';
		for (int i = 0; i < s.length(); i++) {
			if (previous != ' ') {
				if (s.charAt(i) == previous) {
					count++;
				} else {
					compressedString.append(previous);
					compressedString.append(count);
					count = 1; // This is a new character. Acknowledging it's existence.
				}
			} else {
				// This just started. Setting count 1 for first letter
				count++;
			}
			previous = s.charAt(i);

		}
		compressedString.append(previous);
		compressedString.append(count);

		return compressedString.toString();
	}
}
