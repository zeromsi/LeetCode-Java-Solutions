/**
 * @see <a href="https://leetcode.com/problems/ugly-number-ii/">Ugly Number II</a>
 */

public class Solution {
    public int nthUglyNumber(int n) {
        int count = 0;
        long prev = -1;
        // wrong answer for input: 1407.
        // output: -2084306944
        // expected: 536870912
        // reason: integer overflow.
        // PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        pq.add(1L);
        while (count < n) {
            while (pq.peek() == prev) {
                pq.remove();
            }
            long num = pq.remove();
            prev = num;
            ++count;
            if (count == n) return (int) num;

            pq.add(num * 2);
            pq.add(num * 3);
            pq.add(num * 5);
        }
        return -1;
    }
}
