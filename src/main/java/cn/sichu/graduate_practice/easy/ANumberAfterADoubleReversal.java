package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/a-number-after-a-double-reversal/
 * 
 * @author sichu
 * @date 2022/04/06
 */
public class ANumberAfterADoubleReversal {
    public boolean isSameAfterReversals(int num) {
        return num == 0 || num % 10 != 0;
    }
}
