package ArraysAndStrings;

import java.util.*;

public class IsUnique {

    /*

    1.1 Is Unique:
    Implement an algorithm to determine if a string has all unique characters.
    What if you cannot use additional data structures?

    */

    public static void main(String[] args) {
        String test = "testing";
        System.out.println(isUniqueBruteForce(test));
        System.out.println(isUniqueSorting(test));
        System.out.println(isUniqueUsingHashMap(test));
        System.out.println(isUniqueUsingHashSet(test));
        System.out.println(isUniqueBooleanArray(test));
        System.out.println(isUniqueBitVector(test));
    }

    /**
     * This approach compares every character in the string with every other character except itself.
     * If a match is found, boolean flag is set to false and the method execution is terminated.
     * If no match is found after all the characters are checked, it implies that no duplicates are present.
     * <p>
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    private static boolean isUniqueBruteForce(String string) {
        for (int i = 0; i < string.length() - 1; i++) {
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(i) == string.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This approach makes use of sorting.
     * After sorting, we traverse through the string one character at a time.
     * If two adjacent characters are same, the characters are not unique and we return false.
     * If no such characters are found, we return true.
     * <p>
     * Time Complexity - O(nlogn)
     * Space Complexity - O(1)
     */
    private static boolean isUniqueSorting(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        for (int i = 0; i < c.length - 1; i++) {
            // Check if current character is same as the next character.
            if (c[i] == c[i + 1]) return false;
        }
        return true;
    }

    /**
     * This approach assumes that we can use additional data structures.
     * It uses a HashMap to maintain the character counts for the string.
     * The character is used as key and the number of occurrences of the character is the value.
     * If the HashMap already contains a key, we return false since this is the second time we are visiting it.
     * If no such collision is found, we return true.
     * <p>
     * Time complexity - O(n)
     * Space Complexity - O(n)
     */
    private static boolean isUniqueUsingHashMap(String string) {
        Map<Character, Integer> characterCountMap = new HashMap<Character, Integer>();
        for (char c : string.toCharArray()) {
            if (characterCountMap.containsKey(c)) {
                // We have already seen this character. It cannot be unique.
                return false;
            }
            characterCountMap.put(c, 1);
        }
        return true;
    }

    /**
     * We can also use sets for this approach since we don't really have any use for values.
     * For every character in the string, we see if the set already contains the character.
     * If it does, we return false, else we store the character in the set.
     * I we are done looking at all the characters and no one was repeated, we return true.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    private static boolean isUniqueUsingHashSet(String string) {
        Set<Character> uniqueCharacters = new HashSet<Character>();
        for (char c : string.toCharArray()) {
            if (uniqueCharacters.contains(c)) {
                // We have already seen this character. It cannot be unique.
                return false;
            }
            uniqueCharacters.add(c);
        }
        return true;
    }

    /**
     * This approach is the best approach given the premises and nature of the input.
     * Since there can only be a string of maximum length 256 provided all the characters are unique,
     * we can disregard any string with length greater than that.
     * <p>
     * If we look at the ASCII values of the characters that can form the string, they will always be in the range
     * 0 - 255. So we can use a boolean array to indicate whether the character has already appeared in the string.
     * Whenever we read a character from the string, we check the index corresponding to its boolean value.
     * If it is true, it implies that the character has already appeared in the string before and we exit with false.
     * Else, if the value is false, we set the value to true and move on to the next character.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    private static boolean isUniqueBooleanArray(String string) {
        if (string.length() > 256) {
            return false;
        }
        boolean isUnique = true;
        boolean[] charArray = new boolean[256];
        for (char c : string.toCharArray()) {
            if (!charArray[c]) {
                charArray[c] = true;
            } else {
                isUnique = false;
                break;
            }
        }
        return isUnique;
    }

    /**
     * This is a more clever appraoch as compared to the boolean array one.
     * Instead of using an array, we use the bits of an integer to do the counting.
     * If the corresponding bit is already set, we return false, else we set the bit.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    private static boolean isUniqueBitVector(String string) {
        int checker = 0;
        for (char c : string.toCharArray()) {
            int pos = 1 << c - 'a';
            if ((checker & pos) == 1) return false;
            checker |= pos;
        }
        return true;
    }
    
}
