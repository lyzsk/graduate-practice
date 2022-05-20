package cn.sichu.graduate_practice.codetop;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 频率51
 * <p>
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 * 
 * @author sichu
 * @date 2022/05/19
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
