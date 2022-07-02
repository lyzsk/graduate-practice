package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/06/30
 */
public class Leetcode0241 {
    private static final int ADDITION = -1;
    private static final int SUBTRACTION = -2;
    private static final int MULTIPLICATION = -3;

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ops = new ArrayList<Integer>();
        for (int i = 0; i < expression.length();) {
            if (!Character.isDigit(expression.charAt(i))) {
                if (expression.charAt(i) == '+') {
                    ops.add(ADDITION);
                } else if (expression.charAt(i) == '-') {
                    ops.add(SUBTRACTION);
                } else {
                    ops.add(MULTIPLICATION);
                }
                ++i;
            } else {
                int digit = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    digit = digit * 10 + expression.charAt(i) - '0';
                    ++i;
                }
                ops.add(digit);
            }
        }
        List<Integer>[][] dp = new List[ops.size()][ops.size()];
        for (int i = 0; i < ops.size(); i++) {
            for (int j = 0; j < ops.size(); j++) {
                dp[i][j] = new ArrayList<Integer>();
            }
        }
        return dfs(dp, 0, ops.size() - 1, ops);
    }

    private static List<Integer> dfs(List<Integer>[][] dp, int left, int right, List<Integer> ops) {
        if (dp[left][right].isEmpty()) {
            if (left == right) {
                dp[left][right].add(ops.get(left));
            } else {
                for (int i = left; i < right; i += 2) {
                    List<Integer> l = dfs(dp, left, i, ops);
                    List<Integer> r = dfs(dp, i + 2, right, ops);
                    for (int lv : l) {
                        for (int rv : r) {
                            if (ops.get(i + 1) == ADDITION) {
                                dp[left][right].add(lv + rv);
                            } else if (ops.get(i + 1) == SUBTRACTION) {
                                dp[left][right].add(lv - rv);
                            } else {
                                dp[left][right].add(lv * rv);
                            }
                        }
                    }
                }
            }
        }
        return dp[left][right];
    }
}
