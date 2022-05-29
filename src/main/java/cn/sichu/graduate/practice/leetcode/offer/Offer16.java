package cn.sichu.graduate.practice.leetcode.offer;

/**
 * 
 * @author sichu
 * @date 2022/05/29
 */
public class Offer16 {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMulti(x, N) : 1.0 / quickMulti(x, -N);
    }

    private static double quickMulti(double x, long N) {
        double res = 1.0;
        double contribute = x;
        while (N > 0) {
            if ((N & 1) == 1) {
                res *= contribute;
            }
            contribute *= contribute;
            N = N >> 1;
        }
        return res;
    }
}
