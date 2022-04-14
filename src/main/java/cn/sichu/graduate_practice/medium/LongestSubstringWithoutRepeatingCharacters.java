package cn.sichu.graduate_practice.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author sichu
 * @date 2022/04/14
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int right = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (right <= s.length() && !set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                ++right;
            }
            res = Math.max(res, right - i);
        }
        return res;
    }
}
