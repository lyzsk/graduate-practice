package cn.sichu.graduate_practice.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * 频率2
 * <p>
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author sichu
 * @date 2022/05/05
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int res = 0;

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
