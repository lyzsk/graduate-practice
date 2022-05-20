package cn.sichu.graduate.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sichu
 * @date 2022/05/20
 */
public class Leetcode0953 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < 26; i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String str1 = words[i];
            String str2 = words[i + 1];
            boolean smaller = false;
            for (int j = 0; j < Math.min(str1.length(), str2.length()); j++) {
                if (map.get(str1.charAt(j)) < map.get(str2.charAt(j))) {
                    smaller = true;
                    break;
                } else if (map.get(str1.charAt(j)) > map.get(str2.charAt(j))) {
                    return false;
                }
            }
            if (!smaller && str1.length() > str2.length()) {
                return false;
            }
        }
        return true;
    }
}
