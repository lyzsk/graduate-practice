package cn.sichu.graduate_practice.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 * 
 * @author sichu
 * @date 2022/04/16
 */
public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int right = -1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                ++right;
            }
            res = Math.max(res, right - i + 1);
        }
        return res;
    }
}
