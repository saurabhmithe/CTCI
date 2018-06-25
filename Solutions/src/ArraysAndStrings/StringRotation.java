package ArraysAndStrings;

public class StringRotation {

    /*

    Assume you have a method isSubstring which checks if one word is
    a substring of another. Given two strings, S1 and S2, write code to
    check if S2 is a rotation of S1 using only one call to isSubstring
    (e.g.,"waterbottle"is a rotation of"erbottlewat").

    */

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "tlewaterbot";
        System.out.println(isRotation(s1, s2));
    }

    /**
     * In this approach, we build our solution on the fact that if a string s2 is just a rotation of another string s1,
     * string s2 should be a substring of the concatenation of s1 with s1 i.e. s1s1
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    private static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String s1s1 = s1 + s1;
        return isSubString(s1s1, s2);
    }

    private static boolean isSubString(String s1, String s2) {
        return s1.contains(s2);
    }

}
