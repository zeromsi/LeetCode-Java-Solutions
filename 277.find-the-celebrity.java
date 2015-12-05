/**
 * @see <a href="https://leetcode.com/problems/find-the-celebrity/">Find the Celebrity</a>
 */

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        ArrayList<Integer> candidate = new ArrayList<Integer>();
        for (int i = 0; i < n; i ++) {
            candidate.add(i);
        }
        while (candidate.size() >= 2) {
            ArrayList<Integer> newCand = new ArrayList<Integer>();
            for (int i = 0; i < candidate.size() && i + 1 < candidate.size(); i = i + 2) {
                if (knows(candidate.get(i), candidate.get(i + 1))) {
                    newCand.add(candidate.get(i + 1));
                }
                else {
                    newCand.add(candidate.get(i));
                }
            }
            if (candidate.size() % 2 != 0) {
                newCand.add(candidate.get(candidate.size() - 1));
            }
            candidate = newCand;
        }
        // System.out.print(candidate.get(0));
        
        // checking consists of two parts!!!!!!!!!!!!!!!!!!!!!!
        for (int i = 0; i < n; ++i) {
            // should exclude itself in the checking !!!!!!!!!!!!!!!!!!!!!!!!!
            // if (knows(candidate.get(0), i)) return -1;
            if (i != candidate.get(0) && knows(candidate.get(0), i)) return -1;
        }
        // checking consists of two parts!!!!!!!!!!!!!!!!!!!!!!
        for (int i = 0; i < n; ++i) {
            if (i != candidate.get(0) && !knows(i, candidate.get(0))) return -1;
        }
        return candidate.get(0);
    }
}
