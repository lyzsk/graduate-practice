package cn.sichu.graduate.practice.leetcode.tencent50;

/**
 * 
 * @author sichu
 * @date 2022/06/10
 */
public class Tencent43 {
    // public boolean isPowerOfTwo(int n) {
    // return n > 0 && (n & (n - 1)) == 0;
    // }
    public boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 31; i++) {
            if (n == 1 << i) {
                return true;
            }
        }
        return false;
    }
}
