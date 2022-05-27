package cn.sichu.graduate.practice.leetcode.interview;

/**
 * 
 * @author sichu
 * @date 2022/05/27
 */
public class Interview1711 {
    public int findClosest(String[] words, String word1, String word2) {
        int res = words.length;
        for (int i = 0, p = -1, q = -1; i < words.length; i++) {
            String tmp = words[i];
            if (tmp.equals(word1)) {
                p = i;
            }
            if (tmp.equals(word2)) {
                q = i;
            }
            if (p != -1 && q != -1) {
                res = Math.min(res, Math.abs(p - q));
            }
        }
        return res;
    }
}
