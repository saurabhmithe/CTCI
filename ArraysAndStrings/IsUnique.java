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
        String test = "abcde";
        System.out.println(isUnique(test));
        System.out.println(isUniqueUsingHashMap(test));
        System.out.println(isUniqueUsingHashSet(test));
        System.out.println(isUniqueBooleanArray(test));
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
     * <p>
     * Time complexity is O(N) since we are traversing the array just once.
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
     * Time complexity is O(N) since we are reading each character just once. However, since the array size cannot be
     * larger than 256, one can argue that the time complexity will be constant since a maximum of 256 character
     * would be need to be read. So the time complexity would be O(1).
     *
     * @param string
     * @return
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
}
