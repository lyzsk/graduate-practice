package cn.sichu.graduate.practice.leetcode;

/**
 * 假设 n = [a, a + k - 1] 的等差数列, 项数为 k
 * <p>
 * n = (a + a + k - 1 ) * k / 2 <br>
 * -> a * k = n - (k - 1 ) * k / 2<br>
 * -> (k - 1) * k / 2 < n && (n - (k - 1) * k / 2 能被 k 整除
 * 
 * @author sichu
 * @date 2022/06/02
 */
public class Leetcode0829 {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        for (int i = 1; i * (i - 1) / 2 < n; i++) {
            int tmp = n - i * (i - 1) / 2;
            if (tmp % i == 0) {
                ++count;
            }
        }
        return count;
    }
}
