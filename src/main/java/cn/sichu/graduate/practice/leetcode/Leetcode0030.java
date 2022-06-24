package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/06/23
 */
public class Leetcode0030 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int wordLength = words[0].length();
        Map<String, Integer> wordFreq = new HashMap<String, Integer>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < words.length; i++) {
            wordFreq.put(words[i], wordFreq.getOrDefault(words[i], 0) + 1);
        }
        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> window = new HashMap<String, Integer>();
            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;
                if (!wordFreq.containsKey(word)) {
                    count = 0;
                    left = right;
                    window.clear();
                } else {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    ++count;
                    while (window.getOrDefault(word, 0) > wordFreq.getOrDefault(word, 0)) {
                        String tmp = s.substring(left, left + wordLength);
                        --count;
                        window.put(tmp, window.getOrDefault(tmp, 0) - 1);
                        left += wordLength;
                    }
                    if (count == words.length) {
                        res.add(left);
                    }
                }
            }
        }
        return res;
    }
}
