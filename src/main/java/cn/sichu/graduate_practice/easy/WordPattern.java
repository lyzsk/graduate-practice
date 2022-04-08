package cn.sichu.graduate_practice.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/word-pattern/
 * 
 * @author sichu
 * @date 2022/04/08
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> str2ch = new HashMap<String, Character>();
        Map<Character, String> ch2str = new HashMap<Character, String>();

        int i = 0;
        for (int p = 0; p < pattern.length(); p++) {
            char ch = pattern.charAt(p);

            if (i >= s.length()) {
                return false;
            }

            int j = i;
            while (j < s.length() && s.charAt(j) != ' ') {
                j++;
            }
            String tmp = s.substring(i, j);
            if ((str2ch.containsKey(tmp) && str2ch.get(tmp) != ch)
                || (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch)))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1;
        }

        return i >= s.length();
    }
}
