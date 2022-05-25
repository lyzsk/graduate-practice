package cn.sichu.graduate.practice.leetcode;

/**
 * 1 2 3 4<br>
 * 0 5 6 7<br>
 * -------
 * <p>
 * 1 2 3 4<br>
 * 0 0 0 7<br>
 * -------<br>
 * 8 6 3 8
 * <p>
 * 0 1 2 3 4<br>
 * 0 0 0 6 0<br>
 * ---------<br>
 * 7 4 0 4 0
 * <p>
 * 0 0 1 2 3 4<br>
 * 0 0 0 5 0 0<br>
 * -----------<br>
 * 6 1 7 0 0 0
 * <p>
 * 8638 + 74040 + 617000
 * 
 * @author sichu
 * @date 2022/05/25
 */
public class Leetcode0043 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String res = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder cur = new StringBuilder();
            int carry = 0;
            for (int j = num2.length() - 1; j > i; j--) {
                cur.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + carry;
                cur.append(product % 10);
                carry = product / 10;
            }
            if (carry != 0) {
                cur.append(carry % 10);
            }
            res = addStrings(res, cur.reverse().toString());
        }
        return res;
    }

    private static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            res.append(sum % 10);
            carry = sum / 10;
            --i;
            --j;
        }
        return res.reverse().toString();
    }
}
