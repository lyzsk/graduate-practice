package cn.sichu.graduate.practice.leetcode.offerii;

/**
 * 
 * @author sichu
 * @date 2022/05/21
 */
public class OfferII003 {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }
}
