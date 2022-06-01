package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 类似的题： Leetcode0046， Leetcode0047, Leetcode0039, Leetcode0040, <b>Leetcode0077</b>, Leetcode0078, Leetcode0090,
 * <b>Leetcode0060</b>, Leetcode0093, Leetcode0733, Leetcode0200, Leetcode0130, Leetcode0079, Leetcode0017,
 * <b>Leetcode0784</b>, Leetcode0022, Leetcode0051, Leetcode0037, Leetcode0488, Leetcode0529
 * 
 * 
 * @author sichu
 * @date 2022/05/31
 */
public class Leetcode0017 {
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
