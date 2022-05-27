package cn.sichu.graduate.practice.leetcode;

/**
 * 
 * @author sichu
 * @date 2022/05/27
 */
public class Leetcode0014 {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for (int i = 0; i < strs.length; i++) {
            res = longestCommonPrefix(res, strs[i]);
            if (res.length() == 0) {
                break;
            }
        }
        return res;
    }

    private static String longestCommonPrefix(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        int idx = 0;
        while (idx < minLength && str1.charAt(idx) == str2.charAt(idx)) {
            ++idx;
        }
        return str1.substring(0, idx);
    }
}
