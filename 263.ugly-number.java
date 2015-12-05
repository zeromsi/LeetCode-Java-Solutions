/**
 * @see <a href="https://leetcode.com/problems/ugly-number/">Ugly Number</a>
 */

public class Solution {
    public boolean isUgly(int num) {
        if (num < 1) return false;
        while (num % 2 == 0) num = num / 2;
        while (num % 3 == 0) num = num / 3;
        while (num % 5 == 0) num = num / 5;
        return num == 1;
    }
}
