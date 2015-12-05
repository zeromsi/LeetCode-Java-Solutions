/**
 * @see <a href="https://leetcode.com/problems/flip-game/">Flip Game</a>
 */

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        int iPlus = 0;
        List<String> ls = new ArrayList<String>();
        while (true) {
            while (iPlus < s.length() && s.charAt(iPlus) != '+') iPlus ++;
            if (s.length() == iPlus) break;
            int iMinus = iPlus;
            
            // wrong answer caused by using s.charAt(iPlus) == '+' in the following line. !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
            while (iMinus < s.length() && s.charAt(iMinus) == '+') iMinus ++;
            
            // generate the list given iPlus, and iMinus.
            if (iMinus == iPlus + 1) {
                ; // no possible strings
            }
            else {
                for (int i = iPlus; i <= iMinus - 2; i++) {
                    String str = s.substring(0, i) + "--" + s.substring(i + 2);
                    ls.add(str);
                }
            }
            
            iPlus = iMinus;
        }
        return ls;
    }
}
