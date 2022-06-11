package cn.sichu.graduate.practice.leetcode.tencent50;

/**
 * @author sichu
 * @date 2022/06/11
 */
public class Tencent08 {
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
        int i = 0;
        while (i < minLength && str1.charAt(i) == str2.charAt(i)) {
            ++i;
        }
        return str1.substring(0, i);
    }
}
