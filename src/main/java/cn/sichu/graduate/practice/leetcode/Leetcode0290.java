package cn.sichu.graduate.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sichu
 * @date 2022/06/04
 */
public class Leetcode0290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> ch2str = new HashMap<Character, String>();
        Map<String, Character> str2ch = new HashMap<String, Character>();
        int left = 0;
        for (int p = 0; p < pattern.length(); p++) {
            char ch = pattern.charAt(p);
            if (left >= s.length()) {
                return false;
            }
            int right = left;
            while (right < s.length() && s.charAt(right) != ' ') {
                ++right;
            }
            String tmp = s.substring(left, right);
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            left = right + 1;
        }
        return left >= s.length();
    }
}
