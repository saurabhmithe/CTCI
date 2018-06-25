package ArraysAndStrings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PalindromePermutation {

    /*

     Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word
     or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters.
     The palindrome does not need to be limited to just dictionary words.

     */

    public static void main(String[] args) {
        String input = "Tacat Coa";
        System.out.println(isPalindromePermutation(input));
        System.out.println(isPal(input));
    }

    /**
     * A palindrome permutation is a special type of string which would read the same forwards and backwards.
     * This implies that there would be a single non-repeating character (string of odd length) or no repeating
     * characters (string of even length).
     * <p>
     * This approach uses HashMap to find whether the given string is a palindrome permutation or not.
     * We read each character and update the count in the HashMap.
     * If the final HashMap contains even count for all the characters or an odd count for a maximum
     * of one character rest of the counts being two, we can infer that the string would be a
     * palindrome permutation.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    private static boolean isPalindromePermutation(String input) {
        String workingString = input.toLowerCase();

        Map<Character, Integer> palMap = new HashMap<Character, Integer>();

        for (int i = 0; i < workingString.length(); i++) {
            if (workingString.charAt(i) != ' ') {
                if (!palMap.containsKey(workingString.charAt(i))) {
                    palMap.put(workingString.charAt(i), 1);
                } else {
                    palMap.put(workingString.charAt(i), palMap.get(workingString.charAt(i)) + 1);
                }
            }
        }

        boolean isPalindrome = false;

        Iterator<Map.Entry<Character, Integer>> iterator = palMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if (entry.getValue() % 2 == 0) {
                iterator.remove();
            }
            if (palMap.isEmpty() || palMap.size() == 1) {
                isPalindrome = true;
                break;
            }
        }

        return isPalindrome;
    }

    /**
     * This approach uses a bit vector to determine whether the characters appear for even number of times in the
     * string with at most one character that can appear for odd number of times. This logic is the same one
     * as we have implemented in the other solution using HashMap but this is more space efficient since we require
     * just 4 byte integer for bit vector instead of the HashMap.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public static boolean isPal(String s) {
        s = s.toLowerCase();
        int checker = 0;
        // create bit vector for given string with toggling
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                int pos = c - 'a';
                int mask = 1 << pos;
                if ((checker & mask) == 0) {
                    // set 0 to 1
                    checker |= mask;
                } else {
                    // set 1 to 0
                    checker &= ~mask;
                }
            }
        }
        // now we need to check if just a single bit is set
        // 00010000 -1 -> 00001111
        int res = checker - 1;
        return (res & checker) == 0;
    }

}
