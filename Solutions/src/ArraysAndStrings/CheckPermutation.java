package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

    /*

    1.2 Check Permutation:
    Given two strings, write a method to decide if one is a permutation of the other.

    */

    public static void main(String[] args) {
        String s1 = "tweety";
        String s2 = "weetty";
        System.out.println(checkPermutationUsingCounting(s1, s2));
        System.out.println(checkPermutationUsingSorting(s1, s2));
        System.out.println(checkPermutationCharacterCounting(s1, s2));
    }

    /**
     * This approach uses sorting as a means of finding out if the given strings are permutations.
     * The assumption is that if the strings are permutations, after sorting, they would be identical.
     * <p>
     * While this solution is simple to implement and understand, it is inefficient since we are sorting the string,
     * thus, increasing the complexity to O(nlogn).
     * <p>
     * Time Complexity - O(nlogn)
     * Space Complexity - O(1)
     */
    private static boolean checkPermutationUsingSorting(String s1, String s2) {
        // Strings are of unequal length. Cannot be permutations.
        if (s1.length() != s2.length()) {
            return false;
        }

        // Since strings are immutable, we wrote a simple sort function that returns the sorted string.
        String sortedS1 = sort(s1);
        String sortedS2 = sort(s2);

        return sortedS1.equals(sortedS2);
    }

    private static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    /**
     * We are assuming that whitespaces are significant and would be counted towards the solution.
     * If the two input strings are of unequal lengths, we can infer that they are not permutations.
     * <p>
     * This approach uses HashMap to maintain the character counts in each of the two strings.
     * For a character seen in first string, we increment the character count in the HashMap.
     * For a character seen in the second string, we decrement the character count in the HashMap.
     * Thus, we are balancing the count. The eventual count for all the characters would be 0 if
     * all the characters present in s1 are the exact characters present in s2.
     * If this is not the case, one or more of the keys would have a positive or negative value.
     * We return false in such case. Else, we return true if all values are 0.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    private static boolean checkPermutationUsingCounting(String s1, String s2) {
        // Strings are of unequal length. Cannot be permutations.
        if (s1.length() != s2.length()) return false;

        // Keep a track of the characters using a HashMap.
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s1.length(); i++) {
            // Increment count for characters in s1
            if (map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            } else {
                map.put(s1.charAt(i), 1);
            }

            // Decrement count for characters in s2
            if (map.containsKey(s2.charAt(i))) {
                map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
            } else {
                map.put(s2.charAt(i), -1);
            }
        }

        // If there are any characters not present in both, some value would be -1 or 1.
        // This case would imply that the strings are not permutations.
        for (char c : map.keySet()) {
            if (map.get(c) != 0) return false;
        }
        return true;
    }


    /**
     * This approach is based on character counting too, but is more space efficient than the HashMap approach.
     * This is because instead of storing the characters in the HashMap, which ends up taking a lot of space,
     * we maintain an integer array of size 128 i.e. constant space and set the count at the index corresponding
     * to the ASCII value of the respective character found in the input string.
     * <p>
     * One optimization that we did here is that instead of using two arrays for each string, and comparing them
     * in the end, we used a single array, and then decremented the count of the character if the same character
     * is found in the second string. We iterate over the count array and return false if any of the element is
     * not zero which implies that there is a count mismatch.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    private static boolean checkPermutationUsingCountingInArray(String s1, String s2) {
        // Strings are of unequal length. Cannot be permutations.
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] characterCount = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            characterCount[s1.charAt(i)]++;
            characterCount[s2.charAt(i)]--;
        }
        for (int i = 0; i < characterCount.length; i++) {
            if (characterCount[i] != 0) return false;
        }
        return true;
    }

}
