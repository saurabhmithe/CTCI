import java.util.HashMap;
import java.util.Map;

/*
 * There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit
 * (or zero edits) away.
 */
public class OneAway {

    public static void main(String[] args) {
        String s1 = "pale";
        String s2 = "ale";

        System.out.println(oneAwayInPlace(s1, s2));
    }

    /**
     * In this approach, we would check both the scenarios independently.
     * checkReplacement() would check whether two strings with equal lengths have a single out of place character.
     * checkInsert() would check whether two strings with length difference of just one have same character sequence.
     *
     * For both of these operations, we would check each character sequentially until we find the mismatch.
     * The time complexity of this approach would be O(N).
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean oneAwayInPlace(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return checkReplacement(s1, s2);
        } else if (s1.length() - s2.length() > 0) {
            return checkInsert(s1, s2);
        } else if (s1.length() - s2.length() < 0) {
            return checkInsert(s2, s1);
        }
        return false;
    }

    private static boolean checkReplacement(String s1, String s2) {
        boolean mismatchFound = false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (mismatchFound) {
                    return false;
                }
                mismatchFound = true;
            }
        }
        return mismatchFound;
    }

    private static boolean checkInsert(String s1, String s2) {
        if (s1.length() - s2.length() > 1) {
            return false;
        }

        boolean foundMismatch = false;
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(index1) == s2.charAt(index2)) {
                index1++;
                index2++;
                continue;
            } else {
                if (!foundMismatch) {
                    foundMismatch = true;
                    index1++;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
