package cn.sichu.graduate.practice.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sichu
 * @date 2022/06/10
 */
public class Hot009 {
    private static String[] letterMap = {"", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        StringBuilder path = new StringBuilder();
        backtrack(res, path, digits, 0);
        return res;
    }

    private static void backtrack(List<String> res, StringBuilder path, String digits, int startIndex) {
        if (startIndex == digits.length()) {
            res.add(path.toString());
            return;
        }
        String letters = letterMap[digits.charAt(startIndex) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtrack(res, path, digits, startIndex + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
