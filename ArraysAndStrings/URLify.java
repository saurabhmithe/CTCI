
/*
 * Write a method to replace all spaces in a string with '%20: 
 * You may assume that the string has sufficient space at the end 
 * to hold the additional characters, and that you are given the "true" 
 * length of the string.
 */
public class URLify {
	public static void main(String[] args) {
		String inputString = "Mr John Smith    ";
		Integer trueLength = 13;

		char[] finalUrl = urlify(inputString, trueLength);
		System.out.println(finalUrl);
	}

	private static char[] urlify(String inputString, Integer trueLength) {
		char[] charArray = inputString.toCharArray();

		int len = charArray.length - 1;

		for (int i = trueLength - 1; i >= 0; i--) {
			if (charArray[i] != ' ') {
				charArray[len--] = charArray[i];
			} else {
				charArray[len--] = '0';
				charArray[len--] = '2';
				charArray[len--] = '%';
			}
		}

		return charArray;

	}
}
