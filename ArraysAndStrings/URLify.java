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

    /**
     * This approach uses a character array to hold the given whitespaces as well as the characters.
     * We maintain two pointers. One will point to the end of the characters (true length), and the other would point to
     * the end of the character array i.e. at the end of all the extra whitespaces.
     * <p>
     * We start at the last character in the given string. If it is a valid character, we shift it at the end of the
     * character array i.e. after all the whitespaces. If it is a whitespace, we insert '0', '2', and '%' in this
     * exact order. As we continue doing this, and reach the beginning of the string, we would get the desired
     * substitution.
     * <p>
     * The time complexity of this approach would be O(N) since we will be walking through the string exactly once.
     *
     * @param inputString
     * @param trueLength
     * @return
     */
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
