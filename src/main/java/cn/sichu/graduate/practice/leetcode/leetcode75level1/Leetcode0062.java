package cn.sichu.graduate.practice.leetcode.leetcode75level1;

/**
 * @author sichu
 * @date 2022/07/14
 */
public class Leetcode0062 {
    public int uniquePaths(int m, int n) {
        long res = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            res = res * x / y;
        }
        return (int)res;
    }
}
