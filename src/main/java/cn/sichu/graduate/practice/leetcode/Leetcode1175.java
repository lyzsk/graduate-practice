package cn.sichu.graduate.practice.leetcode;

/**
 * @author sichu
 * @date 2022/06/29
 */
public class Leetcode1175 {
    private static int mod = (int)(1e9 + 7);

    public int numPrimeArrangements(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                ++count;
            }
        }
        return (int)(factorial(count) * factorial(n - count) % mod);
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res = res * i % mod;
        }
        return res;
    }
}
