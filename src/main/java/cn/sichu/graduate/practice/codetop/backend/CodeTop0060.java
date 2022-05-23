package cn.sichu.graduate.practice.codetop.backend;

/**
 * 
 * @author sichu
 * @date 2022/05/22
 */
public class CodeTop0060 {
    public int climbStairs(int n) {
        int f0 = 0;
        int f1 = 0;
        int dp = 1;
        for (int i = 1; i <= n; i++) {
            f0 = f1;
            f1 = dp;
            dp = f0 + f1;
        }
        return dp;
    }
}
