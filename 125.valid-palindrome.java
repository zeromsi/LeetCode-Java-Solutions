/**
 * @see <a href="https://leetcode.com/problems/valid-palindrome/">Valid Palindrome</a>
 */

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.equals("")) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            /* the characters can be alphabets and digits !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            if (!Character.isAlphabetic(s.charAt(i))) i ++;
            else if (!Character.isAlphabetic(s.charAt(j))) j --;
            else {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                    return false;
                i ++; j --;
            }
            */
            if (!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i)) ) i ++;
            else if  (!Character.isAlphabetic(s.charAt(j)) && !Character.isDigit(s.charAt(j))) j --;
            else {
                if (Character.isDigit(s.charAt(i)) || Character.isDigit(s.charAt(j))) {
                    // at least one is digit.
                    if (s.charAt(i) != s.charAt(j)) return false;
                    i ++; j --;
                }
                // both are alphabetic
                else {
                    if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                        return false;
                    i ++; j --;
                }
            }
            
            
        }
        return true;
    }
}
