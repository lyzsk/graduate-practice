package cn.sichu.graduate.practice.leetcode.leetcode75level1;

/**
 * @author sichu
 * @date 2022/07/15
 */
public class Leetcode0844 {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0;
        int skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    ++skipS;
                    --i;
                } else if (skipS > 0) {
                    --skipS;
                    --i;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    ++skipT;
                    --j;
                } else if (skipT > 0) {
                    --skipT;
                    --j;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            --i;
            --j;
        }
        return true;
    }
}
