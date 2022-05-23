package cn.sichu.graduate.practice.codetop.backend;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sichu
 * @date 2022/05/22
 */
public class CodeTop0044 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) {
            return res;
        }
        StringBuilder path = new StringBuilder();
        backtrack(res, path, n, 0, 0);
        return res;
    }

    private static void backtrack(List<String> res, StringBuilder path, int n, int left, int right) {
        if (left == n && right == n) {
            res.add(new StringBuilder(path).toString());
            return;
        }
        if (left < right) {
            return;
        }
        if (left < n) {
            backtrack(res, path.append("("), n, left + 1, right);
            path.deleteCharAt(path.length() - 1);
        }
        if (right < n) {
            backtrack(res, path.append(")"), n, left, right + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
