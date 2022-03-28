package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/plus-one/
 * 
 * @author sichu
 * @date 2022/03/28
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + carry;
                carry = 0;
            } else {
                if (carry == 1) {
                    digits[i] = 0;
                    carry = 1;
                }
            }
        }

        if (carry == 1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }
}
