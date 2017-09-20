
public class URLify {
	public static void main(String[] args) {
		String inputString = "Mr John Smith    ";
		Integer trueLength = 13;

		char[] finalUrl = urlify(inputString, trueLength);
		System.out.println(finalUrl);
	}

	private static char[] urlify(String inputString, Integer trueLength) {
		char[] charArray = inputString.toCharArray();

		int len = charArray.length-1;

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
