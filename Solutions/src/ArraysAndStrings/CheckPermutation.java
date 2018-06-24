import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class CheckPermutation {
    public static void main(String[] args) {
        String s1 = "tweety";
        String s2 = "weetty";

        System.out.println(checkPermutation(s1, s2));
        System.out.println(checkPermutationUsingSorting(s1, s2));
        System.out.println(checkPermutationCharacterCounting(s1, s2));
    }

    /**
     * We are assuming that whitespaces are significant and would be counted towards the solution.
     * If the two input strings are of unequal lengths, we can infer that they are not permutations.
     * <p>
     * This approach uses HashMap to maintain the chracter counts in each of the two strings.
     * If, after reading both the strings completely, the resulting hash maps are identical,
     * it is implied that the input strings had the same character counts i.e. they were permutations.
     * <p>
     * The time complexity of this solution would be O(N) since each character would be accessed at most once.
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean checkPermutation(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        boolean isPermutation = false;

        Map<Character, Integer> firstMap = new HashMap<Character, Integer>();
        Map<Character, Integer> secondMap = new HashMap<Character, Integer>();

        for (int i = 0; i < s1.length(); i++) {
            if (!firstMap.containsKey(s1.charAt(i))) {
                firstMap.put(s1.charAt(i), 1);
            } else {
                firstMap.put(s1.charAt(i), firstMap.get(s1.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!secondMap.containsKey(s2.charAt(i))) {
                secondMap.put(s2.charAt(i), 1);
            } else {
                secondMap.put(s2.charAt(i), secondMap.get(s2.charAt(i)) + 1);
            }
        }

        if (firstMap.equals(secondMap)) {
            isPermutation = true;
        }

        return isPermutation;
    }

    /**
     * This approach uses sorting as a means of finding out if the given strings are permutations.
     * The assumption is that if the strings are permutations, after sorting, they would be identical.
     * <p>
     * While this solution is simple to implement and understand, it is inefficient since we are sorting the string,
     * thus, increasing the complexity to O(N*LogN).
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean checkPermutationUsingSorting(String s1, String s2) {

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
     * This approach is based on character counting too, but is more space efficient than the HashMap appraoch.
     * This is because instead of storing the characters in the HashMap, which ends up taking a lot of space,
     * we maintain an integer array of size 128 i.e. constant space and set the count at the index corresponsing
     * to the ASCII value of the respective character found in the input string.
     * <p>
     * One optimization that we did here is that instead of using two arrays for each string, and comparing them
     * in the end, we used a single array, and then decremented the count of the character if the same character
     * is found in the second string. In the end, if any count goes below 0, we would know that the character count
     * is not same, and that the strings are not permutations.
     * <p>
     * The time complexity of this approach is O(N) since we would be reading the characters once.
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean checkPermutationCharacterCounting(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        int[] characterCount = new int[128];

        for (char c : s1.toCharArray()) {
            characterCount[c]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            characterCount[s2.charAt(i)]--;

            if (characterCount[s2.charAt(i)] < 0) {
                return false;
            }
        }

        return true;

    }
}
