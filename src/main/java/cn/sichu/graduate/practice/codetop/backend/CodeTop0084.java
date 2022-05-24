package cn.sichu.graduate.practice.codetop.backend;

/**
 * 0-12共13个数构成一个环，从0出发，每次走1步，走n步回到0共有多少种走法（2020.09 字节跳动-广告-后端
 * <p>
 * 0-8组成一个圆环，从0出发，每次可以逆时针和顺时针走，走n步能回到0有多少种情况（2020.09 字节跳动-people-后端）
 * <p>
 * 0~9的环，从0出发，N步后能否走回0。（2020.07 字节跳动-电商-后端）
 * <p>
 * 问题： 圆环上有10个点，编号为0~9。从0点出发，每次可以逆时针和顺时针走一步，问走n步回到0点共有多少种走法。<br>
 * 输入: 2<br>
 * 输出: 2<br>
 * 解释：有2种方案。分别是0->1->0和0->9->0
 * <p>
 * 分析： 走i步走到j的有n中方法 等于 {走i-1步到 j-1} + {走 i-1步到j+1}: {@code dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];}
 * <p>
 * 因为有回环，所以需要走到j-1可能为负数: {@code dp[i][j] = dp[i-1][(j-1+length)%length] + dp[i-1][(j+1)%length];}
 * 
 * @author sichu
 * @date 2022/05/24
 */
public class CodeTop0084 {
    public int backToOrigin(int k) {
        int[][] dp = new int[k + 1][10];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + 10) % 10] + dp[i - 1][(j + 1) % 10];
            }
        }
        return dp[k][0];
    }

    public int backToOrigin(int n, int k) {
        if (n == 0) {
            return 1;
        }
        if (n == 2) {
            if (k % 2 == 0) {
                return k;
            } else {
                return 0;
            }
        }
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + n) % n] + dp[i - 1][(j + 1) % n];
            }
        }
        return dp[k][0];
    }
}
