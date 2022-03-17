package cn.sichu.graduate_practice.array;

/**
 * @see <a href = "https://leetcode-cn.com/problems/plus-one/">66. 加一</a>
 * @see <a href = "https://leetcode.com/problems/plus-one/">66. Plus One</a>
 * @author sichu
 * @date 2022/03/17
 */
public class PlusOne {
    /**
     * Time Complexity: O(n)
     * <p>
     * Space Complexity: O(1);
     * 
     * @param digits
     * @return
     */
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
        /**
         * 全部是9
         */
        if (carry == 1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }
}
