package cn.sichu.graduate.practice.leetcode.offer;

/**
 * 
 * @author sichu
 * @date 2022/05/29
 */
public class Offer15 {
    /**
     * 不停的位运算 n & (n - 1), 使每次运算后，n最低位的 1 被翻转为0， 直到 n == 0，即是： 翻转 1 的个数
     * 
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            ++res;
        }
        return res;
    }
}
