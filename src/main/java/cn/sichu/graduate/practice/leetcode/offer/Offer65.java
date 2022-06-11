package cn.sichu.graduate.practice.leetcode.offer;

/**
 * 无进位和 与 异或运算 规律相同，进位 和 与运算 规律相同（并需左移一位）
 * 
 * @author sichu
 * @date 2022/06/10
 */
public class Offer65 {
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        return add(a ^ b, (a & b) << 1);
    }
}
