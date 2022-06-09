package cn.sichu.graduate.practice.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sichu
 * @date 2022/06/09
 */
public class Hot003 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s == null || s.length() == 0) {
            return res;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int left = 0, right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
