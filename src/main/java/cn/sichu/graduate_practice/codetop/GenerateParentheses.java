package cn.sichu.graduate_practice.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * 频率48
 * <p>
 * https://leetcode.cn/problems/generate-parentheses/
 * 
 * @author sichu
 * @date 2022/05/10
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        StringBuilder path = new StringBuilder();
        backtrack(n, res, path, 0, 0);
        return res;
    }

    private static void backtrack(int n, List<String> res, StringBuilder path, int leftCount, int rightCount) {
        if (path.length() == n * 2) {
            res.add(path.toString());
            return;
        }
        if (leftCount < n) {
            path.append("(");
            backtrack(n, res, path, leftCount + 1, rightCount);
            path.deleteCharAt(path.length() - 1);
        }
        if (rightCount < leftCount) {
            path.append(")");
            backtrack(n, res, path, leftCount, rightCount + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
