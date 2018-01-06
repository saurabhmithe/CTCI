import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class IsUnique {

    public static void main(String[] args) {
        String test = "abccde";
        System.out.println(isUnique(test));
        System.out.println(isUniqueUsingHashMap(test));
        System.out.println(isUniqueUsingHashSet(test));
    }

    /**
     * This approach compares every character in the string with every other character except itself.
     * If a match is found, boolean flag is set to false and the method execution is terminated.
     * If no match is found after all the characters are checked, it implies that no duplicates are present.
     * <p>
     * Since we are using nested loops here, the time complexity would be O(N^2).
     *
     * @param string
     * @return
     */
    private static boolean isUnique(String string) {
        boolean isUnique = true;

        for (int i = 0; i < string.length() - 1; i++) {
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(i) == string.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
        }
        return isUnique;
    }

    /**
     * This approach assumes that we can use additional data structures.
     * It uses a HashMap to maintain the character counts for the string.
     * The character is used as key and the number of occurrences of the character is the value.
     * After populating the HashMap, by reading all the characters in the given string, we check
     * the HashMap for any character whose count is greater than one. If no such character is found,
     * it is inferred that no duplicates are present.
     * <p>
     * Time complexity is O(N) since both the loops are run sequentially and are not nested.
     *
     * @param string
     * @return
     */
    private static boolean isUniqueUsingHashMap(String string) {
        boolean isUnique = true;
        Map<Character, Integer> characterCountMap = new HashMap<Character, Integer>();

        for (char c : string.toCharArray()) {
            if (characterCountMap.containsKey(c)) {
                characterCountMap.put(c, characterCountMap.get(c) + 1);
            } else {
                characterCountMap.put(c, 1);
            }
        }

        for (char c : characterCountMap.keySet()) {
            if (characterCountMap.get(c) > 1) {
                isUnique = false;
                break;
            }
        }

        return isUnique;
    }

    /**
     * This approach uses the inherent property of Sets that allow only unique characters to be stored in it.
     * We read each character from the input string and store it in the HashSet.
     * If the input string contains duplicate characters, only a single entry would be present in the Set.
     * In the end, we compare the size of the Set with the length of input string.
     * If they are not equal, it implies that one or more characters were repeated.
     *
     * @param string
     * @return
     */
    private static boolean isUniqueUsingHashSet(String string) {
        boolean isUnique = true;

        Set<Character> uniqueCharacters = new HashSet<Character>();

        for (char c : string.toCharArray()) {
            uniqueCharacters.add(c);
        }

        if (uniqueCharacters.size() != string.length()) {
            isUnique = false;
        }

        return isUnique;
    }
}
