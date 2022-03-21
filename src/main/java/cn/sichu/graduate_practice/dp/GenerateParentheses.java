package cn.sichu.graduate_practice.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href = "https://leetcode-cn.com/problems/generate-parentheses/">22. 括号生成</a>
 * @see <a href = "https://leetcode.com/problems/generate-parentheses/">22. Generate Parentheses</a>
 * @author sichu
 * @date 2022/03/21
 */
public class GenerateParentheses {
    /**
     * 回溯
     * 
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        backtrack(n, new StringBuffer(), 0, 0, res);
        return res;
    }

    private void backtrack(int n, StringBuffer path, int leftCount, int rightCount, List<String> res) {
        if (path.length() == n * 2) {
            res.add(path.toString());
            return;
        }

        if (leftCount < n) {
            path.append("(");
            backtrack(n, path, leftCount + 1, rightCount, res);
            path.deleteCharAt(path.length() - 1);
        }
        if (rightCount < leftCount) {
            path.append(")");
            backtrack(n, path, leftCount, rightCount + 1, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
