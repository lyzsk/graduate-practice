package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode.cn/problems/verifying-an-alien-dictionary/
 * 
 * @author sichu
 * @date 2022/05/17
 */
public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orders[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!valid(orders, words[i], words[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean valid(int[] orders, String word1, String word2) {
        int i1 = 0;
        int i2 = 0;
        for (; i1 < word1.length() && i2 < word2.length(); i1++, i2++) {
            if (orders[word1.charAt(i1) - 'a'] < orders[word2.charAt(i2) - 'a']) {
                return true;
            }
            if (orders[word1.charAt(i1) - 'a'] > orders[word2.charAt(i2) - 'a']) {
                return false;
            }
        }
        return i1 == word1.length();
    }
}
