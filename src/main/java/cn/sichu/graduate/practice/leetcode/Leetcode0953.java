package cn.sichu.graduate.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sichu
 * @date 2022/05/20
 */
public class Leetcode0953 {
    // public boolean isAlienSorted(String[] words, String order) {
    // int[] ord = new int[26];
    // for (int i = 0; i < 26; i++) {
    // ord[order.charAt(i) - 'a'] = i;
    // }
    // String[] clone = words.clone();
    // Arrays.sort(clone, (o1, o2) -> {
    // int i = 0;
    // int j = 0;
    // while (i < o1.length() && j < o2.length()) {
    // int ch1 = o1.charAt(i) - 'a';
    // int ch2 = o2.charAt(j) - 'a';
    // if (ch1 != ch2) {
    // return ord[ch1] - ord[ch2];
    // }
    // ++i;
    // ++j;
    // }
    // if (i < o1.length()) {
    // return 1;
    // }
    // if (j < o2.length()) {
    // return -1;
    // }
    // return 0;
    // });
    // for (int i = 0; i < words.length; i++) {
    // if (!clone[i].equals(words[i])) {
    // return false;
    // }
    // }
    // return true;
    // }
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
