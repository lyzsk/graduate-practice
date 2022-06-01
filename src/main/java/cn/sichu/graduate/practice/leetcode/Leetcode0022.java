package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 类似的题： Leetcode0046， Leetcode0047, Leetcode0039, Leetcode0040, <b>Leetcode0077</b>, Leetcode0078, Leetcode0090,
 * <b>Leetcode0060</b>, Leetcode0093, Leetcode0733, Leetcode0200, Leetcode0130, Leetcode0079, Leetcode0017,
 * <b>Leetcode0784</b>, Leetcode0022, Leetcode0051, Leetcode0037, Leetcode0488, Leetcode0529
 * 
 * @author sichu
 * @date 2022/05/29
 */
public class Leetcode0022 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        StringBuilder path = new StringBuilder();
        backtrack(res, path, n, 0, 0);
        return res;
    }

    private static void backtrack(List<String> res, StringBuilder path, int n, int leftCount, int rightCount) {
        if (path.length() == n * 2) {
            res.add(path.toString());
            return;
        }
        if (leftCount < n) {
            path.append('(');
            backtrack(res, path, n, leftCount + 1, rightCount);
            path.deleteCharAt(path.length() - 1);
        }
        if (rightCount < leftCount) {
            path.append(')');
            backtrack(res, path, n, leftCount, rightCount + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
