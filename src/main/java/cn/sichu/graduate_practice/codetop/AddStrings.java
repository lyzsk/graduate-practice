package cn.sichu.graduate_practice.codetop;

/**
 * 频率25
 * <p>
 * https://leetcode-cn.com/problems/add-strings/
 * 
 * @author sichu
 * @date 2022/05/08
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int res = x + y + carry;
            sb.append(res % 10);
            carry = res / 10;
            --i;
            --j;
        }
        // 反转
        sb.reverse();
        return sb.toString();
    }
}
