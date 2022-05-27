package cn.sichu.graduate.practice.leetcode;

/**
 * 
 * @author sichu
 * @date 2022/05/25
 */
public class Leetcode0214 {
    public String shortestPalindrome(String s) {
        String ss = s + "#" + new StringBuilder(s).reverse();
        int max = getLastNext(ss);
        return new StringBuilder(s.substring(max)).reverse() + s;
    }

    private static int getLastNext(String s) {
        char[] arr = s.toCharArray();
        int[] next = new int[s.length() + 1];
        next[0] = -1;
        next[1] = 0;
        int k = 0;
        int i = 2;
        while (i <= s.length()) {
            if (k == -1 || arr[i - 1] == arr[k]) {
                next[i] = k + 1;
                ++k;
                ++i;
            } else {
                k = next[k];
            }
        }
        return next[s.length()];
    }
}
