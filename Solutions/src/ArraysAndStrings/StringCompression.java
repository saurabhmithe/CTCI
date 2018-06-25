package ArraysAndStrings;

public class StringCompression {

    /*

    Implement a method to perform basic string compression using
    the counts of repeated characters. For example, the string
    aabcccccaaa would become a2b1c5a3. If the "compressed" string
    would not become smaller than the original string, your method
    should return the original string. You can assume the string has
    only uppercase and lowercase letters (a - z).

    */

    public static void main(String[] args) {
        String toBeCompressed = "aaabbbbbccccccc";
        System.out.println(compressString(toBeCompressed));
    }

    /**
     * This approach looks at each character starting from the beginning of the string.
     * If the previous character is the same as the current character, count is incremented and maintained.
     * When a new character is encountered, the previous character along with its count is appended to
     * the compressed string and a new count is maintained for the new character.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    private static String compressString(String s) {
        if (s.length() == 0) return "";
        StringBuilder compressedString = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) count += 1;
            else {
                compressedString.append(c);
                compressedString.append(count);
                c = s.charAt(i);
                count = 1;
            }
        }
        compressedString.append(c);
        compressedString.append(count);
        return compressedString.toString();
    }

}
