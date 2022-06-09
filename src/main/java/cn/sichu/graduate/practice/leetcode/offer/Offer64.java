package cn.sichu.graduate.practice.leetcode.offer;

/**
 * 1 + 2 + ... + n -> n * (n - 1) / 2 -> n * (n + 1) >> 1
 * 
 * @author sichu
 * @date 2022/06/08
 */
public class Offer64 {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
