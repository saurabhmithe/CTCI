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

    /**
     * This approach looks at each character starting from the beginning of the string.
     * If the previous character is the same as the current character, count is incremented and maintained.
     * When a new character is encountered, the previous character along with its count is appended to
     * the compressed string and a new count is maintained for the new character.
     *
     * The time complexity for this solution is O(N).
     *
     * @param s
     * @return
     */
    private static String compressString(String s) {
        StringBuilder compressedString = new StringBuilder();

        int count = 0;
        char previous = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (previous != ' ') {
                if (s.charAt(i) == previous) {
                    // This character is the same as the previous one
                    count++;
                } else {
                    // This is a new character. Appending the count of previous distinct character to compressed string
                    compressedString.append(previous);
                    compressedString.append(count);
                    count = 1;
                }
            } else {
                // This is the first character in the string
                count++;
            }
            previous = s.charAt(i);

        }
        compressedString.append(previous);
        compressedString.append(count);

        return compressedString.toString();
    }
}
