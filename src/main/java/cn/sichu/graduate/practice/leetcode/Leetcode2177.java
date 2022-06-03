package cn.sichu.graduate.practice.leetcode;

/**
 * 
 * @author sichu
 * @date 2022/06/02
 */
public class Leetcode2177 {
    public long[] sumOfThree(long num) {
        if (num % 3 != 0) {
            return new long[] {};
        }
        long tripart = num / 3;
        return new long[] {tripart - 1, tripart, tripart + 1};
    }
}
