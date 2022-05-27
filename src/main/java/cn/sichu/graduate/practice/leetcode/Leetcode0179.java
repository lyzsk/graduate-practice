package cn.sichu.graduate.practice.leetcode;

import java.util.Arrays;

/**
 * 
 * @author sichu
 * @date 2022/05/27
 */
public class Leetcode0179 {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i] + "";
        }
        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo((s1 + s2)));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        int k = 0;
        while (k < sb.length() - 1 && sb.charAt(k) == '0') {
            ++k;
        }
        return sb.substring(k);
    }
}
