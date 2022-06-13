package cn.sichu.graduate.practice.leetcode.offer;

/**
 * 
 * @author sichu
 * @date 2022/05/26
 */
public class Offer66 {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
