package cn.sichu.graduate.practice.leetcode.interview;

import java.util.Arrays;

/**
 * 字符串 s1 ​ 和 s2 ​ 互为字符重排等价于「两个字符串排序后相等」
 * 
 * @author sichu
 * @date 2022/06/13
 */
public class Interview0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}
