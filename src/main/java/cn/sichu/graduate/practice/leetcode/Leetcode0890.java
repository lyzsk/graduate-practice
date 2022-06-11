package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author sichu
 * @date 2022/06/11
 */
public class Leetcode0890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            if (match(words[i], pattern) && match(pattern, words[i])) {
                res.add(words[i]);
            }
        }
        return res;
    }

    private static boolean match(String word, String pattern) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < word.length(); i++) {
            char ch1 = word.charAt(i);
            char ch2 = pattern.charAt(i);
            if (!map.containsKey(ch1)) {
                map.put(ch1, ch2);
            } else if (map.get(ch1) != ch2) {
                return false;
            }
        }
        return true;
    }
}
