package cn.sichu.graduate_practice.offer;

/**
 * https://leetcode.cn/problems/jian-sheng-zi-lcof/
 * 
 * @author sichu
 * @date 2022/05/19
 */
public class Offer14 {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;

        if (b == 0) {
            return (int)Math.pow(3, a);
        }
        if (b == 1) {
            return (int)Math.pow(3, a - 1) * 4;
        }
        return (int)Math.pow(3, a) * 2;
    }
}
