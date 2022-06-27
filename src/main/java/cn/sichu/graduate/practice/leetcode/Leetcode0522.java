package cn.sichu.graduate.practice.leetcode;

import java.util.Arrays;

/**
 * 一个较长的字符串肯定不会是一个较短字符串的子序列，那么只需要从长到短判断，每一个字符串是否为其他长度不小于它的字符串的子序列就行了
 * 
 * @author sichu
 * @date 2022/06/27
 */
public class Leetcode0522 {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (o1, o2) -> o2.length() - o1.length());
        for (int i = 0; i < strs.length; i++) {
            if (!isSubSeqOfAnother(strs, i)) {
                return strs[i].length();
            }
        }
        return -1;
    }

    private static boolean isSubSeqOfAnother(String[] strs, int idx) {
        for (int i = 0; i < strs.length; i++) {
            if (i == idx) {
                continue;
            }
            if (strs[i].length() < strs[idx].length()) {
                break;
            }
            if (isSubSeq(strs[idx], strs[i])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSubSeq(String s1, String s2) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < s1.length() && p2 < s2.length()) {
            while (p2 < s2.length() && s2.charAt(p2) != s1.charAt(p1)) {
                ++p2;
            }
            if (p2 < s2.length()) {
                ++p1;
            }
            ++p2;
        }
        return p1 == s1.length();
    }
}
